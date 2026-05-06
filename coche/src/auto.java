public class auto {

String Marca;
String modelo;
int anio;

public auto(String Marca, String modelo, int anio){
    this.Marca= Marca;
    this.modelo= modelo;
    this.anio= anio;
}
public void imprimir(){
    System.out.println("Marca: " + Marca);
    System.out.println("Modelo: " + modelo);
    System.out.println("Año: " + anio);
}

}
