package thread_Repaso;

public class MiHilo11 implements Runnable{
    private Thread t;
    private int id;
    private int n;

    public MiHilo11(int id, int n) {
        this.id = id;
        this.n = n;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.println("Vuelta Nº " + i + " HELLO THREAD " + id);
            Thread.yield();
            if (t.isInterrupted()){
                return;
            }
        }

    }

    public static void main(String[] args) {
        MiHilo11 hilo = new MiHilo11(11,5);
    }
}
