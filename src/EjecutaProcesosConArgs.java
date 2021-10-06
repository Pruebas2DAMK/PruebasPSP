import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaProcesosConArgs {
    public static void main(String[] args) throws IOException {
        if (args.length <=0){
            System.err.println("Debe pasar un comando como argumento");
            System.exit(-1);
        }
        String linea;
        //Ahora lo recibe como argumento. Modificacion de ejecuta IfConfig
        for (int i=0; i < args.length; i++){
            Process p = Runtime.getRuntime().exec(args[i]);
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
}
