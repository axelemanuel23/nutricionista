package entidades;

public class DietaComida {
    int idDietaComida;
    Comida comida;
    Dieta dieta;

    public DietaComida() {
    }

    public DietaComida(Comida comida, Dieta dieta) {
        this.comida = comida;
        this.dieta = dieta;
    }

    public DietaComida(int idDietaComida, Comida comida, Dieta dieta) {
        this.idDietaComida = idDietaComida;
        this.comida = comida;
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return idDietaComida + "," + comida + "," + dieta;
    }
    

}
