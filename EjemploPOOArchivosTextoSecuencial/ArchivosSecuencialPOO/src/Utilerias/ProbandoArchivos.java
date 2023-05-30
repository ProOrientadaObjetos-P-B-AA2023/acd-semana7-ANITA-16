
package Utilerias;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
import paquete1.Profesor;

public class ProbandoArchivos {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Profesor profesores[] = {new Profesor("Ivan","Auxiliar"), 
                                new Profesor("David", "Principal"),
                                new Profesor("Agusto", "Estrella"),
                                new Profesor("Pablo", "Principal")};
        Formatter flujoSalida = new Formatter("MiPrueba.txt"); //flujo de salida hacia el archivo 
        
        for(Profesor profeAux : profesores)
            flujoSalida.format("%s %s", profeAux.obtenerNombre(), profeAux.obtenerTipo());
        flujoSalida.close();
        Scanner flujoEntrada = new Scanner(new File("MiPrueba.txt")); //flujo de entrada desde el archivo hacia el programa
        Profesor profesor1 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        Profesor profesor2 = new Profesor(flujoEntrada.next(), flujoEntrada.next());
        /*System.out.println(profesor1);
        System.out.println(profesor2);*/
        //Flujo de SALIDA 
        Profes profes1[] = {new Profes("Ivan","Auxiliar"), 
                            new Profes("David", "Principal"),
                            new Profes("Agusto", "Estrella"),
                            new Profes("Pablo", "Principal")};
        ObjectOutputStream flujoSalida2 = new ObjectOutputStream(new FileOutputStream("Profes.prof"));//flujo de salida basa en bytes, para escribir objetos en archivos
        flujoSalida2.writeObject(profes1[0]);
        flujoSalida2.writeObject(profes1[1]);
        flujoSalida2.writeObject(profes1[2]);
        flujoSalida2.writeObject(profes1[3]);
        flujoSalida2.close();
        //flujo de ENTRDA basada en bytes, prara leer Objetos del Archivo
        ObjectInputStream flujoEntrada2 = new ObjectInputStream(new FileInputStream("Profes.prof"));
        Profes prof1 = (Profes) flujoEntrada2.readObject();
        Profes prof2 = (Profes) flujoEntrada2.readObject();
        System.out.println(prof1);
        System.out.println(prof2);
    }
    
    class Profes implements Serializable{
        private String nombre, tipo;

        public Profes(String nombre, String tipo) {
            this.nombre = nombre;
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "Profes{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
        }
        
    }
  
}
