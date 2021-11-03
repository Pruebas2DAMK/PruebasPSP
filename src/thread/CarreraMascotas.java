package thread;

public class CarreraMascotas implements Runnable{
    Thread t;
    String mascota;
    int prioridad;
    int metros;
    int cansancio;
    public CarreraMascotas(String mascota,int prioridad) {
        t = new Thread(this);
        this.mascota = mascota;
        this.metros = 30;
        if ( prioridad < 1 && prioridad > 10){
            prioridad=1;
        }
        this.prioridad=prioridad;
        this.cansancio=50;
        t.setPriority(prioridad);
        t.start();
    }

    @Override
    public void run() {
        String caracter = "_";
        String cadena = caracter.repeat(metros);
        for (int i = 0; i <= metros; i++) {
            if (prioridad < 5){
                cansancio+=30;
            }else if(prioridad >=5 && prioridad < 8){
                cansancio+=20;
            }else{
            cansancio+=10;
            }
            System.out.println("Metro "+i+"-----------------------------------");
            System.out.println(mascota + " -> " + cadena.substring(0, i).replace("_", "*") + cadena.substring(i));
            if (i == metros){
                System.out.println("----------------HAS-LLEGADO----------------");
            }else{
                System.out.println("---------------------------------------------");
            }

            System.out.println();
            try {
                Thread.sleep(cansancio);
                //numeros entre el 1 y 50 sin incluirlos
                cansancio += Math.random() * (50- 1) + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CarreraMascotas cm = new CarreraMascotas("Perro",8);
        CarreraMascotas cm2 = new CarreraMascotas("Gato",5);
        CarreraMascotas cm3 = new CarreraMascotas("Tortuga",1);
    }
}
