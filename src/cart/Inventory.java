package cart;

import java.util.HashMap;
import java.util.Map;
import static cart.Product.*;

public class Inventory {

    private static Map<Product,Item> stock =  new HashMap<>();

    static{

        stock.put(Apple,new Item(Apple, 35));
        stock.put(Banana,new Item(Banana, 20));
        stock.put(Melon,new Item(Melon, 50));
        stock.put(Lime,new Item(Lime, 15));
    }

    public static Item getItem(Product product){
        return stock.containsKey(product)?stock.get(product):null;
    }
}