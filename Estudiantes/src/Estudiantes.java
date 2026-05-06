import java.util.Scanner;
public class Estudiantes 
{
    String nombre;
    double calificacion;
    public Estudiantes(String nombre, double calificacion)
    {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
    public String estado()
    {
        return calificacion >= 6 ? "Aprobado" : "Reprobado";
    }
}
