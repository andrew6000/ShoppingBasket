package cart;

import java.util.Map;
import java.util.stream.Stream;
import static cart.Checkout.getInvoice;
import static cart.Checkout.getTotalCost;
import static cart.Checkout.printInvoiceStatement;
import static cart.Product.*;
import static java.util.Collections.nCopies;
import static java.util.stream.Stream.of;

public class Shopping {

    public static void main(String agrs[]){
        Stream<Product> basket =  of(nCopies(4, Apple),
                nCopies(6, Banana),
                nCopies(10, Lime),
                nCopies(11, Melon))
                .flatMap(x -> x.stream());

        Map<Product,Integer> invoice =  getInvoice(basket);

        printInvoiceStatement(invoice);
        System.out.println("\nTotal Cost: "+getTotalCost(invoice));
    }
}
