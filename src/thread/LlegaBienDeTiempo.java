package thread;

import java.util.Scanner;

public class LlegaBienDeTiempo implements Runnable{
Thread t = new Thread(this,"nuevoHilo");
    LlegaBienDeTiempo(){
        t.start();
    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre: ");
        String nombre = sc.nextLine();
        System.out.println("¿Que dia entras a trabajar?: ");
        String diaTrabaja = sc.nextLine();
        System.out.println("¿A que hora has entrado?: ");
        int hora = sc.nextInt();
        System.out.println(hora > 8 ? "Has llegado tarde" : "Has llegado temprano");
    }
}
class EjecutaHilo{
    public static void main(String[] args) {
    LlegaBienDeTiempo lbdt = new LlegaBienDeTiempo();
    }
}
