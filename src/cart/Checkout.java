package cart;

import java.util.Map;
import java.util.stream.Stream;
import static cart.ItemDiscountCalculations.getDiscount;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Checkout {

    public static Map<Product,Integer> getInvoice(Stream<Product> basket){
        return basket.map(p->Inventory.getItem(p) ).collect(toList()).stream().
                collect(groupingBy(Item::getProduct)).entrySet().stream().
                collect(toMap(Map.Entry::getKey, entry -> (entry.getValue().stream().mapToInt(i->i.getPrice()).sum())- getDiscount(Inventory.getItem(entry.getKey()), entry.getValue().size())));
    }

    public static void printInvoiceStatement(Map<Product,Integer> invoice ){
        invoice.forEach((k,v) -> System.out.println(k+" : "+v));
    }

    public static int getTotalCost(Map<Product,Integer> invoice ){
        return invoice.values().stream().mapToInt(i->i).sum();
    }
}
