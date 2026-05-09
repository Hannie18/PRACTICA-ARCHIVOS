import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SistemaNotasArchivo {
public static void main(String[] args) {
File archivo = new File("estudiante.txt");
if (!archivo.exists()) {
System.out.println("Error: el archivo no existe.");
return;
}
int totalEstudiantes = 0;
int aprobados = 0;
double sumaPromedios = 0;
try {
Scanner lector = new Scanner(archivo);
while (lector.hasNext()) {
String nombre = lector.next();
double n1 = lector.nextDouble();
double n2 = lector.nextDouble();
double n3 = lector.nextDouble();
double promedio = (n1 + n2 + n3) / 3.0;
System.out.println("Nombre: " + nombre);
System.out.println("Promedio: " + promedio);
if (promedio >= 7) {
System.out.println("Estado: Aprobado");
aprobados++;
} else {
System.out.println("Estado: Reprobado");
}
sumaPromedios += promedio;
totalEstudiantes++;
System.out.println("----------------------");
}
lector.close();
if (totalEstudiantes > 0) {
System.out.println("Total estudiantes: " + totalEstudiantes);
System.out.println("Total aprobados: " + aprobados);
System.out.println("Promedio general: " + sumaPromedios / totalEstudiantes);
}
} catch (FileNotFoundException e) {
System.out.println("Error al leer el archivo.");
}
}
}
