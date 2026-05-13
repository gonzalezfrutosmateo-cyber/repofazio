
import java.util.Scanner;


public class Planeta {
    
    String nombre;
    int cantDeSatelites;
    double masaKg;
    double volumenKmCubicos;
    int diametroKm = 0;
    int distanciaMediaAlSol = 0;
    String tipoDePlaneta;
    boolean observable = false;
    
    public Planeta(String nombre,int cantDeSatelites,double masaKg,double volumenKmCubicos, int diametroKm , int distanciaMediaAlSol, String tipoDePlaneta, boolean observable){
    this.nombre = nombre;
    this.cantDeSatelites = cantDeSatelites;
    this.masaKg = masaKg;
    this.volumenKmCubicos = volumenKmCubicos;
    this.diametroKm = diametroKm;
    this.distanciaMediaAlSol = distanciaMediaAlSol;
    this.tipoDePlaneta = tipoDePlaneta;
    this.observable = observable;
    }
    
        
    
    public void menuPlaneta(){
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
    System.out.println("-------------------------------------------------------------------------------");
    int opcion = sca.nextInt();
    switch (opcion) {
                case 1: System.out.println("La cantidad de satelites de" + nombre + " es:" + cantDeSatelites);
                case 2: System.out.println("La Masa en kilogramos de" + nombre + " es:" + masaKg);
                case 3: System.out.println("El volumen en kilometros cubicos es de" + nombre + " es:" + volumenKmCubicos);
                case 4: System.out.println("El diametro en kilometros es de" + nombre + " es:" + diametroKm);
                case 5: System.out.println("La distancia media al sol de" + nombre + " es:" + distanciaMediaAlSol);
                case 6: System.out.println(nombre + " es un planeta" + tipoDePlaneta);
                case 7: System.out.println(nombre + " es:" + observable + "a plena vista!");
                case 8: System.out.println("La densidad de" + nombre + " es:" + .calcularDensidad);
                case 9: System.out.println("La cantidad de satelites de" + nombre + " es:" + .planetaExterior);
                default: System.out.println("Ingrese una opcion valida");
    }
    
    public int calcularDensidad(){
        return masaKg/volumenKmCubicos;
    }
    
    publid void planetaExterior(){
        if (distanciaMediaAlSol>=508632760){
        return true;
        }
        else{
        return false;
        }
    } 
}
