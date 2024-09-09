package saleSystem.Products;

import saleSystem.Exceptions.PriceInitLessThanZeroException;

/**
 * furniture is a kind of goods who has its price, name and the tax you need to pay if you want to buy it.
 * A furniture can calculate its own FinalPrice and TaxPrice.
 * You can also get its price, name and tax by furniture.
 */
public class Furniture implements Goods {
    private double priceInit;
    private String name;
    static final double TAX_FURNITURE = 0.2; //Furniture gets 20% tax

    /**
     * Default constructor
     */
    public Furniture(){

    }

    /**
     * Constructor with params
     * @param priceInit, must be larger than 0
     * @param name
     */
    public Furniture(double priceInit,String name) {
        if (priceInit <= 0){
            throw new PriceInitLessThanZeroException();
        }
        this.priceInit = priceInit;
        this.name = name;
    }

    /**
     * The method allows us to get the price before tax
     * priceInit is private in the class,
     * we need use setter to set the attribute
     */
    public double getPriceInit() {
        return this.priceInit;
    }

    /**
     * priceInit is private in the class,
     * we need use getter to get the attribute
     * @param priceInit
     */
    public void setPriceInit(double priceInit) {
        if(priceInit <= 0){
            throw new PriceInitLessThanZeroException();
        }
        this.priceInit = priceInit;
    }

    //Get furniture's tax if you want
    public static double getTaxFurniture(){
        return TAX_FURNITURE;
    }

    /**
     * A product have to know calculate its final unit price
     * @return finalPrice
     */
    public double getPriceFinal(){
        return this.priceInit * (1 + TAX_FURNITURE);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
