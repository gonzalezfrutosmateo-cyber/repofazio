import java.util.Scanner;

public class CuentaBancaria {
    
int sueldo=0;

public CuentaBancaria(int sueldo){
    this.sueldo= sueldo;
}
public void depositar(){
    int deposito=0;
    Scanner sca= new Scanner(System.in);
    System.out.println("Ingrese la cantidad que desea depositar");
    deposito+=sueldo;
}

public void retirar(){
    int retiro=0;
    Scanner sca= new Scanner(System.in);
    System.out.println("Ingrese la cantidad que desea retirar");
    retiro-=sueldo;
}
}
