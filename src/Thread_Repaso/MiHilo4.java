package Thread_Repaso;

public class MiHilo4 extends Thread {
    private int id;

    public MiHilo4(int id) {
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("HELLO THREAD "+id);
    }

    public static void main(String[] args) {
        MiHilo4 hilo = new MiHilo4(4);
        hilo.start();
    }
}
