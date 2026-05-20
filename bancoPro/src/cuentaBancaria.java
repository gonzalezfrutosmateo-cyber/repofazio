import java.util.Scanner;
public class cuentaBancaria {
    String nombre;
    String apellido;
    int NumCuentaBancaria;
    int TipoCuenta;
    double SaldoCuenta;
    public cuentaBancaria(String nombre, String apellido, int NumCuentaBancaria, int TipoCuenta, double SaldoCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.NumCuentaBancaria = NumCuentaBancaria;
        this.TipoCuenta = TipoCuenta;
        this.SaldoCuenta = SaldoCuenta;
    }
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Numero de Cuenta Bancaria: " + NumCuentaBancaria);
        if (TipoCuenta == 1)
            System.out.println("Tipo de cuenta: Cuenta Corriente");
        else if (TipoCuenta == 2)
            System.out.println("Tipo de cuenta: Cuenta de Ahorro");
        else
            System.out.println("Tipo de cuenta: error");
        System.out.println("Saldo: " + SaldoCuenta);
    }
    public void consultaSaldo() {
        System.out.println("Saldo actual: " + SaldoCuenta);
    }
    public void ingresoSaldo(long monto) {
        SaldoCuenta += monto;
        System.out.println("Nuevo saldo: " + SaldoCuenta);
    }
    public void retiroSaldo(long retiro) {
        if (retiro > SaldoCuenta) {
            System.out.println("Saldo insuficiente.");
        } else {
            SaldoCuenta -= retiro;
            System.out.println("Nuevo saldo: " + SaldoCuenta);
        }
    }
}