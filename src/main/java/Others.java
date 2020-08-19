import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Others extends Product{

    public Others(String name, float price, int numberOfProducts, float saleTaxes,  boolean isImported) {
        super(name, price, numberOfProducts, saleTaxes, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        float salesTaxes = (float) (this.getPrice() * 0.1);
        if(isImported()){
            salesTaxes += (float) (this.getPrice() * 0.05);
        }
        salesTaxes = (float) (Math.round(salesTaxes * 20) / 20.0);
        setSalesTaxes(salesTaxes);
    }
}