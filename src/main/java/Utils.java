import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    private static final Logger LOGGER = Logger.getLogger( Utils.class.getName() );
    public static List<Product> readReceiptByFile(String filename) throws FileNotFoundException{
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                int firstIndexOfBackspace = line.indexOf(" ");
                int lastIndexOfAt = line.lastIndexOf("at");
                if(firstIndexOfBackspace != -1 && lastIndexOfAt != -1)
                {
                    int numberOfProducts = Integer.parseInt(line.substring(0,firstIndexOfBackspace));
                    String productName = line.substring(firstIndexOfBackspace,lastIndexOfAt-1);
                    float price = Float.parseFloat(line.substring(lastIndexOfAt+3));
                    boolean isImported = productName.contains("imported");

                    listOfProducts.add(classifyProduct(productName,price,isImported,0,numberOfProducts));
                }else {
                    LOGGER.log(Level.WARNING,"input data is not valid");
                    return null;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return listOfProducts;
    }

    public static Product classifyProduct(String productName,float price, boolean isImported, float saleTaxes,int numberOfProducts){
        Product product;
        if(productName.contains("book")) {
            product = new Book(productName,price,numberOfProducts,saleTaxes,isImported);
        }else if(productName.contains("chocolate")){
            product = new Food(productName,price,numberOfProducts,saleTaxes,isImported);
        }else if(productName.contains("pills")) {
            product = new Medical(productName,price,numberOfProducts,saleTaxes,isImported);
        }else{
            product = new Others(productName,price,numberOfProducts,saleTaxes,isImported);
        }
        return product;
    }

    public static String readOutputFile(String fileName){
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
}
