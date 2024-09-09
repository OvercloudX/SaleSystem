package saleSystem.Products;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saleSystem.Cart;
import saleSystem.Exceptions.PriceInitLessThanZeroException;
import saleSystem.Exceptions.SizeNumberLessThanOneException;
import saleSystem.Product;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart testCart;
    private Goods testGoods;
    @BeforeEach
    public void setUp() {
        this.testCart = new Cart();
        this.testGoods = new Book(12,"Book");
        testCart.add(10, testGoods, "Books");
    }

    @Test
    public void testAdd() {
        List<Product> productList = testCart.getProductList();
        assertEquals(10,productList.get(productList.size()-1).getSize());
        assertEquals(testGoods, productList.get(productList.size()-1).getGoods());
        assertEquals("Books", productList.get(productList.size()-1).getName());
        //Compare the values to test if it works
    }

    @Test
    void testDelete() {
        testCart.delete("Books");
        assertEquals(0,testCart.getProductList().size());
    }

    @Test
    void testChangeSizeOfProduct() {
        List<Product> productList = testCart.getProductList();
        testCart.changeSizeOfProduct(5,"Books");
        assertEquals(5, productList.get(productList.size()-1).getSize());
    }

    @Test
    void testGetTotalPrice() {
        assertEquals(10*(12*(1+0.06)), testCart.getTotalPrice());
    }

    @Test
    public void testSizeNumberLessThanOneException(){
        assertThrows(SizeNumberLessThanOneException.class, () -> {
            // Try to add a size that is less than 1, it should throw exception
            testCart.add(0, testGoods, "Books_2");
        });
    }
}