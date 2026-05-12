import java.util.Scanner;

public class CuentaBancaria {
    
int sueldo=0;

public CuentaBancaria(int sueldo){
    this.sueldo= sueldo;
}
public void depositar(){
    Scanner sca = new Scanner(System.in);
    System.out.println("Ingrese la cantidad que desea depositar");
    int deposito = sca.nextInt(); 
    sueldo += deposito;           
}

public void retirar(){
    Scanner sca = new Scanner(System.in);
    System.out.println("Ingrese la cantidad que desea retirar");
    int retiro = sca.nextInt();
    if (retiro>sueldo){
    System.out.println("Saldo insuficiente");
    }
    else{
        sueldo -= retiro;
    }
}
}
