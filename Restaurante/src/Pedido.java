public class Pedido {
public void calcularPedido(String primerPlato, double costoPrimerPlato, String bebida, double costoBebida) {
double total = costoPrimerPlato + costoBebida;
System.out.println("El costo de " + primerPlato + " y " + bebida + "es = $" + total);
}

public void calcularPedido (String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato, String bebida, double costoBebida) {
double total = costoPrimerPlato + costoSegundoPlato + costoBebida;
System.out.println("El costo de " + primerPlato + "  " + segundoPlato + " y " + bebida + "es = $" + total);
}
public void calcularPedido (String primerPlato, double costoPrimerPlato, String segundoPlato, double costoSegundoPlato,String postre, double Costopostre, String bebida, double costoBebida) {
double total = costoPrimerPlato + costoSegundoPlato +Costopostre+ costoBebida;
System.out.println("El costo de " + primerPlato + " , " + segundoPlato + " , " + postre +" y "+bebida+ " es = $" + total);
}

}


