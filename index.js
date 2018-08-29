/// <reference path="index.d.ts"/>
import { NativeModules } from 'react-native';

const { RNDoorbell } = NativeModules;

export class Doorbell {
  constructor(appId, apiKey) {
    this.appId = appId;
    this.apiKey = apiKey;
  }

  show(options = {}) {
    RNDoorbell.show(this.appId, this.apiKey, options);
  }
};

export default Doorbell;
