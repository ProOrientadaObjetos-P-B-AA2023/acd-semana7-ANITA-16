
package Utilerias;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ReviewFiles {
    public static void main(String[] args) throws FileNotFoundException {
        //FLUJO DE SALIDA (escritura) BASADO EN CARACTERES
        Formatter flujoCaracteresCasSlida = new Formatter("archivoPrueva.csv");
        Formatter flujoCaracteresCasSlida2 = new Formatter("archivoPrueba2.csv");
        /*flujoCaracteresCasSlida .format("%s, %s", "Hola","MUNDO");
        flujoCaracteresCasSlida.close();*/
        for (int i = 0; i < 10; i++)
            flujoCaracteresCasSlida.format("Estudiante%d;%d;%d\n", (i+1), (int)(Math.random()*10+0),(int)(Math.random()*10+0));
        flujoCaracteresCasSlida.close();
        
        
        
        //FLUJO DE SALIDA (lectura) BASADO EN CARACTERES
        Scanner flujoCaracteresEntrada = new Scanner(new File("archivoPrueva.csv"));
        /*System.out.println(flujoCaracteresEntrada.nextLine());
        flujoCaracteresEntrada.close();*/
        
        for (int i = 0; i < 10; i++) {
            String datos = flujoCaracteresEntrada.nextLine();
            String dato[] = datos.split(";");
            double nota1 = Double.parseDouble(dato[1]);
            double nota2 = Double.parseDouble(dato[2]);
            double promedio = (nota1 + nota2)/2;
            System.out.println(dato[0]+"  "+nota1+"  "+nota2);
            flujoCaracteresCasSlida2.format("%s;%.2f;%.2f;%.2f\n",dato[0],nota1,nota2,promedio);
        
        }
        flujoCaracteresCasSlida2.close();
        flujoCaracteresEntrada.close();
    }
    
    
}
