package thread_2;
import java.io.*;
import static thread_2.Registra.guarda;
public class EscribeNumeros extends Thread {
    String nombre;
    int numeroInicio;
    int numeroFinal;


    public EscribeNumeros(String nombre, int numeroInicio, int numeroFinal) throws IOException {
        this.nombre = nombre;
        this.numeroInicio = numeroInicio;
        this.numeroFinal = numeroFinal;
    }


    public void run(){
        for (int i = numeroInicio; i <= numeroFinal ; i++) {
            try {
                Thread.sleep(400);
                //guarda(nombre+" -> "+i);
                System.out.println(nombre+" -> "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread en1 = new EscribeNumeros("Hilo 1",11,20);
        Thread en2 = new EscribeNumeros("Hilo 2",21,30);
        Thread en3 = new EscribeNumeros("Hilo 3",1,10);
        en3.setPriority(Thread.MAX_PRIORITY);
        en1.setPriority(Thread.NORM_PRIORITY); //Defecto
        en2.setPriority(Thread.MIN_PRIORITY);
        en3.start();
        en3.join();
        en1.start();
        en1.join();
        en2.start();

    }
}
class Registra {
    public static void guarda(String salida) throws IOException {
        String ruta = "E:\\DAM2\\";
        File f = new File(ruta+"nuevo.txt");
        creaArchivo(f);
        PrintWriter pwOut = new PrintWriter(new FileWriter(f.getName()),true);
        pwOut.write(salida);
        pwOut.close();
    }
    public static void creaArchivo(File f) throws IOException {
        if (!f.exists()){
            f.createNewFile();
        }
    }
}