package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class HiloContador extends Thread{
    private Semaphore semaphore;
    char vocal;

    public HiloContador(char vocal) {
        this.semaphore = new Semaphore(1);
        this.vocal=vocal;
    }

    @Override
    public void run(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        descomponTexto();
        semaphore.release();
        System.out.println("Cantidad total de "+vocal+" -> "+Cuenta.getCont());
        Cuenta.cont = 0;
    }
    //añade +1 al contador global
    public synchronized void contador(){
        Cuenta.cont++;
    }
    //convierte el texto en un array de chars para su posterior comprobacion
    public synchronized void descomponTexto(){
        char[]caracteres = Cuenta.texto.toCharArray();
        for (char caracter:caracteres
        ) {
            if (caracter == vocal){
                contador();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        //lista que engloba los hilos que se crearan posteriomente
        List<HiloContador> hilos = new ArrayList<>();
        //las vocales que pasaremos al constructor
        char[]vocales = {'a','e','i','o','u'};

        for (int i = 0; i <=vocales.length -1 ; i++) {
            //añado a la lista el nuevo hilo
            hilos.add(new HiloContador(vocales[i]));
        }
        //inicio los hilos
        for (HiloContador h:hilos
        ) {
            h.start();
            h.join();
        }
    }
}
//****Clase encargada de administrar una frase y de guardar el numero de repeticiones del caracter requerido
class Cuenta{
    public static String texto="tres tristes tigres comieron trigo en un trigal";
    public static int cont;

    public static int getCont() {
        return cont;
    }
}
