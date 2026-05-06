public class Rectangulo {
    double ancho;
    double alto;
    public Rectangulo (double ancho, double alto)
    {
        this.ancho = ancho;
        this.alto = alto;
    }
    public double calcularArea()
    {
        return ancho * alto;
    }
}
