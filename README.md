
# react-native-doorbell

## Getting started

`$ npm install react-native-doorbell --save`

### Mostly automatic installation

`$ react-native link react-native-doorbell`

### Manual installation


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
  	```


## Usage
```javascript
import RNDoorbell from 'react-native-doorbell';

// TODO: What to do with the module?
RNDoorbell;
```
  