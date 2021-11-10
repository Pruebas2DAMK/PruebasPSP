package thread_Repaso;

public class MiHilo9 extends Thread{
    private int id;
    private int n;

    public MiHilo9(int id,int n) {
        this.id = id;
        this.n = n;
    }

    @Override
    public void run(){
        for (int i = 1; i <= n ; i++) {
            System.out.println("Vuelta Nº "+i+" HELLO THREAD "+id);
            Thread.yield();
        }

    }

    public static void main(String[] args) {
        MiHilo9 mh9 = new MiHilo9(5,5);
        mh9.start();
    }
}
