import java.util.Scanner;

public class SistemaSolar {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int continuar = 0;
        
        Planeta mercurio = new Planeta("Mercurio", 0,  3.301e23,  6.083e10,   4879,   57910000,  "Rocoso",  true , 0.24 , 58.65);
        Planeta venus    = new Planeta("Venus",    0,  4.867e24,  9.28e11,   12104,  108200000,  "Rocoso",  true , 0.62 , 243.02);
        Planeta tierra   = new Planeta("Tierra",   1,  5.972e24,  1.083e12,  12756,  149600000,  "Rocoso",  true , 1 , 1);
        Planeta marte    = new Planeta("Marte",    2,  6.417e23,  1.631e11,   6779,  227940000,  "Rocoso",  true , 1.88 , 1.03);
        Planeta jupiter  = new Planeta("Jupiter",  95, 1.898e27,  1.431e15,  142984,  778500000,  "Gaseoso", true , 11.86 , 0.41);
        Planeta saturno  = new Planeta("Saturno",  83, 5.683e26,  8.271e14,  120536, 1432000000,  "Gaseoso", true , 29.46 , 0.44);
        Planeta urano    = new Planeta("Urano",    27, 8.681e25,  6.833e13,   51118, 2872500000L,  "Gaseoso", true , 84.01 , 0.72);
        Planeta neptuno  = new Planeta("Neptuno",  16, 1.024e26,  6.254e13,   49528, 4495100000L,  "Gaseoso", false , 164.8 , 0.67);
        Planeta pluton   = new Planeta("Pluton",    5, 1.309e22,  6.387e9,     2376, 5906400000L,  "Rocoso",  false , 258.09 , 6.39);

        do {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Elija el planeta que desea conocer!");
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
                case 1: mercurio.menuPlaneta(); break;
                case 2: venus.menuPlaneta();    break;
                case 3: tierra.menuPlaneta();   break;
                case 4: marte.menuPlaneta();    break;
                case 5: jupiter.menuPlaneta();  break;
                case 6: saturno.menuPlaneta();  break;
                case 7: urano.menuPlaneta();    break;
                case 8: neptuno.menuPlaneta();  break;
                case 9: pluton.menuPlaneta();   break;
                default: System.out.println("Ingrese una opcion valida");
            }

            System.out.println("Desea continuar? 1-Si  2-No");
            continuar = sca.nextInt();

        } while (continuar == 1);
        
    }
}