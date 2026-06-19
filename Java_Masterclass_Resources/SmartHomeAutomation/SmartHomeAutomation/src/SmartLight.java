public class SmartLight extends SmartDevice {
    public SmartLight(PowerSource powerSource) {
        super(powerSource);
    }

    @Override
    public void showDeviceDetails() {
        System.out.println("SmartLight powered by " + getPowerSource().getType());
        if (getWiFiModule() != null) {
            System.out.println("Connected to WiFi: " + getWiFiModule().getSsid());
        }
    }
}