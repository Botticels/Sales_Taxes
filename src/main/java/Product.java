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
    private boolean isImported;

    public abstract void calculateSalesTaxes();
    public abstract float getSalesTaxes();
    public String print()
    {
        return numberOfProducts + " " + name + ": " + price;
    }
}

