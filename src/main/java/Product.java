public abstract class Product {
    private String name;
    private float price;
    private int numberOfProducts;
    private boolean isImported;

    public String getName(){
        return name;
    }
    public void setName(String name){ this.name = name; }
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public int getNumberOfProducts(){
        return numberOfProducts;
    }
    public void setNumberOfProducts(int numberOfProducts){ this.numberOfProducts = numberOfProducts; }
    public boolean getIsImported(){ return isImported; }
    public void setIsImported(boolean isImported){
        this.isImported = isImported;
    }

    public abstract void calculateSalesTaxes();
    public abstract float getSalesTaxes();
}
