package thread_2;

public class HolaYAdios implements Runnable {
    Thread t ;
    String palabra;
    int nVeces;

    public HolaYAdios(String palabra) throws InterruptedException {
        this.palabra = palabra;
        t= new Thread(this);
        t.start();
        this.nVeces = 10;
    }

    @Override
    public void run() {

        for (int i = 1; i <= nVeces ; i++) {
            System.out.println("-----------\nRepetición: "+i+
                    "\n"+palabra+"\n-----------\n");
            try {
                //entre 1 y 3 segundos
                Thread.sleep((long)(Math.random()*3001 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        HolaYAdios holaYAdios = new HolaYAdios("Hola");
        HolaYAdios holaYAdios2 = new HolaYAdios("Adios");
    }
}
