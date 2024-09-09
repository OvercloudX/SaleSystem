package saleSystem.Products;

import saleSystem.Exceptions.PriceInitLessThanZeroException;

/**
 * Book is a kind of goods who has its price, name and the tax you need to pay if you want to buy it.
 * A book can calculate its own FinalPrice and TaxPrice.
 * You can also get its price, name and tax by book.
 */
public class Book implements Goods {
    protected double priceInit;
    static final double TAX_BOOK = 0.06; //A book gets 20% tax
    protected String name;

    /**
     * Default constructor
     */
    public Book (){

    }

    /**
     * Constructor with parameters
     * @param priceInit, must be larger than 0
     * @param name
     */
    public Book(double priceInit, String name) {
        if(priceInit <= 0){
            throw new PriceInitLessThanZeroException();
        }
        this.priceInit = priceInit;
        this.name = name;
    }

    /**
     * The method allows us to get the price before tax
     * priceInit is private in the class,
     * we need use getter to get the attribute
     */
    public double getPriceInit(){
        return this.priceInit;
    }

    /**
     * priceInit is private in the class,
     * we need use setter to set the attribute
     * @param priceInit
     */
    public void setPriceInit(double priceInit) {
        if(priceInit <= 0){
            throw new PriceInitLessThanZeroException();
        }
        this.priceInit = priceInit;
    }

    /**
     * This method aims to return book's tax ratio
     * We can also get the tax by the name of class
     * because TAX_BOOK is static
     * @return TAX_BOOK
     */
    public static double getTaxBook() {
        return TAX_BOOK;
    }

    /**
     * A product have to know calculate its final unit price
     * @return finalPrice
     */
    public double getPriceFinal(){
        return this.priceInit * (1 + TAX_BOOK);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
