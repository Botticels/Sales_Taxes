import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private List<Product> products;
    private double totalPrice = 0;
    private double totalTaxes = 0;

    public String toString(){
        String output = new String();
        if(products != null && !products.isEmpty()) {
            for (Product product : products) {
                output += product.toString();
            }
            output += "Sales Taxes: " + String.format("%.2f", totalTaxes).replace(",", ".") +"\r\n";
            output += "Total: " + String.format("%.2f", totalPrice).replace(",", ".") +"\r\n";
        }
        return output;
    }
}
