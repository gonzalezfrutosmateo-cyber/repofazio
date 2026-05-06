import java.util.Scanner;

public class banco {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int continuar = 0;
        do {
            CuentaBancaria cuenta = new CuentaBancaria(0);
            System.out.println("------------------------------------------------------");
            System.out.println("Su salario actual es: " + 0);
            System.out.println("Para depositar dinero ingrese 1");
            System.out.println("Para retirar dinero ingrese 2");
            System.out.println("------------------------------------------------------");
            int opcion = sca.nextInt();

            if (opcion == 1) {
                cuenta.depositar(sca);
            } 
            else if (opcion==2 && sueldo==0) {
                    System.out.println("No tenes plata para retirar papu");
                } 
            else {
                    cuenta.retirar(sca);
                }
        System.out.println("Desea continuar 1-si 2-no");
            continuar = sca.nextInt();    
        }    
    while (continuar == 1);
    }
}

