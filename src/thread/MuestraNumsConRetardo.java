package thread;

public class MuestraNumsConRetardo implements Runnable{
    Thread t;
    public MuestraNumsConRetardo() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run(){
        for (int i=1;i<=20;i++){
            System.out.println(i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        MuestraNumsConRetardo mncr = new MuestraNumsConRetardo();
    }

}
