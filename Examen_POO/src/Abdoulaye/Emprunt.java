package Abdoulaye;

public class Emprunt {
    private int nombre = 0;
    boolean emprunt;

    void Emprunt() {
        this.emprunt = true;
    }

    void Retour(){
        this.emprunt = false;
    }

    public int getNombre() {
        return nombre;
    }

    public void getEmprunteur(){

    }
    public Produit setEmprunteur(){

        return null;
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
