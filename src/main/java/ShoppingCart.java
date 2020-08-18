import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    public ArrayList<Product> getReceipt(String filename) {
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
                listOfProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfProducts;
    }
    public void printReceipt(String filename)
    {
        ArrayList<Product> listofProducts = getReceipt(filename);
        float totalSalesTaxes = 0;
        float totalPrice = 0;
        for(Product product : listofProducts){
            product.calculateSalesTaxes();
            totalSalesTaxes += product.getSalesTaxes();
            float taxedPrice = product.getPrice() + product.getSalesTaxes();
            totalPrice += taxedPrice;
            System.out.println(product.getNumberOfProducts() + product.getName() + ": " + taxedPrice );
        }
        System.out.println("Sales Taxes: " + totalSalesTaxes);
        System.out.println("Total: " + totalPrice);
    }
}
