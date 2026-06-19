public class Main {
    public static void main(String[] args) {
        // Create PowerSources
        PowerSource battery = new PowerSource("Battery");
        PowerSource electric = new PowerSource("Electric");

        // Create devices with constructor DI
        SmartLight smartLight = new SmartLight(battery);
        SmartThermostat smartThermostat = new SmartThermostat(electric);

        // Set WiFiModule using setter DI
        WiFiModule wifiLight = new WiFiModule("HomeWiFi_Light");
        WiFiModule wifiThermostat = new WiFiModule("HomeWiFi_Thermostat");

        smartLight.setWiFiModule(wifiLight);
        smartThermostat.setWiFiModule(wifiThermostat);

        // Display details
        smartLight.showDeviceDetails();
        smartThermostat.showDeviceDetails();
    }
}
