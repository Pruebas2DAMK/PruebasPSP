import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejecuta {
    /*recibe como argumentos un comando y las opciones de este que quiere ejecutar
    -El programa debe crear un proceso hijo que ejecute el comando con las opciones
    -Lanzar un mensaje de error en caso de no realizarse correctamente
    -El padre tiene que esperar a que el hijo termine de informar
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.redirectErrorStream(true);


        //Compruebo cantidad de argumentos que sea al menos 1
        if (args.length == 0){
            System.err.println("No has introducido ningun argumento");
            System.exit(-1);
        }
        try{
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while (br.readLine() != null){
                System.out.println(br.readLine());
            }
            p.waitFor();
            System.out.println("Ejecutado Correctamente");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }


    }
}