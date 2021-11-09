package Thread_Repaso;

public class MiHilo2 extends Thread{

    @Override
    public void run(){
        System.out.println("HELLO THREAD");
    }

    public static void main(String[] args) {
        MiHilo2 hilo = new MiHilo2();
        hilo.start();
    }
}
