package semaphore;

import java.nio.IntBuffer;
import java.util.Arrays;

public class LectorEscritor {

    public synchronized void lector(int num){

    }
    public synchronized void escritor(int num){

    }
}
class Buffer{ //TODO en casa
    public static IntBuffer ib = IntBuffer.allocate(1000);

    public static void main(String[] args) {
        int cont=0;
      while(ib.hasRemaining()){
          ib.put(cont);
          System.out.println(ib.position());
      }
    }
}
