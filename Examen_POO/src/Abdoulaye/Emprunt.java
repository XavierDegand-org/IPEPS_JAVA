package Abdoulaye;

public class Emprunt {
    private int nombre = 0;
    boolean emprunt;

    void Emprunt() {
        this.emprunt = true;
    }

    public int getNombre() {
        return nombre;
    }
    public void getEmprunteur(){

    }
    public void setEmprunteur(){

    }
    public void getMateriel(){

    }
    public void getArticle(){

    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "nombre=" + nombre +
                ", emprunt=" + emprunt +
                '}';
    }
}
