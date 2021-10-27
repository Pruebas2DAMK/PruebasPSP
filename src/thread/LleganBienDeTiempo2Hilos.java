package thread;

public class LleganBienDeTiempo2Hilos implements Runnable{
    Thread t;
    String nombre;
    String dia;
    int hora;
    public LleganBienDeTiempo2Hilos(String nombre,String día,int hora) {
        t = new Thread(this);
        t.start();
        this.nombre=nombre;
        this.dia=dia;
        this.hora=hora;
    }
    @Override
    public void run(){
        int horaLlegada=8;
        String comprueba=horaLlegada>=hora?nombre+" Has llegado temprano":nombre+" Has llegado tarde";
        System.out.println(comprueba);
    }

    public static void main(String[] args) {
        new LleganBienDeTiempo2Hilos("Pepe","Martes",3);
        new LleganBienDeTiempo2Hilos("Joel","Domingo",11);
    }
}
