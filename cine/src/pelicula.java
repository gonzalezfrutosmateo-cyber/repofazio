public class pelicula {

String titulo;
String nomDeAutor;
String genero;

public pelicula(String titulo, String nomDeAutor, String genero){
    this.titulo= titulo;
    this.nomDeAutor= nomDeAutor;
    this.genero= genero;
}
public void imprimir(){
    System.out.println("------------------------------------------------------");
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + nomDeAutor);
    System.out.println("Genero: " + genero);
    System.out.println("------------------------------------------------------");
}

}
