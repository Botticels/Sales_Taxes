import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    public static final double DEFAULT_TAX_RATE_FOR_GOODS = 0.1;
    public static final double DEFAULT_IMPORT_TAX_RATE = 0.05;

    private String name;
    private float price;
    private int numberOfProducts;
    private float salesTaxes = 0;
    private boolean isImported;

    public abstract void calculateSalesTaxes();
    public String toString()
    {
        return numberOfProducts + name + ": " + String.format(Locale.ROOT,"%.2f", price*numberOfProducts) + "\r\n";
    }
}

