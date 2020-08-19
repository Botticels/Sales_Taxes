import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class BillTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testBill3Products() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/test1.txt");
        String expectedOutput = Utils.readOutputFile("./src/test/java/output1.txt");
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testBillWithImportedProducts() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/test2.txt");
        String expectedOutput = Utils.readOutputFile("./src/test/java/output2.txt");
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testBillMixedProductTypes() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/test3.txt");
        String expectedOutput = Utils.readOutputFile("./src/test/java/output3.txt");
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testMultipleProducts() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/testMultipleProducts.txt");
        String expectedOutput = Utils.readOutputFile("./src/test/java/outputMultipleProducts.txt");
        Assert.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void emptyFile() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/emptyFile.txt");
        Assert.assertEquals("",outContent.toString());
    }
    @Test
    void fileNotFound() {
        Shop shop = new Shop();
        Assert.assertThrows(FileNotFoundException.class,()->{shop.printBill("./src/test/java/noFileFound.txt");});
    }
    @Test
    void notValidData() throws FileNotFoundException{
        Shop shop = new Shop();
        shop.printBill("./src/test/java/invalidInputTest.txt");
        Assert.assertEquals("",outContent.toString());
    }

    @AfterEach
    void restore(){
        System.setOut(originalOut);
    }
}