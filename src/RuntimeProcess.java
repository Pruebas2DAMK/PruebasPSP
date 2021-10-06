import java.io.IOException;

public class RuntimeProcess {
    public static void main(String[] args) {
        if (args.length <=0){
            System.err.println("Se necesita un programa ejecutar");
            System.exit(-1);
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(args);
            System.out.println(process);
            process.destroy();
        } catch (IOException ex) {

            System.err.println("Excepcion de E/S");
            System.exit(-1);
    }
}
}
