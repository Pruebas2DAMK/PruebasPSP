package thread_Repaso;

public class Sumador implements Runnable{
    private int n;
    Thread t;
    private ContadorCompartido o;

    public Sumador(int n, ContadorCompartido o) {
        this.n = n;
        this.o = o;
        Thread t = new Thread();
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= n ; i++) {
            o.sumar();
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (t.isInterrupted()){
                System.out.println("Ha sido interrumpido");
                return;
            }
        }
    }
}
