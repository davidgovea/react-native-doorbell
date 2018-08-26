
#import "Doorbell/Doorbell.h"
#import "RNDoorbell.h"

@implementation RNDoorbell

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(NSString *)appId location:(NSString *)doorbellWithApiKey)
{
    Doorbell *feedback = [Doorbell doorbellWithApiKey:appKey appId:appId];
    [feedback showFeedbackDialogInViewController:self completion:^(NSError *error, BOOL isCancelled) {
        if (error) {
            NSLog(@"%@", error.localizedDescription);
        }
    } animated:true];
}

@end
  