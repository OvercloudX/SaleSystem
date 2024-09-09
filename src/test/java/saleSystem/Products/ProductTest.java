package saleSystem.Products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saleSystem.Exceptions.PriceInitLessThanZeroException;
import saleSystem.Exceptions.SizeNumberLessThanOneException;
import saleSystem.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;
    private Goods goods;

    //BeforeEach means it gonna run before each Test
    @BeforeEach
    public void setUp() throws PriceInitLessThanZeroException, SizeNumberLessThanOneException {
        this.goods = new Book(10, "Java Instructor");
        this.product = new Product(goods, 25, "Java Instructors");
    }

    @Test
    public void testGetGoods() {
        Goods testGoods = product.getGoods();
        assertEquals(goods, testGoods);
    }


    @Test
    void testGetSize() {
        assertEquals(25,product.getSize());
    }

    @Test
    void testSetSize() throws SizeNumberLessThanOneException {
        product.setSize(30);
        assertEquals(30,product.getSize());
    }

    @Test
    void testGetProductPrice() {
        double productPrice = 10 * (1+0.06) * 25; // the price expected
        assertEquals(productPrice, product.getProductPrice());
    }
}