import java.util.Scanner;

public class resumidor {
    
    

    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
        
          System.out.println("Ingrese el titulo de su libro");  
        String titulo=sca.nextLine();
        System.out.println("Ingrese el nombre del autor de su libro");
        String nomDeAutor=sca.nextLine();
        System.out.println("Ingrese la cantidad de paginas de su libro");
        int cantDePag=sca.nextInt();
    libro book = new libro (titulo,nomDeAutor,cantDePag);
      book.imprimir();
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
    }while(continuar==1);
}
}
