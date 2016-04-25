package cards;

// Definitely not complete
public class CardTest {
    public static void main(String[] args) {
        CardLibrary lib = new CardLibrary("cards/Cards.txt");
        System.out.println(lib.getCard("Acid Rain"));
    }
}
