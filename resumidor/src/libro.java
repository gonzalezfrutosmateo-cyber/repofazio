public class libro {

String titulo;
String nomDeAutor;
int cantDePag;

public libro(String titulo, String nomDeAutor, int cantDePag){
    this.titulo= titulo;
    this.nomDeAutor= nomDeAutor;
    this.cantDePag= cantDePag;
}
public void imprimir(){
    System.out.println("------------------------------------------------------");
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + nomDeAutor);
    System.out.println("Nro De Paginas: " + cantDePag);
    System.out.println("------------------------------------------------------");
}

}
