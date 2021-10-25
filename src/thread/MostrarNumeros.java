package thread;

public class MostrarNumeros extends Thread{
    public void run(){
        for (int i = 1; i < 21; i++) {
            System.out.println(i);
        }
    }
}
class IniciaHilo {
    public static void main(String[] args) {
            new MostrarNumeros().start();
    }
}
