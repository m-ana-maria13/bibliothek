import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Buch> list_bucher = new ArrayList<>();

        list_bucher.add(new Buch("Clean Code", "Robert Martin", 45, 464));
        list_bucher.add(new Buch("1984", "George Orwell", 18, 328));
        list_bucher.add(new Buch("Animal Farm", "George Orwell", 12, 112));
        list_bucher.add(new Buch("Java Basics", "Max Müller", 35, 520));
        list_bucher.add(new Buch("The Hobbit", "J. R. R. Tolkien", 28, 310));

        Bibliothek bibliothek = new Bibliothek(list_bucher);
//ub1
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        ArrayList<String> list = bibliothek.bucher_autor(autor);
        if (list.isEmpty()) {
            System.out.println("Kein Buch mit diesen Autor.");
        } else {
            for (String l : list) {
                System.out.println(l);
            }
        }

//ub2

    }
}