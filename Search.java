import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Search
{
    //crea el archivo en disco, recibe como parámetro la lista de Notes
    public static void crearArchivo(ArrayList lista) {
    FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("C:\\Notas.txt");
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Note note : lista) { /** ME GENERA UN ERROR ******/
                //escribe los datos en el archivo
                bfwriter.write(note.getId() + "," + note.getTitulo() + "," + note.getDescripcion()
                         + "," + note.getFecha() + "\n");
            }
            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {}
            }
        } 
        
    }
   //crea el archivo en disco, retorna la lista de notas
   public static ArrayList leerArchivo() {
    // crea el flujo para leer desde el archivo
    File file = new File("C:\\archivos\\notas.txt");
    ArrayList listaNotas= new ArrayList<>();  
    Scanner scanner;
    try {
        //se pasa el flujo al objeto scanner
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            // el objeto scanner lee linea a linea desde el archivo
            String linea = scanner.nextLine();
            Scanner delimitar = new Scanner(linea);
            //se usa una expresión regular
            //que valida que antes o despues de una coma (,) exista cualquier cosa
            //parte la cadena recibida cada vez que encuentre una coma              
            delimitar.useDelimiter("\\s*,\\s*");
            Note e= new Note();
            e.setId(delimitar.nextInt());
            e.setTitulo(delimitar.next());
            e.setDescripcion(delimitar.next());
            e.setFecha(delimitar.next());
            listaNotas.add(e);
            }            
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaNotas;
    }
   //añadir más notaas al archivo
   public static void aniadirArchivo(ArrayList lista) {
       FileWriter flwriter = null;
       try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
           flwriter = new FileWriter("C:\\archivos\\Notas.txt", true);
           BufferedWriter bfwriter = new BufferedWriter(flwriter);
           for (Note note : lista) { /** ME GENERA UN ERROR ******/
               //escribe los datos en el archivo
               bfwriter.write(note.getId() + "," + note.getTitulo() + "," + note.getDescripcion()
						+ "," + note.getFecha() + "\n");
		}
	   bfwriter.close();
	   System.out.println("Archivo modificado satisfactoriamente..");
       } catch (IOException e) {
       } finally {
           if (flwriter != null) {
               try {
                   flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
		}
            }
	}
	}	
}
