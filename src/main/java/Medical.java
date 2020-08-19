import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Medical extends Product{

    public Medical(String name, float price, int numberOfProducts, float saleTaxes,  boolean isImported) {
        super(name, price, numberOfProducts, saleTaxes, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        if(isImported()){
            float salesTaxes = getSalesTaxes() + (float) (this.getPrice() * 0.05);
            salesTaxes = (float) (Math.round(salesTaxes * 20) / 20.0);
            setSalesTaxes(salesTaxes);
        }
    }
}