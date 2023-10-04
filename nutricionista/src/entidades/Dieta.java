package entidades;


import java.time.LocalDate;

public class Dieta {
    private int idDieta;
    private String nombre;
    private Paciente paciente;
    private LocalDate fechaInicial;//Comienza la dieta
    private double pesoInicial;//Comienza la dieta
    private double meta;//Peso Objetivo
    private double pesoFinal;//Peso conseguido
    private LocalDate fechaFinal;//Fin de la dieta

    public Dieta() {
    }

    public Dieta(String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial,double meta, double pesoFinal, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.meta = meta;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
    }

    public Dieta(int idDieta, String nombre, Paciente paciente, LocalDate fechaInicial, double pesoInicial,double meta, double pesoFinal, LocalDate fechaFinal) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.pesoInicial = pesoInicial;
        this.meta = meta;
        this.pesoFinal = pesoFinal;
        this.fechaFinal = fechaFinal;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }
    
    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    public boolean finalizado(){
        return this.fechaFinal.isBefore(LocalDate.now());
    }
    
    public boolean metaCumplida(){
        if(finalizado()){
            return this.pesoFinal == meta ;
        }else{
            return false;
        }
        
    }
    
    @Override
    public String toString() {
        return idDieta + "," + nombre + "," + paciente + "," + fechaInicial + "," + pesoInicial + "," + meta + ", " + pesoFinal + "," + fechaFinal;
    }
    
}
