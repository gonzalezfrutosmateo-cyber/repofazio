import java.util.Scanner;

public class animales {
    public static void main(String[] args) {
        Scanner sca= new Scanner(System.in);
        int continuar=0;
      do{
          System.out.println("Ingrese el nombre de su mascota");  
        String nombre=sca.nextLine();
        System.out.println("Ingrese la especie de su animal: 1:perro 2:gato 3:pollo");
        int tipo=sca.nextInt();
        sca.nextLine();
    Mascota mascot= new Mascota (nombre,tipo);
      mascot.hacerSonido(tipo);
      System.out.println("Desea continuar 1-si 2-no");
      continuar=sca.nextInt();
      sca.nextLine();
    }while(continuar==1);
}
}
