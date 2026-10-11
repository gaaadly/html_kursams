package lt.techin.oop;

public class SmartDevice extends Device {

    private String app;


    public SmartDevice(String serialNumber,Battery battery,String app) {
        super(serialNumber,battery);
        this.app = app;
    }

    public String openApp() {
        // TODO: implement the contract in README.md / README.lt.md.
        return "Opening app: " + app;
    }
}