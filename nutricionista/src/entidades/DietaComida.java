package entidades;

public class DietaComida {
    int idDietaComida;
    int idComida;
    int idDieta;

    public DietaComida() {
    }

    public DietaComida(int idDieta, int idComida) {
        this.idComida = idComida;
        this.idDieta = idDieta;
    }

    public DietaComida(int idDietaComida, int idDieta, int idComida) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
    }

    @Override
    public String toString() {
        return idDietaComida + "," + idComida + "," + idDieta;
    }
    

}
