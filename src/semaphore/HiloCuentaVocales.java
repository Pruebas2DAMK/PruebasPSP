package semaphore;

import java.util.concurrent.Semaphore;

class HiloContador extends Thread{
    private Semaphore semaphore;
    private int id;
    char vocal;

    public HiloContador(int id,Semaphore semaphore, char vocal) {
        this.id = id;
        this.semaphore = semaphore;
        this.vocal=vocal;
    }

    @Override
    public void run(){
    descomponTexto();
        System.out.println(Cuenta.getCont());
    }
    public synchronized void contador(){
        Cuenta.cont++;
    }
    public synchronized void descomponTexto(){
        char[]caracteres = Cuenta.texto.toCharArray();
        for (char caracter:caracteres
             ) {
            if (caracter == vocal){
                contador();
            }
        }
    }

    public static void main(String[] args) {
        HiloContador hilo = new HiloContador();
    }
}
 class Cuenta{
    public static String texto="tres tristes tigres comieron trigo en un trigal";
     public static int cont;

     public static int getCont() {
         return cont;
     }
 }
