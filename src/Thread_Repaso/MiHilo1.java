package Thread_Repaso;

public class MiHilo1 {
    public static void main(String[] args) {
        hilo h = new hilo();
    }
}
class hilo implements Runnable{
    Thread t;
    public hilo() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("HELLO THREAD");
    }
}
