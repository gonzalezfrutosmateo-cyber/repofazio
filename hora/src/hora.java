import java.util.Scanner;

public class hora {
    
    

    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
          
          System.out.println("Ingrese su hora actual (desde 00 hasta 23 hs)");  
        int hh=sca.nextInt();
        System.out.println("Ingrese sus minutos actuales (desde 00 hasta 59)");
        int mm=sca.nextInt();
    reloj hora = new reloj (hh,mm);
      hora.imprimir();
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
    }while(continuar==1);
}
}