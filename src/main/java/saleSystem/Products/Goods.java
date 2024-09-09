package saleSystem.Products;

public interface Goods {
    /**
     * Goods is "vendable"
     * Goods is an interface that offers a method to calculate the final price of one product(A book or furniture)
     * Class Book and Furniture will implement it
     * When a new commodity implement the class Goods, means it is a "vendable"
     * @return double
     */
    double getPriceFinal();
}
