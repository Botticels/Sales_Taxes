import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {

    private String name;
    private float price;
    private int numberOfProducts;
    private float salesTaxes = 0;
    private boolean isImported;

    public abstract void calculateSalesTaxes();
    public String toString()
    {
        return numberOfProducts + name + ": " + String.format("%.2f", price*numberOfProducts).replace(",", ".") + "\r\n";
    }
}

