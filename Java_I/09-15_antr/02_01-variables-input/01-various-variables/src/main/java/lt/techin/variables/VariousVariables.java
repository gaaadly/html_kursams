package lt.techin.variables;

public class VariousVariables {
    public static void main(String[] args) {
        int byteCount = 9000;
        double cpuLoad = 0.1;
        String compiler = "javac";
        int modules;

        System.out.println("Bytes:");
        System.out.println(byteCount);
        System.out.println("CPU load:");
        System.out.println(cpuLoad);
        System.out.println("Compiler:");
        System.out.println(compiler);
        System.out.println("");
        System.out.println("And finally, a summary:");
        System.out.println(byteCount);
        System.out.println(cpuLoad);
        System.out.println(compiler);
        modules = 4;
        System.out.println("Modules before: " + modules);
        modules = 6;
        System.out.println("Modules after: " + modules);
        char driveLetter = 'C';
        System.out.println("Drive letter: "  + driveLetter);
        boolean compiled = true;
        System.out.println("Compiled: " + compiled);
        String developer = "Ada";
        System.out.println("Developer: " + developer);
        System.out.println("Path: " + driveLetter + ":\\Java");
        // TODO: append the second stage here.
    }
}
