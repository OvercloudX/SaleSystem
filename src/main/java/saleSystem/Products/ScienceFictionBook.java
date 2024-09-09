package saleSystem.Products;

import saleSystem.Exceptions.PriceInitLessThanZeroException;

/**
 * Now the store is on sale, good news!
 * Every science fiction book has a discount to everyone!
 *
 * Attention: The discount is only for Initial Price, not for tax
 * You should calculate tax with initial price.
 *
 * For example: A science fiction book's initial price is 20 euros
 * it has a discount 30%, so the price on sale is 14 euros.
 * But the tax is still (20 * 6% = 1.2) euros.
 */
public class ScienceFictionBook extends Book{
    private double discount;

    /**
     * Constructor
     * If we want to buy science fictions, we need to create its object with discount
     * @param priceInit, must be larger than 0
     * @param name
     * @param discount, must between 0-1
     */
    public ScienceFictionBook(double priceInit, String name, double discount) {
        if(priceInit <= 0){
            throw new PriceInitLessThanZeroException();
        }
        this.priceInit = priceInit;
        this.name = name;
        this.discount = discount;
    }

    //Override the method in parent class
    @Override
    public double getPriceFinal(){
        return ((this.priceInit * this.discount) + (this.priceInit * Book.TAX_BOOK)); //discount is only for price init
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
