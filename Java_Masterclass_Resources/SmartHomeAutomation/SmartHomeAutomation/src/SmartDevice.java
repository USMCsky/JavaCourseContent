public abstract class SmartDevice {
    private PowerSource powerSource;
    private WiFiModule wifiModule;

    public SmartDevice(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setWiFiModule(WiFiModule wifiModule) {
        this.wifiModule = wifiModule;
    }

    public WiFiModule getWiFiModule() {
        return wifiModule;
    }

    public abstract void showDeviceDetails();
}