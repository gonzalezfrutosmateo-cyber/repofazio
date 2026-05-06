import java.util.Scanner;

public class cine {
    
 
    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
        
          System.out.println("Ingrese el titulo de su pelicula");  
        String titulo=sca.nextLine();
        System.out.println("Ingrese el nombre del autor de su pelicula");
        String nomDeAutor=sca.nextLine();
        System.out.println("Ingrese el genero de su pelicula");
        String genero=sca.nextLine();
    pelicula peli = new pelicula (titulo,nomDeAutor,genero);
      peli.imprimir();
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
    }while(continuar==1);
}
}