package thread_Repaso;

public class MiHilo8 implements Runnable {
    private Thread t;
    private int id;
    private int n;

    public MiHilo8(int id, int n) {
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
        }

    }

    public static void main(String[] args) {
        MiHilo8 mh8 = new MiHilo8(5,5);
    }
}
