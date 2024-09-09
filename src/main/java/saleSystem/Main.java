package saleSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import saleSystem.Exceptions.PriceInitLessThanZeroException;
import saleSystem.Exceptions.SizeNumberLessThanOneException;
import saleSystem.Products.Furniture;
import saleSystem.Products.Goods;
import saleSystem.Products.ScienceFictionBook;

/**
 * Here presents an example of sale system
 * First, we need a cart so that we can pick products
 * When you want to get one or several products, use the method "add“ and input the correct params
 * When you want to abandon something that is already in your cart, use the method "delete"
 * When you want to change the size of a product, use the method "changeSizeOfProduct"
 */
public class Main {
    public static void main(String[] args) throws PriceInitLessThanZeroException, SizeNumberLessThanOneException {
        // I got a cart
        Cart cart1 = new Cart();

        // I saw nice chairs in 75 euros and a table in 120 euros
        Goods chair = new Furniture(75, "Chair");
        Goods table = new Furniture(120,"Table");

        // I put them into my cart1
        cart1.add(2, chair, "Chairs");
        cart1.add(1, table, "Tables");

        // I want to buy a science fiction book <<2001: the space odyssey>> with discount and take it into cart1
        Goods spaceOdyssey = new ScienceFictionBook(15,"ScienceFiction", 0.75);
        cart1.add(3,spaceOdyssey,"ScienceFictions");

        // Oh there's too many books! I only want one
        cart1.changeSizeOfProduct(1,"ScienceFictions");

        // I do not like the table now, it's too big to put in my room in MAISEL
        cart1.delete("Tables");

        // Everything is done, let's go to the cashier desk
        double totalPrice = cart1.getTotalPrice();
        System.out.println(totalPrice);

        /**
         * With the calculator in my phone
         * the final price must be 192.15
         */


    }
}