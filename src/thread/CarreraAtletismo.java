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

            System.out.println(cadena.substring(0,i).replace("_", "*")+cadena.substring(i,cadena.length()));
            try {
                Thread.sleep(cansancio);
                //numeros entre el 1 y 100 sin incluirlos
                cansancio+=Math.random()*(100-1)+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(nombreAtleta+" Felicidades!\nHas recorrido: "+kilometros+"KM");
    }

    public static void main(String[] args) {
        CarreraAtletismo ca = new CarreraAtletismo("Joel",30);
    }

}
