package cards;

// Definitely not complete
public class CardTest {
    public static void main(String[] args) {
        CardLibrary lib = new CardLibrary(args[0]);
        System.out.println(lib.size() + " cards");
        System.out.println(lib.getRandomCard());
    }
}
