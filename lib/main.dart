import 'package:flutter/material.dart';
import 'package:moengage_flutter/app_status.dart';
import 'package:moengage_flutter/gender.dart';
import 'package:moengage_flutter/geo_location.dart';
import 'package:moengage_flutter/moengage_flutter.dart';
import 'package:moengage_flutter/properties.dart';
import 'package:package_info/package_info.dart';
import 'dart:async';

import 'package:shared_preferences/shared_preferences.dart';

void main() {
  SharedPreferences.setMockInitialValues({});
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final MoEngageFlutter _moengagePlugin = MoEngageFlutter();

  PackageInfo _packageInfo = PackageInfo(
    appName: 'Unknown',
    packageName: 'Unknown',
    version: 'Unknown',
    buildNumber: 'Unknown',
  );

  @override
  void initState() {
    super.initState();
    _moengagePlugin.initialise();
    _initPackageInfo();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Flutter Demo App"),
          centerTitle: true,
          backgroundColor: Colors.red,
        ),
        body: Center(
          child: Container(
            child: Column(
              children: [
                RaisedButton(
                  onPressed: _installUpdate,
                  child: Text("Install or update"),
                ),
                RaisedButton(
                  onPressed: () {
                    _moengagePlugin.setUniqueId("8708153354");
                  },
                  child: Text("Login"),
                ), RaisedButton(
                  onPressed: () {
                    _moengagePlugin.logout();
                  },
                  child: Text("Logout"),
                ), RaisedButton(
                  onPressed: () {
                    _moengagePlugin.setUserName("Vipin Kumar");
                    _moengagePlugin.setFirstName("Vipin");
                    _moengagePlugin.setLastName("Kumar");
                    _moengagePlugin.setEmail("vicky7230@gmail.com");
                    _moengagePlugin.setPhoneNumber("8708153354");
                    _moengagePlugin.setGender(MoEGender.male); // Supported values also include MoEGender.female OR MoEGender.other
                    _moengagePlugin.setLocation(new MoEGeoLocation(23.1, 21.2)); // Pass coordinates with MoEGeoLocation instance
                    _moengagePlugin.setBirthDate("2000-12-02T08:26:21.170Z"); // date format - ` yyyy-MM-dd'T'HH:mm:ss.fff'Z'`
                  },
                  child: Text("Track attributes"),
                ), RaisedButton(
                  onPressed: () {
                    var properties = MoEProperties();
                    properties.addAttribute( "test_string", "Apple")
                        .addAttribute("test_int", 789)
                        .addAttribute("test_bool", false)
                        .addAttribute("attr_double", 12.32)
                        .addAttribute("attr_location", new MoEGeoLocation( 12.1, 77.18) )
                        .addAttribute("attr_array", ["item1", "item2", "item3"])
                        .addISODateTime("attr_date", "2019-12-02T08:26:21.170Z");

                    _moengagePlugin.trackEvent('Flutter_test_Event', properties);
                  },
                  child: Text("Track Events"),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Future<void> _initPackageInfo() async {
    final PackageInfo info = await PackageInfo.fromPlatform();
    setState(() {
      _packageInfo = info;
    });
  }

  _installUpdate() async {
    debugPrint("Install or update");
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int code = prefs.getInt("version_code");
    if (code == null) {
      debugPrint("Fresh Install, version code : " + _packageInfo.buildNumber);
      _moengagePlugin.setAppStatus(MoEAppStatus.install);
    } else {
      if (int.parse(_packageInfo.buildNumber) > code) {
        debugPrint("Update, version code : " + _packageInfo.buildNumber);
        _moengagePlugin.setAppStatus(MoEAppStatus.update);
      } else {
        debugPrint("No action required for install or update");
      }
    }
    //set the new version
    code = int.parse(_packageInfo.buildNumber);
    await prefs.setInt("version_code", code);
  }
}
