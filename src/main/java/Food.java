import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food extends Product{
    private float salesTaxes;

    public Food(String name, float price, boolean isImported, int numberOfProducts) {
        super(name, price, numberOfProducts, isImported);
        this.salesTaxes = 0;
    }

    @Override
    public void calculateSalesTaxes() {
        this.salesTaxes = 0;
    }
}