import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShoppingCartTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.Test
    void printReceipt() {
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.printReceipt(".\\src\\test\\java\\test1.txt");
        Assert.assertEquals("1 book : 12.49\r\n" +
                "1 music CD : 16.49\r\n" +
                "1 chocolate bar : 0.85\r\n" +
                "Sales Taxes: 1.50\r\n" +
                "Total: 29.83\r\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    void restore(){
        System.setOut(originalOut);
    }

}