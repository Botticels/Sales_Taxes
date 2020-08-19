import java.util.List;

public class Shop {

    public void printBill(String fileName){
        BillService billService = new BillService();
        List<Product> listOfProducts = billService.createBill(fileName);
        float totalTaxes = 0, totalPrice = 0;
        if(!listOfProducts.isEmpty()) {
            for (Product product : listOfProducts) {
                System.out.println(product.print());
                totalPrice += product.getPrice();
                totalTaxes += product.getSalesTaxes();
            }
            System.out.println("Sales Taxes: " + totalTaxes);
            System.out.println("Total: " + totalPrice);
        }else{
            System.err.println("no purchased product");
        }
    }

}

