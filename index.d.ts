
interface DoorbellShowOptioons {
  email?: string
  name?: string
  properties?: {
    [propertyName: string]: string | boolean | number
  }
  hideEmailField?: boolean
  hidePoweredBy?: boolean
}

// interface DoorbellShowResult {
//   cancelled: boolean
//   message?: string
// }

export class Doorbell {
  appId: string
  apiKey: string
  constructor(appId: string, apiKey: string)
  show(options?: DoorbellShowOptioons): void //Promise<DoorbellShowResult>;
}

export default Doorbell;
