package thread_Repaso;

public class MiHilo7 extends Thread{
    private int id;
    private int n;

    public MiHilo7(int id,int n) {
        this.id = id;
        this.n = n;
    }

    @Override
    public void run(){
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
        MiHilo7 hilo = new MiHilo7(7,7);
        hilo.start();
    }
}
