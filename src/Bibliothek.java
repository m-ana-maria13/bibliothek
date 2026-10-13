import java.util.*;


public class Bibliothek {
    private List<Buch> bucher;

    public Bibliothek(List<Buch> b) {
        this.bucher = new ArrayList<>(b);
    }

    public List<String> bucher_autor (String autor){
        List<String> titel = new ArrayList<>();
        for (Buch buch : bucher){
            if(autor.equals(buch.getAutor()))
                titel.add(buch.getTitel());
        }


        return titel;

    }
}
