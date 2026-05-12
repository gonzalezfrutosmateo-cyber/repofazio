import java.util.Scanner;

public class almacen {
    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
          System.out.println("Ingrese el nombre de su producto");  
        String nombre=sca.nextLine();
        System.out.println("Ingrese el precio de su producto");
        int precio=sca.nextInt();
        sca.nextLine();
    Producto product= new Producto (nombre,precio);
      int productoConIva= product.calcularIva(precio);
      System.out.println("Su producto con IVA es igual a: " + productoConIva);
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
      sca.nextLine();
    }while(continuar==1);
}
}
