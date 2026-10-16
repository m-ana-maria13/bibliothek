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

    public ArrayList<String> bucher_autor(String autor) {
        ArrayList<String> list_titel = new ArrayList<>();
        for (Buch buch : bucher) {
            if (autor.equals(buch.getAutor()))
                list_titel.add(buch.getTitel());
        }
        if(list_titel.isEmpty())
            return null;

        return list_titel;
    }

    public double durchschnitt(ArrayList<String> list_titel) {
        int nr = 0;
        int sum = 0;

        for (String t : list_titel) {
            for (Buch b : bucher) {
                if (b.getTitel().equals(t)) {
                    sum += b.getSeiten();
                    nr++;
                }
            }
        }


        if (nr == 0)
            return 0;

        return (double) sum / nr;
    }

    public ArrayList<String> bucher_biliger_als(double max_preis) {
        ArrayList<String> list_titel = new ArrayList<>();

        for (Buch b : bucher) {
            if (b.getPreis() <= max_preis) {
                list_titel.add(b.getTitel());
            }
        }
        if(list_titel.isEmpty())
            return null;

        return list_titel;
    }

    public String teuerstes_buch(ArrayList<String> list_titel) {
        double max_preis = 0.0;
        String titel = null;

        for (String t : list_titel) {
            for (Buch b : bucher) {
                if (t.equals(b.getTitel()) && b.getPreis() > max_preis) {
                    max_preis = b.getPreis();
                    titel = t;
                }
            }
        }
        if (titel == null)
            return null;

        return titel + " (" + max_preis + ")";
    }

    public ArrayList<String> mindest_anz_seiten(int min_seiten) {
        ArrayList<String> list_titel = new ArrayList<>();
        for (Buch b : bucher) {
            if (b.getSeiten() >= min_seiten) {
                list_titel.add(b.getTitel());
            }
        }
        if(list_titel.isEmpty())
            return null;

        return list_titel;
    }

    public String komb_bucher(double buget) {
        double maxPreis = 0.0;
        int maxSeiten = 0;
        String buch1 = null, buch2 = null;

        for (int i = 0; i < bucher.size(); i++) {
            for (int j = i + 1; j < bucher.size(); j++) {
                Buch b1 = bucher.get(i);
                Buch b2 = bucher.get(j);

                double summe = b1.getPreis() + b2.getPreis();
                int seiten = b1.getSeiten() + b2.getSeiten();

                if (summe <= buget  &&
                    (summe > maxPreis || (summe == maxPreis && seiten > maxSeiten))) {
                    maxPreis = summe;
                    maxSeiten = seiten;
                    buch1 = b1.getTitel();
                    buch2 = b2.getTitel();
                }
            }
        }

        if (buch1 == null)
            return null;

       return buch1 + " + " + buch2 + "\nGesamtpreis: " + maxPreis + " Euro";

    }

    public static void print_string(ArrayList<String> liste){

        if (liste == null || liste.isEmpty()) {
            System.out.println("Kein solches Buch.");
        }
        else {
            for (String l : liste) {
                System.out.println(l);
            }
        }
    }
}