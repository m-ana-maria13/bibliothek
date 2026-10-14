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

    public double durchschnitt(ArrayList<String> list_titel) {
        int nr = 0;
        int sum = 0;

        for (String titel : list_titel) {
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

    public ArrayList<String> bucher_kleinerGleich(double max_preis){
        ArrayList<String> list_titel = new ArrayList<>();

        for (Buch b : bucher) {
            if(b.getPreis() <= max_preis)
            {
                list_titel.add(b.getTitel());
            }
        }
        return list_titel;
    }

    public String teuerstes_buch(ArrayList<String> list_titel){
        double max_preis = 0.0;
        String titel = null;
        for(String t : list_titel){
            for(Buch b: bucher){
                if(t.equals(b.getTitel()) && b.getPreis() > max_preis){
                    max_preis = b.getPreis();
                    titel = t;
                }
            }
        }
        if (titel == null)
            return "";
        return titel + " (" + max_preis + ")";
    }

    public ArrayList<String> mindestanz_seiten(int min_seiten){
         ArrayList<String> list_titel = new ArrayList<>();
         for(Buch b : bucher){
             if(b.getSeiten() >= min_seiten){
                 list_titel.add(b.getTitel());
             }
         }
         return list_titel;
    }
}
