import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjecutaIfConfig {
    public static void main(String[] args) throws IOException {
        //Al final lo he puesto para cualquier comando con un Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un comando a ejecutar");
        String EntradaUser = sc.nextLine();

        String linea;
        Process p = Runtime.getRuntime().exec(EntradaUser);
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
