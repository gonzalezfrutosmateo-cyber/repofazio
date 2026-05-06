import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        do {
            System.out.println("Ingrese el radio: ");
            double radio = sc.nextDouble();
            
            circulo c = new circulo(radio);
            
           System.out.println("Area: "+c.area());
           System.out.println("Perimetro: "+c.perimetro());
           
           System.out.println("1- Continuar");
           System.out.println("2- Salir");
           opcion = sc.nextInt();
        } while (opcion == 1);
    }
}
