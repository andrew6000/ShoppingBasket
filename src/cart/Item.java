package cart;

public class Item {
    private final Product product;
    private final int price;

    public Item(Product _product, int _price){

        this.product=_product;
        this.price = _price;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getPrice(){
        return this.price;
    }

    public String toString(){
        return "("+product.toString()+","+price+")";
    }
}
