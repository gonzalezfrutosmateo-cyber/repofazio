public class auto {
    String marca;
    int modelo;
    int motor;
    String tipoCombustible;
    String tipoAutomóvil;
    int númeroPuertas;
    int cantidadAsientos;
    int velocidadMáxima;
    String color;
    int velocidadActual = 0;
    boolean Transmision;
    int cantidadMultas = 0;
    double valorMulta = 500.0;
    double totalMultas = 0.0;

    auto(String marca, int modelo, int motor, String tipoCombustible, String tipoAutomóvil, int númeroPuertas, int cantidadAsientos,int velocidadMáxima, String color, boolean transmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomóvil = tipoAutomóvil;
        this.númeroPuertas = númeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMáxima = velocidadMáxima;
        this.color = color;
        this.Transmision = transmision;
    }
    String getMarca(){
        return marca; }
    int getModelo(){
        return modelo; }
    int getMotor(){
        return motor; }
    String getTipoCombustible(){
        return tipoCombustible; }
    String getTipoAutomóvil(){
        return tipoAutomóvil; }
    int getNúmeroPuertas(){
        return númeroPuertas; }
    int getCantidadAsientos() {
        return cantidadAsientos; }
    int getVelocidadMáxima(){
        return velocidadMáxima; }
    String getColor(){
        return color; }
    int getVelocidadActual(){
        return velocidadActual; }
    boolean getTransmision(){
        return Transmision; }
    int getCantidadMultas(){
        return cantidadMultas; }
    double getTotalMultas(){
        return totalMultas; }
    void setMarca(String marca){
        this.marca = marca; }
    void setModelo(int modelo){
        this.modelo = modelo; }
    void setMotor(int motor){
        this.motor = motor; }
    void setTipoCombustible(String tc){
        this.tipoCombustible = tc; }
    void setTipoAutomóvil(String ta){
        this.tipoAutomóvil = ta; }
    void setNúmeroPuertas(int np){
        this.númeroPuertas = np; }
    void setCantidadAsientos(int ca){
        this.cantidadAsientos = ca; }
    void setVelocidadMáxima(int vm){
        this.velocidadMáxima = vm; }
    void setColor(String color){
        this.color = color; }
    void setVelocidadActual(int velocidadActual){
        this.velocidadActual = velocidadActual; }
    void setTransmision(boolean transmision){
        this.Transmision = transmision; }
    void acelerar(int incrementoVelocidad) {
        if (velocidadActual + incrementoVelocidad <= velocidadMáxima) {
            velocidadActual = velocidadActual + incrementoVelocidad;
        } else {
            cantidadMultas++;
            totalMultas = totalMultas + (valorMulta * cantidadMultas);
            System.out.println("Velocidad máxima superada. Multa generada: $" + (valorMulta * cantidadMultas));
            System.out.println("Total acumulado de multas: $" + totalMultas);
        }}
    void desacelerar(int decrementoVelocidad) {
        if ((velocidadActual - decrementoVelocidad) >= 0) {
            velocidadActual = velocidadActual - decrementoVelocidad;
        } else {
            System.out.println("No se puede decrementar a una velocidad negativa.");
        }
    }
    void frenar() {
        velocidadActual = 0;
    }
    double calcularTiempoLlegada(int distancia) {
        return (double) distancia / velocidadActual;
    }
    boolean tieneMultas() {
        return cantidadMultas > 0;
    }
    double valorTotalMultas() {
        return totalMultas;
    }
    void imprimir() {
        System.out.println("Marca = "                + marca);
        System.out.println("Modelo = "               + modelo);
        System.out.println("Motor = "                + motor);
        System.out.println("Tipo de combustible = "  + tipoCombustible);
        System.out.println("Tipo de automóvil = "    + tipoAutomóvil);
        System.out.println("Número de puertas = "    + númeroPuertas);
        System.out.println("Cantidad de asientos = " + cantidadAsientos);
        System.out.println("Velocidad máxima = "     + velocidadMáxima);
        System.out.println("Color = "                + color);
        System.out.println("Transmisión = "          + (Transmision ? "Automático" : "Manual"));
    }
    void transmisions() {
        if (Transmision) {
            System.out.println("Es Automático");
        } else {
            System.out.println("Es Manual");
        }}}