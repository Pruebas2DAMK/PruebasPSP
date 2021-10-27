package thread;

import java.util.Scanner;

public class Fibonacci extends Thread{
    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantas veces me voy a repetir?");
        int numeroRepeticiones= sc.nextInt();
        int ultimoNumero=1;
        int penultimoNumero=1;
        String resultado="";
        resultado+=ultimoNumero+","+penultimoNumero+",";
        for (int i = 1; i <=numeroRepeticiones;i++){
            int suma=ultimoNumero+penultimoNumero;
            resultado+=suma+",";
            penultimoNumero=ultimoNumero;
            ultimoNumero=suma;
        }
        resultado=resultado.substring(0,resultado.length()-1);
        System.out.println(resultado);
    }

}
class ejecutaFibonacci{
    public static void main(String[] args) {
        new Fibonacci().start();
    }
}
