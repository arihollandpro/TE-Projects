package com.techelevator;

import java.math.BigDecimal;

public class Items {

    private BigDecimal price;
    private String name = "";
    private String slotNumber = "";
    private String message = "";
//    private double balance;
    private int quantity;
    private String type;

    public Items (String slotNumber, String name, BigDecimal price, String type, int quantity) {
        this.name = name;
        this.slotNumber = slotNumber;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public String getSlotNumber() { return slotNumber;}
    public String getType(){return type;}
    public BigDecimal getPrice(){return price;}





    // Methods

    public String getMessage() {

        return message;
    }
    public BigDecimal purchase(BigDecimal balance) {
        if (balance.compareTo(price) == -1){
            return balance;
        }
         balance = balance.subtract(price);
         quantity -= 1;

        return balance;
    }

    public boolean isSoldOut () {
        if(quantity < 1) {
            return true;
        }
        else {
            return false;
        }
    }



}
