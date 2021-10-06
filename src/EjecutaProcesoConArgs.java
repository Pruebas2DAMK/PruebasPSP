import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaProcesoConArgs {
    public static void main(String[] args) throws IOException {
        if (args.length <=0){
            System.err.println("Debe pasar un comando como argumento");
            System.exit(-1);
        }
        String linea;
        //Ahora lo recibe como argumento. Modificacion de ejecuta IfConfig
        Process p = Runtime.getRuntime().exec(args[0]);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            p.destroy();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
