import java.util.Scanner;
public class Main {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ancho del rectangulo: ");
        double ancho = sc.nextDouble();
        System.out.print("Ingrese el alto del rectangulo: ");
        double alto = sc.nextDouble();
        Rectangulo rectangulo = new Rectangulo(ancho, alto);
        while(true)
        {
            System.out.println("1.Calcular area");
            System.out.println("2.Salir");
            System.out.println("Elige una opcion: ");
            int opcion = sc.nextInt();
            if(opcion == 1)
            {
                System.out.println("Area: " + rectangulo.calcularArea());
            }
            else if (opcion == 2)
            {
                System.out.println("Saliendo..");
                break;
            }
            else 
            {
                System.out.println("Opcion no valida");
            }
        }
    }
}
