package thread;

public class MuestraNumsConInterrupcion implements Runnable{
    Thread t;
    String identificador;
    int sleep;
    int vueltas;

    public MuestraNumsConInterrupcion(String identificador, int sleep, int vueltas) {
        t = new Thread(this);
        this.identificador = identificador;
        this.sleep = sleep;
        this.vueltas = vueltas;
        t.start();
    }


    @Override
    public void run() {
        if (!t.isInterrupted()){
            for (int i = 0; i <= vueltas; i++) {
                try {
                    Thread.sleep(sleep);
                    System.out.println("Hilo "+identificador+" -> vuelta "+i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
//todo terminar
    public static void main(String[] args) {
        MuestraNumsConInterrupcion muestra = new MuestraNumsConInterrupcion("Hilo 1",1000,10);
        MuestraNumsConInterrupcion muestra2 = new MuestraNumsConInterrupcion("Hilo 2",1500,10);
    }
}
