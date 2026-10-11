package lt.techin.oop;

public class Device {

    private String serialNumber;
    private Battery battery;


    public Device(String serialNumber,Battery battery) {
        // TODO: implement the contract in README.md / README.lt.md.
        this.serialNumber = serialNumber;
        this.battery = battery;
    }

    public final String getSerialNumber() {
        // TODO: implement the contract in README.md / README.lt.md.
        return serialNumber;
    }

    public int getBatteryCapacity() {
        // TODO: implement the contract in README.md / README.lt.md.
        return battery.getCapacity();
    }
}