# react-native-doorbell
---

An unofficial React Native SDK wrapper for the [Doorbell.io](https://doorbell.io) user feedback platform.

## Getting started

`$ npm install react-native-doorbell --save`

## Status

* Works on iOS and Android
* Name, email, and field hiding work (have not tested the 'powered by' removal)
* Custom properties **may not work** on Android (development WIP)

## Usage
```javascript
import Doorbell from 'react-native-doorbell';

const doorbellDialog = new Doorbell(APP_ID, API_KEY);

doorbellDialog.show();

// or..

doorbellDialog.show({
  email: 'User email', // optional
  name: 'User name', // optional
  hideEmailField: true, // optional, default false
  hidePoweredBy: true, // optional, default false
  properties: {
    customProperty: 'value', // optional custom properties
  }
});
```

### Mostly automatic installation

`$ react-native link react-native-doorbell`
You must be using CocoaPods for linking to work properly, since the official Doorbell SDK is included as a pod.
(manual installation is possible, but not documented yet)

<!-- ### Manual installation

TODO - specify this further. Doorbell pod still needs to be installed

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-doorbell` and add `RNDoorbell.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDoorbell.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import tech.govea.doorbell.RNDoorbellPackage;` to the imports at the top of the file
  - Add `new RNDoorbellPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-doorbell'
  	project(':react-native-doorbell').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-doorbell/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-doorbell')
  	``` -->
