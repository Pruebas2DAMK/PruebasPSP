package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Orden {

    public static void main(String[] args) {
        List<HiloNuevo>  hilos = new ArrayList<>();
        hilos.add(new HiloNuevo("Voy el primero siempre",1));
        hilos.add(new HiloNuevo("No me queda de otra que esperar",2));
        hilos.forEach(e->{
            e.start();
            try {
                e.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}
class HiloNuevo extends Thread{
    private Semaphore sem;
    private String escribe;
    private int id;
    private int nReps;

    public HiloNuevo(String escribe, int id) {
        this.escribe = escribe;
        this.id = id;
        nReps = 2;
        sem = new Semaphore(1);
    }

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = nReps; i > 0 ; --i) {
            System.out.println("Hilo "+id+" dice: "+escribe);
        }
        sem.release();
    }
}