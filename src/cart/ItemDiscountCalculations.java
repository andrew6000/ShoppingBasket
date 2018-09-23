package cart;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import static cart.Product.*;


public class ItemDiscountCalculations{

    private static  Map<Product,BiFunction<Item, Integer,Integer>>  discounts = new HashMap<>();

    static{
        discounts.put(Lime, (i,a) ->  (a/3*i.getPrice()));
        discounts.put(Melon, (i,a) ->  (a/2*i.getPrice()));
    }

    public static int getDiscount(Item item, int amount){
        return discounts.containsKey(item.getProduct())?discounts.get(item.getProduct()).apply(item,amount):0;
    }
}
