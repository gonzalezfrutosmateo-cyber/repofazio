
public class Producto {
    String nombre;
    int precio;


public Producto(String nombre, int precio){
    this.nombre= nombre;
    this.precio= precio;
}

public int calcularIva(int precio){
return precio+(precio*21/100);
}
}


