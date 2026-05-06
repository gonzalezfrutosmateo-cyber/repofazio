import java.util.Scanner;
public class main 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la calificacion del estudiante: ");
        double calificacion = sc.nextDouble();
        Estudiantes estudiante = new Estudiantes(nombre, calificacion);
        while(true)
        {
            System.out.println("1. Ver estado del estudiante");
            int opcion = sc.nextInt();
            if(opcion == 1)
            {
                System.out.println("Estado: " + estudiante.estado());
            }
            else if(opcion == 2)
            {
                System.out.println("2. Salir");
                break;
            }
        }
    }
}
