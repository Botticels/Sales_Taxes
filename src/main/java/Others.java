import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Others extends Product{

    public Others(String name, float price, int numberOfProducts, float saleTaxes, boolean isImported) {
        super(name, price, numberOfProducts, saleTaxes, isImported);
    }

    @Override
    public void calculateSalesTaxes() {
        //10% tax to all goods except Food,Medical and Book products
        float salesTaxes = (float) (this.getPrice() * DEFAULT_TAX_RATE_FOR_GOODS);
        if(isImported()){
            //5% tax to all imported products
            salesTaxes += (float) (this.getPrice() * DEFAULT_IMPORT_TAX_RATE);
        }
        //round up the sales taxes up to the nearest 0.05
        salesTaxes = (float) (Math.round(salesTaxes * 20) / 20.0);
        setSalesTaxes(salesTaxes);
    }
}