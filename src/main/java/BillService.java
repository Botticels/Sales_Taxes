import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillService {
    public List<Product> createBill(String filename)
    {
        List<Product> listofProducts = getReceipt(filename);
        for(Product product : listofProducts){
            product.calculateSalesTaxes();
            product.setPrice(product.getPrice() + product.getSalesTaxes());
        }
        return listofProducts;
    }

    public List<Product> getReceipt(String filename) {
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                int firstIndexOfBackspace = line.indexOf(" ");
                int lastIndexOfAt = line.lastIndexOf("at");
                int numberOfProducts = Integer.parseInt(line.substring(0,firstIndexOfBackspace));
                String productName = line.substring(firstIndexOfBackspace,lastIndexOfAt);
                float price = Float.parseFloat(line.substring(lastIndexOfAt+3));
                boolean isImported = productName.contains("imported");

                listOfProducts.add(classifyProduct(productName,price,isImported,numberOfProducts));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return listOfProducts;
    }

    public Product classifyProduct(String productName,float price, boolean isImported,int numberOfProducts){
        Product product;
        if(productName.contains("book")) {
            product = new Book(productName,price,isImported,numberOfProducts);
        }else if(productName.contains("chocolate")){
            product = new Food(productName,price,isImported,numberOfProducts);
        }else if(productName.contains("pills")) {
            product = new Medical(productName,price,isImported,numberOfProducts);
        }else{
            product = new Others(productName,price,isImported,numberOfProducts);
        }
        return product;
    }

}
