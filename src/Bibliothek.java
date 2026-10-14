import java.util.*;


public class Bibliothek {
    private ArrayList<Buch> bucher;

    public Bibliothek(ArrayList<Buch> b) {
        this.bucher = new ArrayList<>();
        for (Buch buch : b) {
            this.bucher.add(new Buch(buch.getTitel(), buch.getAutor(),
                    buch.getPreis(), buch.getAnz_seiten()));
        }
    }

    public ArrayList<String> bucher_autor (String autor){
        ArrayList<String> titel = new ArrayList<>();
        for (Buch buch : bucher){
            if(autor.equals(buch.getAutor()))
                titel.add(buch.getTitel());
        }
        return titel;
    }
}
