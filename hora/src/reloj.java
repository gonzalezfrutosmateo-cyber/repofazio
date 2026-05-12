public class reloj {

int hh;
int mm;

public reloj(int hh, int mm){
    this.hh= hh;
    this.mm= mm;
}
public void imprimir(){
    if(hh>=24 || mm>=60){
    System.out.println("La hora ingresada es invalida"); 
}
    else {
        System.out.println("Su hora es: " + hh + ":" + mm);
        }
}
}
