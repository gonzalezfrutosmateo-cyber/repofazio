import java.util.Scanner;

public class coche {

    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
        
          System.out.println("Ingrese la marca de su auto");  
        String Marca=sca.nextLine();
        System.out.println("Ingrese el modelo de su auto");
        String modelo=sca.nextLine();
        System.out.println("Ingrese el año de su auto");
        int anio=sca.nextInt();
        sca.nextLine();
    auto aut= new auto (Marca,modelo,anio);
      aut.imprimir();
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
      sca.nextLine();
    }while(continuar==1);
}
}
