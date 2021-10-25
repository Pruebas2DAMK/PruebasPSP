package thread;

class HelloThread extends Thread{
    public void run(){
        System.out.println("Hola desde el hilo creado");
    }
}
class RunThread{
    public static void main(String[] args) {
        new HelloThread().start();
        System.out.println("Hola desde el hilo principal");
        System.out.println("Proceso acabando");
    }
}