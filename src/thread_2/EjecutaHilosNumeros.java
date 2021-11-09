package thread_2;

public class EjecutaHilosNumeros {
    public static void main(String[] args) {
        HilosNumeros1 hn1 = new HilosNumeros1(100);
        HilosNumeros2 hn2 = new HilosNumeros2(hn1);

    }
}
class HilosNumeros1 implements Runnable{
    /*
    > 10  , del 0 al num
     */
    Thread t;
    int numero;
    String id;

    public int getNumero() {
        return numero;
    }

    public HilosNumeros1(int numero) {
        this.t = new Thread(this);
        t.start();
        this.numero = numero;
        this.id = "Hilo 1";
    }

    @Override
    public void run() {
        if (numero > 10){
            for (int i = 0; i <= numero; i++) {
                System.out.println(id+": -> "+i);
                try {
                    Thread.sleep(((long)Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.err.println("Numero no valido");
            System.exit(-1);
        }

    }
}

class HilosNumeros2 implements Runnable{
    /*
    < 10 , del numero al 0
     */
    Thread t;
    int numero;
    String id;

    public HilosNumeros2(HilosNumeros1 hn1) {
        this.t = new Thread(this);
        t.start();
        this.numero = hn1.getNumero();
        this.id = "Hilo 2";

    }

    @Override
    public void run(){
        if (numero > 10){
            for (int i = numero; i >= 0; i--) {
                System.out.println(id+": -> "+i);
                try {
                    Thread.sleep(((long)Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.err.println("Numero no valido");
            System.exit(-1);
        }
    }
}
