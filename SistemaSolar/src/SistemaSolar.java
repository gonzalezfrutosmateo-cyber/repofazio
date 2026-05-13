import java.util.Scanner;

public class SistemaSolar {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int continuar = 0;
        
        Planeta mercurio = new Planeta ("Mercurio" , 0, 3.3010000000000000000000000, 6.0830000000, 4881, 57000000, "Rocoso", true);
        Planeta venus = new Planeta ("Venus" , 0, 4.869000000000000000000000, 9.38000000000, 12103, 108000000, "Rocoso", true);
        Planeta tierra = new Planeta ("Tierra" , 1, 5.97200000000000000000000, 1.000000000000, 12756, 147000000, "Rocoso", true);
        Planeta marte = new Planeta ("Marte" , 2, 6.41910000000000000000000, 1.63000000000, 6779, 227940000, "Rocoso", true);
        Planeta jupiter = new Planeta ("Jupiter" , 1, 3.3010000000000000000000000, 6.0830000000, 4881, 57, "Rocoso", true);
        Planeta saturno = new Planeta ("Saturno" , 1, 3.3010000000000000000000000, 6.0830000000, 4881, 57, "Rocoso", true);
        Planeta urano = new Planeta ("Urano" , 1, 3.3010000000000000000000000, 6.0830000000, 4881, 57, "Rocoso", true);
        Planeta neptuno = new Planeta ("Neptuno" , 1, 3.3010000000000000000000000, 6.0830000000, 4881, 57, "Rocoso", true);
        Planeta pluton = new Planeta ("Pluton" , 1, 3.3010000000000000000000000, 6.0830000000, 4881, 57, "Rocoso", true);
        do {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Eliga el planeta que desea conocer!");
        System.out.println("Planetas:");
        System.out.println("1- Mercurio");
        System.out.println("2- Venus");
        System.out.println("3- Tierra");
        System.out.println("4- Marte");
        System.out.println("5- Jupiter");
        System.out.println("6- Saturno");
        System.out.println("7- Urano");
        System.out.println("8- Neptuno");
        System.out.println("9- Pluton");
        System.out.println("-------------------------------------------------------------------------------");
    
        int opcion = sca.nextInt();

            switch (opcion) {
                case 1: mercurio.MenuPlaneta();
                case 2: venus.MenuPlaneta();
                case 3: tierra.MenuPlaneta();
                case 4: marte.MenuPlaneta();
                case 5: jupiter.MenuPlaneta();
                case 6: saturno.MenuPlaneta();
                case 7: urano.MenuPlaneta();
                case 8: neptuno.MenuPlaneta();
                case 9: pluton.MenuPlaneta();
                default: System.out.println("Ingrese una opcion valida");
            } 
            
                }
        System.out.println("Desea continuar 1-si 2-no");
            continuar = sca.nextInt();    
        }    
    while (continuar == 1);
}