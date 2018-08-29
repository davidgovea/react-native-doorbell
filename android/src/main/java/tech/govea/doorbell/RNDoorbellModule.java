
package tech.govea.doorbell;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import io.doorbell.android.Doorbell;
import android.app.Activity;
import android.view.View;

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
  public void show(String appId, String apiKey, ReadableMap options/*, final Promise promise*/) {
    Activity currentActivity = getCurrentActivity();

    Doorbell doorbellDialog = new Doorbell(currentActivity, Integer.parseInt(appId), apiKey);

    ReadableMapKeySetIterator iterator = options.keySetIterator();

    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      ReadableType type = options.getType(key);

      if (key == "email") {
        doorbellDialog.setEmail(options.getString(key));
      } else if (key == "name") {
        doorbellDialog.setName(options.getString(key));
      } else if (key == "hideEmailField" && options.getBoolean(key) == true) {
        doorbellDialog.setEmailFieldVisibility(View.GONE);
      } else if (key == "hidePoweredBy" && options.getBoolean(key) == true) {
        doorbellDialog.setEmailFieldVisibility(View.GONE);
      } else if (key == "properties") {
        ReadableMap properties = options.getMap(key);
        ReadableMapKeySetIterator propertyIterator = properties.keySetIterator();
        while (propertyIterator.hasNextKey()) {
          String propertyName = propertyIterator.getNextKey();
          ReadableType type = propertyIterator.getType(key);

          // Accept String/Bool/Number custom props. TODO - consider int?
          switch (type) {
            case Boolean:
              doorbellDialog.addProperty(propertyName, readableMap.getBoolean(key));
              break;
            case Number:
              doorbellDialog.addProperty(propertyName, readableMap.getDouble(key));
              break;
            case String:
              doorbellDialog.addProperty(propertyName, readableMap.getString(key));
              break;
          }
        }
      }
    }

//    // Callback for when a message is successfully sent
//    doorbellDialog.setOnFeedbackSentCallback(new io.doorbell.android.callbacks.OnFeedbackSentCallback() {
//      @Override
//      public void handle(String message) {
//
//        // Show the message in a different way, or use your own message!
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
//      }
//    });
//
//    // Callback for when the dialog is shown
//    doorbellDialog.setOnShowCallback(new io.doorbell.android.callbacks.OnShowCallback() {
//      @Override
//      public void handle() {
//        Toast.makeText(context, "Dialog shown", Toast.LENGTH_LONG).show();
//      }
//    });

//    // Capture a screenshot of the current activity, to be sent to Doorbell
//    doorbellDialog.captureScreenshot();

    doorbellDialog.show();
  }
}
