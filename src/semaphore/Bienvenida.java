package semaphore;

public class Bienvenida {

    boolean claseComenzada;

    public Bienvenida(){
            this.claseComenzada = false;
    }

    //Hasta que el profesor no salude no empieza la clase
    //los alumnos esperan con un wait

    public synchronized void saludarProfesor(){
        try{
            while(!claseComenzada){
                wait();
            }
            System.out.println("Buenos dias profesor");
        }catch (InterruptedException ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public synchronized void llegadaProfesor(String nombre){
        System.out.println("Buenos dias a todos.Soy el profesor "+nombre);
        this.claseComenzada = true;
        notifyAll();
    }

}

class Alumno extends Thread{
    Bienvenida saludo;
    public Alumno(Bienvenida bienvenida){
        this.saludo = bienvenida;
    }
    public void run(){
        System.out.println("Alumno llegó.");
        try{
            Thread.sleep(1000);
            saludo.saludarProfesor();
        }catch (InterruptedException ex){
            System.err.println("Thread Alumno Interrumpido");
            System.exit(-1);
        }
    }

}

class Profesor extends Thread{
    String nombre;
    Bienvenida saludo;

    public Profesor(String nombre, Bienvenida bienvenida) {
        this.nombre = nombre;
        this.saludo = bienvenida;
    }

    public void run(){
        System.out.println(nombre+" llegó.");
        saludo.llegadaProfesor(nombre);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Thread Profesor interrumpido");
            System.exit(-1);
        }
    }
}

class ComienzoClase{
    public static void main(String[] args) {
        //objeto compartido
        Bienvenida b = new Bienvenida();

        int nAlumnos = Integer.parseInt(args[0]);
        for (int i = 0; i < nAlumnos; i++) {
            new Alumno(b).start();
        }
        Profesor profesor = new Profesor("Osvaldo Witalcoche",b);
        profesor.start();
    }
}