import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Others extends Product{
    private float salesTaxes;

    public Others(String name, float price, boolean isImported, int numberOfProducts) {
        super(name, price, numberOfProducts, isImported);
        this.salesTaxes = 0;
    }

    @Override
    public void calculateSalesTaxes() {
        this.salesTaxes = 0;
    }
}