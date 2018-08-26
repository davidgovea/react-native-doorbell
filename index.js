import { NativeModules } from 'react-native';

const { RNDoorbell } = NativeModules;

export class Doorbell {
  constructor(appId, apiKey) {
    this.appId = appId;
    this.apiKey = apiKey;
  }

  show() {
    RNDoorbell.show(this.appId, this.apiKey);
  }
};

export default Doorbell;