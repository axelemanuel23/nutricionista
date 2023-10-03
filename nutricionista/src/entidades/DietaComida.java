package entidades;

public class DietaComida {
    int idDietaComida;
    int idComida;
    int idDieta;

    public DietaComida() {
    }

    public DietaComida(int idComida, int idDieta) {
        this.idComida = idComida;
        this.idDieta = idDieta;
    }

    public DietaComida(int idDietaComida, int idComida, int idDieta) {
        this.idDietaComida = idDietaComida;
        this.idComida = idComida;
        this.idDieta = idDieta;
    }

    @Override
    public String toString() {
        return idDietaComida + "," + idComida + "," + idDieta;
    }
    

}
