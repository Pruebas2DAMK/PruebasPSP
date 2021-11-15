package semaphore;

import java.util.concurrent.Semaphore;

/*
Este es el 2.6, el 2.8 equivale a uno de Hilos 3
 */
public class Acumula {
    public static int acumulador = 0;
}

class Sumador extends Thread{
    private int cuenta;
    private Semaphore semaphore;

    public Sumador(int hasta,int id, Semaphore semaphore) {
        this.cuenta = hasta;
        this.semaphore = semaphore;
    }

    public void sumar(){
        Acumula.acumulador++;
    }

    public void run(){
        for (int i = 0; i < cuenta; i++) {
            try {
                semaphore.acquire();
            }catch (InterruptedException ex){
                ex.printStackTrace();
                ex.getCause();
            }
            sumar();;
            semaphore.release();

        }
    }
}
class SeccionCriticaSemaforos {
    private static Sumador sumadores[];
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        int nSum = Integer.parseInt(args[0]);
        sumadores = new Sumador[nSum];
        for (int i = 0; i < nSum; i++) {
            sumadores[i] = new Sumador(1000000,i,semaphore);
            sumadores[i].start();
        }
        for (int i = 0; i < nSum; i++) {
            try{
                sumadores[i].join();
            }catch (InterruptedException iex){
                iex.printStackTrace();
                iex.getCause();
            }
            System.out.println("Acumulador: "+ Acumula.acumulador);
        }

    }
}
