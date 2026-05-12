public class Mascota {
    String nombre;
    int tipo;

    public Mascota(String nombre, int tipo) { 
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void hacerSonido(int tipo) { 
        if (tipo == 1) {
            System.out.println(nombre + " dice: " + "Guau Guau!"); 
        } else if (tipo == 2) {
            System.out.println(nombre + " dice: " + "Miau Miau!");
        } else if (tipo == 3) {
            System.out.println(nombre + " dice: " + "Pio Pio!");
        }
    }
}