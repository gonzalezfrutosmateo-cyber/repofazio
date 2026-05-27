public class cochesPro {
    public static void main(String args[]) {
        auto auto1 = new auto("Ford", 2018, 3, "DIESEL", "EJECUTIVO", 5, 6, 250, "NEGRO", true);
        auto1.imprimir();
        auto1.setVelocidadActual(100);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.acelerar(20);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.acelerar(200);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.acelerar(500);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.desacelerar(50);
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.frenar();
        System.out.println("Velocidad actual = " + auto1.velocidadActual);
        auto1.desacelerar(20);
        System.out.println("¿Tiene multas?: " + auto1.tieneMultas());
        System.out.println("Total de multas: $" + auto1.valorTotalMultas());
        System.out.println("Manual o automático:");
        auto1.transmisions();
    }
}