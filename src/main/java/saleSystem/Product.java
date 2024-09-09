package saleSystem;

import saleSystem.Exceptions.SizeNumberLessThanOneException;
import saleSystem.Products.Goods;

/**
 * Class Product contains goods and size
 * Its object can be "added" into a cart
 *
 * Product can calculate the total price with its size
 */
public class Product {


    private String name;
    private Goods goods;
    private int size; // the size of product should be more than 0

    /**
     * A constructor for Product
     * @param goods
     * @param size
     * @param name
     * Name should be unique for each product,
     * because it relates to the deletion and modification of product
     */
    public Product(Goods goods, int size, String name) {
        if(size <= 0){
            throw new SizeNumberLessThanOneException();
        }
        this.goods = goods;
        this.size = size;
        this.name = name;
    }

    //Goods is private, we need a getter to reach it
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    //size is private, we need a getter to reach it
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size <= 0){
            throw new SizeNumberLessThanOneException();
        }
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * The product in the cart can calculate its own total price
     * productPrice = priceFinal(unit) * size
     * @return productPrice
     */
    public double getProductPrice() {
        return goods.getPriceFinal() * size;
    }
}
