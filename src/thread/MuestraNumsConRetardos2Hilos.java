package thread;

public class MuestraNumsConRetardos2Hilos implements Runnable{
    Thread t;
    int tiempo;

    public MuestraNumsConRetardos2Hilos(int tiempo) {
        t = new Thread(this);
        t.start();
        this.tiempo=tiempo;
    }

    @Override
    public void run(){
        for (int i = 1; i <=10 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MuestraNumsConRetardos2Hilos mncr2h = new MuestraNumsConRetardos2Hilos(1000);
        MuestraNumsConRetardos2Hilos mncr2h2 = new MuestraNumsConRetardos2Hilos(1500);
    }
}
