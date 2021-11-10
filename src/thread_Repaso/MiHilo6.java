package thread_Repaso;

public class MiHilo6 implements Runnable{
    private Thread t;
    private int id;
    private int n;
    public MiHilo6(int id, int n) {
        this.id = id;
        this.n = n;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= n ; i++) {
            System.out.println("Vuelta Nº "+i+" HELLO THREAD "+id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        MiHilo6 hilo = new MiHilo6(6,5);
    }
}
