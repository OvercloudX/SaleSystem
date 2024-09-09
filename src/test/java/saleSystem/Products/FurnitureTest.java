package saleSystem.Products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saleSystem.Exceptions.PriceInitLessThanZeroException;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureTest {

    private Furniture furniture;

    @BeforeEach
    public void setUp() {
        this.furniture = new Furniture(200, "closet");
    }

    @Test
    public void testConstructor(){
        assertEquals(200, furniture.getPriceInit());
        assertEquals("closet", furniture.getName());
    }


    @Test
    public void testSetPriceInit() {
        furniture.setPriceInit(300.01);
        assertEquals(300.01, furniture.getPriceInit());
    }

    @Test
    public void testGetTaxFurniture() {
        assertEquals(0.2, Furniture.TAX_FURNITURE);
    }

    @Test
    public void testGetPriceFinal() {
        double priceFinal = furniture.getPriceFinal();
        assertEquals(240, priceFinal);
    }

    @Test
    public void testPriceInitLessThanZeroException(){
        assertThrows(PriceInitLessThanZeroException.class, () -> {
            //Try to set the priceInit less than 0
            this.furniture.setPriceInit(-1);
        });
    }
}