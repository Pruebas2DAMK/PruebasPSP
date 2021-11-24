package Ejercicio25;

public class Hilo implements Runnable{
    //public static Estadisticas estadisticas = new Estadisticas();
    Thread t;
    Estadisticas estadisticas;
    int reps;
    public Hilo(Estadisticas estadisticas, int reps) {
        this.estadisticas = estadisticas;
        this.reps = reps;
        t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < reps ; i++) {
            estadisticas.nuevoValor(Math.random()*100);
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Estadisticas est = new Estadisticas();
        Hilo hilo1 = new Hilo(est,50000);
        Hilo hilo2 = new Hilo(est,40000);

        Thread.sleep(200);
        System.out.println("Contador - "+est.getCont());
        System.out.println("Media - "+Math.round(est.getMedia()));
        System.out.println("Suma - "+Math.round(est.getSuma()));

    }
}
