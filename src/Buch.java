public class Buch {
    private String titel;
    private String autor;
    private double preis;
    private int anz_seiten;

    public Buch(String titel, String autor, double preis, int anz_seiten){
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this. anz_seiten = anz_seiten;
    }



    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreis() {
        return preis;
    }

    public int getAnz_seiten() {
        return anz_seiten;
    }
}
