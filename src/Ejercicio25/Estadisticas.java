package Ejercicio25;

public class Estadisticas {
    private double suma, media;
    private int cont;

    public Estadisticas() {
        suma = 0.0;
        cont = 0;
    }
    public void nuevoValor(double v){
        synchronized (this){
            suma+= v;
            cont+=1;
            media = suma / cont;
        }
    }

    public double getMedia() {
        return media;
    }

    public int getCont() {
        return cont;
    }

    public double getSuma() {
        return suma;
    }
}
