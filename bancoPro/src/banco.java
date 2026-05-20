import java.util.Scanner;

public class banco {
    public static void main(String[] args) {
        int continuar = 0;
        Scanner sca = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = sca.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido = sca.nextLine();
        System.out.println("Ingrese el numero de cuenta bancaria:");
        int NumCuentaBancaria = sca.nextInt();
        System.out.println("Ingrese el tipo de cuenta: 1.Cuenta Corriente  2.Cuenta de Ahorro");
        int TipoCuenta = sca.nextInt();
        cuentaBancaria cuenta = new cuentaBancaria(nombre, apellido, NumCuentaBancaria, TipoCuenta, 0);
        do {
            System.out.println("\nElija una opcion:");
            System.out.println("1 - Mostrar datos de la cuenta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Ingresar saldo");
            System.out.println("4 - Retirar saldo");
            int eleccion = sca.nextInt();
            switch (eleccion) {          
                case 1: cuenta.imprimir(); break;
                case 2: cuenta.consultaSaldo(); break;
                case 3:
                    System.out.println("Ingresa la cantidad:");
                    long monto = sca.nextLong();
                    cuenta.ingresoSaldo(monto);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad a retirar:");
                    long retiro = sca.nextLong();
                    cuenta.retiroSaldo(retiro);   
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
            System.out.println("Desea continuar? 1-Si  2-No");
            continuar = sca.nextInt();
        } while (continuar == 1);
    }
}