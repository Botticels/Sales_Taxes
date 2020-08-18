public class Others extends Product{
    private float salesTaxes;
    public Others(String name, float price, boolean isImported, int numberOfProducts) {
        super.setNumberOfProducts(numberOfProducts);
        super.setName(name);
        super.setPrice(price);
        super.setIsImported(isImported);
        this.salesTaxes = 0;
    }
    @Override
    public void calculateSalesTaxes() {
        this.salesTaxes = 0;
    }
    public float getSalesTaxes(){
        return salesTaxes;
    }
    public void setSalesTaxes(float salesTaxes) {
        this.salesTaxes = salesTaxes;
    }
}