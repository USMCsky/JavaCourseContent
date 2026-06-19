public class SmartThermostat extends SmartDevice {
    public SmartThermostat(PowerSource powerSource) {
        super(powerSource);
    }

    @Override
    public void showDeviceDetails() {
        System.out.println("SmartThermostat powered by " + getPowerSource().getType());

        if (getWiFiModule() != null) {
            System.out.println("Connected to WiFi: " + getWiFiModule().getSsid());
        }
    }
}