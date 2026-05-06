
public class circulo {
    double radio;
    
    circulo(double r) { 
        radio = r;
    }
    
    double area() {
        return Math.PI * radio * radio;
    }
    
    double perimetro() {
        return 2 * Math.PI * radio;
    }
}
