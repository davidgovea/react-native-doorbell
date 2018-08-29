
#import "Doorbell/Doorbell.h"
#import "RNDoorbell.h"

@implementation RNDoorbell

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(NSString *)appId apiKey:(NSString *)apiKey options:(NSDictionary *)options)
{
    UIViewController *rootViewController = [UIApplication sharedApplication].delegate.window.rootViewController;
    Doorbell *feedback = [Doorbell doorbellWithApiKey:apiKey appId:appId];

    for (id key in options) {
      if ([key isEqualToString:@"email"]) {
        feedback.email = [options objectForKey:key]
      } else if ([key isEqualToString:@"name"]) {
        feedback.name = [options objectForKey:key]
      } else if ([key isEqualToString:@"hideEmailField"]) {
        feedback.showEmail = false; // TODO - actually check option val
      } else if ([key isEqualToString:@"hidePoweredBy"]) {
        feedback.showPoweredBy = false; // TODO - actually check option val
      } else if ([key isEqualToString:@"properties"]) {
        NSDictionary *properties = [options objectForKey:key];
        for (id propertyName in properties) {
          [feedback addPropertyWithName:propertyName AndValue:[properties objectForKey:propertyName]];
        }
      }
    }

    [feedback showFeedbackDialogInViewController:rootViewController completion:^(NSError *error, BOOL isCancelled) {
        if (error) {
            NSLog(@"%@", error.localizedDescription);
        }
    } animated:true];
}

@end
