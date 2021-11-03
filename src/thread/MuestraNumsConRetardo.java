package thread;

public class MuestraNumsConRetardo implements Runnable{
    Thread t;
    String nombre;
    public MuestraNumsConRetardo(String nombre) {
        t = new Thread(this);
        this.nombre=nombre;
        t.start();
    }
    public void Interrumpir(){
        t.interrupt();
    }

    @Override
    public void run(){
        if (!t.isInterrupted()) {
            for (int i = 1; i <= 20; i++) {
                System.out.println(nombre+" "+i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        MuestraNumsConRetardo mncr = new MuestraNumsConRetardo("pepe");
        mncr.Interrumpir();
        MuestraNumsConRetardo mncr2 = new MuestraNumsConRetardo("manolo");
    }

}
