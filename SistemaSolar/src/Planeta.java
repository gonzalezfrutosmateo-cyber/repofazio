import java.util.Scanner;

public class Planeta {

    String nombre;
    int cantDeSatelites;
    double masaKg;
    double volumenKmCubicos;
    int diametroKm = 0;
    long distanciaMediaAlSol = 0; 
    String tipoDePlaneta;
    boolean observable = false;
    double periodoOrbital;
    double periodoDeRotacion;

    public Planeta(String nombre, int cantDeSatelites, double masaKg, double volumenKmCubicos, int diametroKm, long distanciaMediaAlSol, String tipoDePlaneta, boolean observable, double periodoOrbital, double periodoDeRotacion) {
        this.nombre = nombre;
        this.cantDeSatelites = cantDeSatelites;
        this.masaKg = masaKg;
        this.volumenKmCubicos = volumenKmCubicos;
        this.diametroKm = diametroKm;
        this.distanciaMediaAlSol = distanciaMediaAlSol;
        this.tipoDePlaneta = tipoDePlaneta;
        this.observable = observable;
        this.periodoOrbital = periodoOrbital;
        this.periodoDeRotacion = periodoDeRotacion;
        
    }

    public void menuPlaneta() {
        Scanner sca = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(nombre);
        System.out.println("Datos:");
        System.out.println("1- Cantidad de satelites");
        System.out.println("2- Masa");
        System.out.println("3- Volumen");
        System.out.println("4- Diametro");
        System.out.println("5- Distancia media al sol");
        System.out.println("6- Tipo de planeta");
        System.out.println("7- Observable");
        System.out.println("8- Densidad");
        System.out.println("9- Es un planeta exterior?");
        System.out.println("10- Periodo orbital (en años)");
        System.out.println("11- Periodo de rotacion (en dias");
        System.out.println("-------------------------------------------------------------------------------");
        int opcion = sca.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("La cantidad de satelites de " + nombre + " es: " + cantDeSatelites);
                break;
            case 2:
                System.out.println("La masa en kilogramos de " + nombre + " es: " + masaKg + " kg");
                break;
            case 3:
                System.out.println("El volumen en kilometros cubicos de " + nombre + " es: " + volumenKmCubicos + " km3");
                break;
            case 4:
                System.out.println("El diametro en kilometros de " + nombre + " es: " + diametroKm + " km");
                break;
            case 5:
                System.out.println("La distancia media al sol de " + nombre + " es: " + distanciaMediaAlSol + " km");
                break;
            case 6:
                System.out.println(nombre + " es un planeta " + tipoDePlaneta);
                break;
            case 7:
                System.out.println(nombre + " es observable a simple vista: " + observable);
                break;
            case 8:
                System.out.println("La densidad de " + nombre + " es: " + calcularDensidad() + " kg/km3");
                break;
            case 9:
                System.out.println(nombre + " es un planeta exterior: " + planetaExterior());
                break;
            default:
                System.out.println("Ingrese una opcion valida");
            case 10:
                System.out.println("El periodo orbital de " + nombre + " es de: " + periodoOrbital + " años");
                break;
            case 11:
                System.out.println("La distancia media al sol de " + nombre + " es: " + periodoDeRotacion + " dias");
                break;
        }
    }

    public double calcularDensidad() {
        return masaKg / volumenKmCubicos;
    }

    public boolean planetaExterior() {
        if (distanciaMediaAlSol >= 508632760) {
            return true;
        } else {
            return false;
        }
    }
}