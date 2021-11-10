package thread_Repaso;

public class MiHilo10 implements Runnable{
    private Thread t;
    private int id;
    private int n;

    public MiHilo10(int id, int n) {
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
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                System.out.println("Ha sido interrumpido");
                return;
            }
        }

    }

    public static void main(String[] args) {
        MiHilo10 hilo = new MiHilo10(5,5);
    }
}
