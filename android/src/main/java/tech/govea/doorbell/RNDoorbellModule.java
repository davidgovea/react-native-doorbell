
package tech.govea.doorbell;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import io.doorbell.android.Doorbell;
import android.app.Activity;

public class RNDoorbellModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNDoorbellModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNDoorbell";
  }

  @ReactMethod
  public void show(int appId, String apiKey/*, final Promise promise */) {
    Activity currentActivity = getCurrentActivity();
    new Doorbell(currentActivity, appId, apiKey).show();
  }
}
