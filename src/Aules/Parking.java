package Aules;

import java.util.Random;

/*****CLASE BARRERA*****/
class Barrera{
    private int plazas[];
    private int n_plazas;
    private int libres;

    /********CONSTRUCTOR BARRERA*******
     * Recibe un numero entero que representa el numero de plazas que tendra el parking
     * este valor en un principio tambien representara al numero de plazas libres
     */
    Barrera (int N){
        n_plazas = N;
        plazas = new int[N]; //Array plazas se rellena con enteros , es del mismo tamaño que el numero de plazas
        for (int i=0;i<n_plazas;i++){
            plazas[i]=0;
            libres = N;
        }
    }
    /*
    Metodo sincronizado que recibe el identificador de un coche para darle una posicion en el parking
    o ponerlo en espera
     */
    synchronized  public int entrada(int coche) throws InterruptedException{
        int plaza=0;
        imprimir(); //saca por pantalla el array que indica las plazas ocupadas y las vacias

        while(libres==0){ //si no hay plazas libres
            System.out.println("Coche "+coche+" esperando.");
            wait(); //pone al hilo en espera
        }

        while(plazas[plaza]!=0){ //recorrer el array plazas, si no es 0 siguiente plaza
            plaza++;
        }
        plazas[plaza] = coche; //coche dentro del array
        libres--; //quitamos plazas libres si he añadido coche
        return plaza; //devuelve la plaza
    }
    /*
    Metodo sincronizado que notifica al hilo en espera de que hay una plaza libre,
    devuelve la posicion y añade una plaza libre para ser ocupada de nuevo
     */
    synchronized public void salida(int plaza){
        plazas[plaza]=0;
        libres++;
        notify();
    }

    /*
    Imprime el array de las plazas con valores 0 cuando estan vacias y con el id del coche cuando
    ocupan una plaza
     */
    public void imprimir(){
        System.out.println("Parking: ");
        for (int i=0;i<n_plazas;i++){
            System.out.println("["+plazas[i]+"]");
        }
        System.out.println();
    }
}
/*****CLASE COCHE*****/
class Coche extends Thread{
    private static final int MAX_DELAY = 2000;
    private int id;
    private Barrera barrera;
    /********CONSTRUCTOR COCHE*******
     * Recibe como parametros el identificador del coche y el lugar donde van a aparcarse
     *
     */
    Coche(int id, Barrera barr){
        this.id = id;
        this.barrera = barr;
    }

    //La ejecucion del hilo
    public void run(){
        try{
            Thread.sleep(new Random().nextInt(MAX_DELAY));
            System.out.println("Coche "+id+" intenta entrar en parking.");

            int plaza = barrera.entrada(id); //Intenta aparcar en una plaza
            System.out.println("Coche "+id+" aparcando en la plaza "+plaza);
            barrera.imprimir(); //cuando lo consigue devuelve por pantalla las posiciones ocupadas

            Thread.sleep(new Random().nextInt(MAX_DELAY)); //pequeña parada del hilo

            barrera.salida(plaza); //cuando sale notifica al hilo coche en espera y añade una plaza libre
            System.out.println("Coche "+id+" saliendo");
            barrera.imprimir(); // imprime las posiciones y la ocupada de nuevo vacia

        }catch (InterruptedException e){
            System.out.println("Exception");
        }
    }
}

/*****CLASE MAIN*****/
public class Parking {
    public static void main(String[] args) {
        //Numero de plazas del parking, en principio siempre disponibles
        int N = 5;
        //Inicializamos el parking con 5 plazas disponibles
        Barrera barrera = new Barrera(N);

        int C = 15;
        Coche coches[] = new Coche[C]; //Creamos un array de 15 coches
        for (int i=0;i<C;i++){ // a todos los coches les asignamos la misma barrera asi que querran aparcar en el mismo sitio
            coches[i] = new Coche(i+1, barrera);
            coches[i].start(); //iniciamos la ejecucion del hilo
        }

        try{
            for (int i=0;i<C;i++){
                coches[i].join(); //esperamos a fin de ejecucion del hilo anterior para iniciar el siguiente
            }

        }catch (InterruptedException e){
            System.out.println("Exception en el hilo principal");
        }
    }
}