package saleSystem;

import java.util.ArrayList;
import java.util.List;

import saleSystem.Exceptions.SizeNumberLessThanOneException;
import saleSystem.Products.Goods;

/**
 * Cart is a functional shopping class
 * It can add products and calculate total price
 */
public class Cart {
    private List<Product> productList;

    /**
     * When we create a  cart, it has a blank product list
     */
    public Cart(){
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList(){
        return this.productList;
    }

    //在具体main函数里，传入的goods = new 家具或书（），也就是接口 对象=new 实现类

    /**
     * Here we need to input the size of the product and an object of interface Goods
     * choose a product that you want and create an object of its class which actually implements the interface Goods
     *
     * @param size
     * @param goods
     */
    public void add(int size, Goods goods, String name) {
        if(size <= 0){
            throw new SizeNumberLessThanOneException(); //add number must be not less than 1
        }
            productList.add(new Product(goods, size, name));


    }

    /**
     * Remove a product from the cart
     */
    public void delete(String name) {
        productList.removeIf(product -> product.getName().equals(name)); //remove a product whose goods is eligible

        //TODO we may need destroy the object Goods here?
    }

    /**
     * Change the size of a product in the cart
     */
    public void changeSizeOfProduct(int size, String name) {
        if(size <= 0){
            throw new SizeNumberLessThanOneException(); //size number must be not less than 1
        }

        for (Product product : productList){
            if (product.getName().equals(name)){
                product.setSize(size);
            }
        }
    }

    /**
     * This method can calculate the sum price of all products in the cart
     * @return res
     */
    public double getTotalPrice() {
        double res = 0;
        for (Product product : productList) {
            res += product.getProductPrice();
        }
        return res;
    }



}
