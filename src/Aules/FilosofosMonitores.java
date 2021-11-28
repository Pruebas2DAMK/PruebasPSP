package Aules;

import java.util.TreeMap;

//*****CLASE PALILLO*****
/*
Encargada de bloquear y despertar a los hilos
 */
class Palillo{
    private int numero;
    private boolean cogido;
    //*****CONSTRUCTOR DE PALILLO*****
    //recibe un identificador y por defecto no esta siendo utilizado
    public Palillo(int id){
        this.numero = id;
        this.cogido = false;
    }
    //Metodo que nos devuelve el entero asignado al palillo
    public int getId(){
        return this.numero;
    }
    /*
    Metodo que pone en true el boolean cogido.
    Entra a un loop mientras que cogido sea true , intenta mandar un mensaje y bloquea un hilo,
    si no es posible lanza una 'excepcion'.
     */
    synchronized public void coger(){
        while (cogido){
            try{
                System.out.println("Palillo "+numero+" bloqueado.");
                //esperando a la notificacion
                wait();
            }catch (InterruptedException e){
                System.out.println("Exception");
            }
        }

        cogido = true;
        System.out.println("Palillo "+numero+ " ha sido cogido.");
    }

    /*
    Metodo que pone en false al boolean cogido, manda un mensaje por pantalla y
    despertara al hilo bloqueado.
     */
    synchronized public void soltar(){
        cogido = false;
        System.out.println("Palillo "+numero+ " ha sido soltado.");
        notify();
    }
}

/*****CLASE MESACIRCULAR*****
    Asigna cantidad de palillos y personas y sus posiciones en la mesa
 */

class MesaCircular{
    private Palillo palillos[];
    private int filosofos;

    /*****CONSTRUCTOR MESA CIRCULAR*****
    un valor numerico que equivale a los filosofos y a el numero de palillos
     se crean tantos palillos como filosofos haya
     */
    public MesaCircular(int personas){
        this.filosofos = personas;
        palillos = new Palillo[personas];
        for (int i=0;i<personas;i++){
            palillos[i] = new Palillo(i);
        }
    }
    /*Metodos que devuelven el palillo que este a la posicion derecha o izquierda del filosofo
     */
    public Palillo palillo_derecho(int i){
        return palillos[(i+1)%filosofos];
    }

    public Palillo palillo_izquierdo(int i){
        return palillos[i];
    }
}

/*****CLASE FILOSOFO*****
 Representan a cada uno de los hilos filosofos
 */
class FilosofoM extends Thread{
    protected Palillo ind_izq, ind_der;
    protected int identidad;
    static final protected int MAX_DELAY = 1000; //pausas en milisegundos

    /*****CONSTRUCTOR FILOSOFO*****
     Recibe un identificador, se asigna el id de los palillos que representara su posicion en la mesa
     */
    public FilosofoM(int id){
        this.identidad = id;

        ind_izq = FilosofosMonitores.mesa.palillo_izquierdo(id);
        ind_der = FilosofosMonitores.mesa.palillo_derecho(id);
    }
    //Mensaje por pantalla y pequeña parada del hilo
    protected void pensar(){
        try{
            System.out.println("Filósofo "+identidad+" está pensando.");
            Thread.sleep((int)Math.random()*MAX_DELAY);
        }catch (InterruptedException e){
            System.out.println("Exception.");
        }
    }

    //Mensaje por pantalla, si el hilo esta despierto intenta coger los palillos que le corresponden
    protected void queriendo_comer(){
        System.out.println("Filósofo "+identidad+" quiere comer.");
        //para evitar interbloqueo, modificar la forma en la que se cogen los palillos, identificando si
        //el filosofo que coge el palillo es para o impar para coger el palillo izq o derecho y que
        //no cojan siempre todos el palillo izquierdo.
        if(identidad%2==0){
            ind_izq.coger();
            ind_der.coger();
        }
        else{
            ind_der.coger();
            ind_izq.coger();
        }

    }
    //Mensaje por pantalla y pequeña parada del hilo
    protected void comer(){
        try{
            System.out.println("Filósofo "+identidad+" está comiendo.");
            Thread.sleep((int)Math.random()*MAX_DELAY);
        }catch (InterruptedException e){
            System.out.println("Exception.");
        }
    }
    //Despierta a el hilo que este a la espera de poder coger el palillo que necesita.
    protected void dejando_de_comer(){
        ind_izq.soltar();
        ind_der.soltar();
    }
    //Bucle infinito durante la ejecucion del hilo
    public void run(){
        while (true){
            pensar(); //salida por pantalla
            queriendo_comer(); //si puede coge palillos si no espera a la notificacion de otro hilo
            comer(); //salido por pantalla
            dejando_de_comer(); //ha terminado de comer, notifica a los hilos que estan esperando sus palillos
        }
    }
}

/*****CLASE MAIN*****
 * Crea una mesa con 5 personas
 * a cada hilo filosofo se  le pasa un id dentro del rango (0-4) , se inicia el primero
 * seguido de los otros despues de  una pequeña parada, iran iniciandose y bloqueandose segun
 * las condiciones que se vayan estableciendo durante la ejecucion.
 * Es un bucle infinito
 */
public class FilosofosMonitores {
    public static MesaCircular mesa;
    public static void main(String[] args) {

        mesa = new MesaCircular(5);
        System.out.println("Sentados 5 filósofos.");

        FilosofoM f1 = new FilosofoM(0);
        FilosofoM f2 = new FilosofoM(1);
        FilosofoM f3 = new FilosofoM(2);
        FilosofoM f4 = new FilosofoM(3);
        FilosofoM f5 = new FilosofoM(4);
        f1.start();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println("Excepcion");

        }
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}
