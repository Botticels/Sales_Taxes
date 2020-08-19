import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillService implements BillServiceInterface{
    private static final Logger LOGGER = Logger.getLogger( BillService.class.getName() );
    public Bill createBill(String filename) throws FileNotFoundException{
        List<Product> listofProducts = Utils.readReceiptByFile(filename);
        if(listofProducts != null && !listofProducts.isEmpty()){
            float totalPrice = 0, totalTaxes = 0;
            for(Product product : listofProducts){
                product.calculateSalesTaxes();
                product.setPrice(product.getPrice() + product.getSalesTaxes());
                totalTaxes += product.getSalesTaxes();
                totalPrice += product.getPrice();
            }
            Bill bill = new Bill(listofProducts,totalPrice,totalTaxes);
            return bill;
        }else{
            LOGGER.log(Level.WARNING,"input file not valid");
        }
        return new Bill();
    }
}
