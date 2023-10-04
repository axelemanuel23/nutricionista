package entidades;

public class DietaComida {
    private int idDietaComida;
    private int idComida;
    private int idDieta;

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

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }
     public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }
    

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    @Override
    public String toString() {
        return idDietaComida + "," + idComida + "," + idDieta;
    }
    

}
