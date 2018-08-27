
Pod::Spec.new do |s|
  s.name         = "RNDoorbell"
  s.version      = "0.0.1"
  s.summary      = "RNDoorbell"
  s.description  = <<-DESC
                  Unofficial React Native SDK Wrapper for Doorbell.io
                   DESC
  s.homepage     = "https://github.com/davidgovea/react-native-doorbell"
  s.license      = { :type => "WTFPL", :file => "LICENSE" }
  s.author       = { "author" => "david@govea.tech" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/davidgovea/react-native-doorbell", :tag => "master" }
  s.source_files = "ios/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  s.dependency "Doorbell", "~> 0.1.2"

end

