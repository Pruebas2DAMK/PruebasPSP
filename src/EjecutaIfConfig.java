import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaIfConfig {
    public static void main(String[] args) throws IOException {
        String linea;
        Process p = Runtime.getRuntime().exec("ifconfig");
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
