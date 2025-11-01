import SwiftUI
import GoogleMaps

@main
struct iOSApp: App {
    init() {
        GMSServices.provideAPIKey(YOUR_MAP_KEY)
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
