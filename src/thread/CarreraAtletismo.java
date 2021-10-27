package thread;
/*
Mostrar el nombre de un atleta y simular que corre 30km (cada kilometro con un pequeño retardo simulando su cansancio)
 */

public class CarreraAtletismo implements Runnable{
    Thread t;
    String nombreAtleta;
    int kilometros;
    int cansancio;


    public CarreraAtletismo(String nombreAtleta,int kilometros) {
        t = new Thread(this);
        t.start();
        this.nombreAtleta = nombreAtleta;
        this.cansancio = 1000;
        this.kilometros =kilometros;
    }

    public void run(){
        String caracter="_";
        String cadena=caracter.repeat(kilometros);
        for (int i = 0; i <=kilometros ; i++) {
            //solucionar el replace -Probar con array añadiedo el personaje en cada casilla segun avance
            System.out.println(cadena.replace("_", "*"));
            try {
                Thread.sleep(cansancio);
                cansancio+=100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        CarreraAtletismo ca = new CarreraAtletismo("Joel",30);
    }

}
