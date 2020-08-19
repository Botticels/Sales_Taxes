import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

class BillTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void printBill() {
        Shop shop = new Shop();
        shop.printBill(".\\src\\test\\java\\test1.txt");
        String expectedOutput = readOutputFile(".\\src\\test\\java\\output1.txt");
        //Assert.assertEquals(expectedOutput,outContent.toString());

        Shop shop2 = new Shop();
        shop2.printBill(".\\src\\test\\java\\test3.txt");
        String expectedOutput2 = readOutputFile(".\\src\\test\\java\\output2.txt");
        //Assert.assertEquals(expectedOutput2,outContent.toString());

        Shop shop3 = new Shop();
        shop3.printBill(".\\src\\test\\java\\test3.txt");
        String expectedOutput3 = readOutputFile(".\\src\\test\\java\\output3.txt");
        //Assert.assertEquals(expectedOutput3,outContent.toString());
    }
    @Test
    void EmptyFile() {
        Shop shop = new Shop();
        shop.printBill(".\\src\\test\\java\\emptyFile.txt");
        Assert.assertEquals("no purchased product\r\n",errContent.toString());
    }
    @Test
    void noFileFound() {
        Shop shop = new Shop();
        shop.printBill(".\\src\\test\\java\\noFileFound.txt");
        Assert.assertEquals(".\\src\\test\\java\\noFileFound.txt (Impossibile " +
                "trovare il file specificato)\r\n" +
                "no purchased product\r\n",errContent.toString());
    }

    public String readOutputFile(String fileName){
        String output = "";
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                output += scanner.nextLine();
                output += "\r\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }

    @AfterEach
    void restore(){
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}