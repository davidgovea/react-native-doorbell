
#import "Doorbell/Doorbell.h"
#import "RNDoorbell.h"

@implementation RNDoorbell

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(NSString *)appId apiKey:(NSString *)apiKey)
{
    UIViewController *rootViewController = [UIApplication sharedApplication].delegate.window.rootViewController;
    Doorbell *feedback = [Doorbell doorbellWithApiKey:apiKey appId:appId];
    [feedback showFeedbackDialogInViewController:rootViewController completion:^(NSError *error, BOOL isCancelled) {
        if (error) {
            NSLog(@"%@", error.localizedDescription);
        }
    } animated:true];
}

@end
  