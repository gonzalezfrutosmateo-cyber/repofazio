import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int continuar = 0;

        do {
            System.out.print("Ingrese el ancho del rectangulo: ");
            double ancho = sc.nextDouble();
            System.out.print("Ingrese el alto del rectangulo: ");
            double alto = sc.nextDouble();

            Rectangulo rectangulo = new Rectangulo(ancho, alto);
            System.out.println("Area: " + rectangulo.calcularArea());

            System.out.println("1-Ingresar nuevos datos  2-Salir");
            continuar = sc.nextInt();

        } while (continuar == 1);

        System.out.println("Saliendo...");
    }
}