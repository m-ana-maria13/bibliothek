import java.util.*;


public class Bibliothek {
    private ArrayList<Buch> bucher;

    public Bibliothek(ArrayList<Buch> b) {
        this.bucher = new ArrayList<>();
        for (Buch buch : b) {
            this.bucher.add(new Buch(buch.getTitel(), buch.getAutor(),
                    buch.getPreis(), buch.getSeiten()));
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

    public double durchschnitt(ArrayList<String> list_title) {
        int nr = 0;
        int sum = 0;

        for (String titel : list_title) {
            for (Buch b : bucher) {
                if (b.getTitel().equals(titel)) {
                    sum += b.getSeiten();
                    nr++;
                }
            }
        }


        if (nr == 0) {
            return 0;
        }
        return (double) sum / nr;
    }
}
