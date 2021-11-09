package Thread_Repaso;

public class MiHilo3 implements Runnable{
    private Thread t;
    private int id;
    public MiHilo3(int id) {
        this.id = id;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("HELLO THREAD "+id);
    }

    public static void main(String[] args) {
        MiHilo3 hilo = new MiHilo3(3);
    }
}
