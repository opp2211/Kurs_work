package sample.tables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Buy_operation {

    private int id, quantity;
    private double price, cost;
    private String date, game, supplier, payment_account;

    public Buy_operation(int id, String date, int quantity, double price,
                         double cost, String game, String supplier, String payment_account) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
        this.game = game;
        this.supplier = supplier;
        this.payment_account = payment_account;
    }

    public Buy_operation(int id, double price, String supplier) {
        this.id = id;
        this.price = price;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPayment_account() {
        return payment_account;
    }

    public void setPayment_account(String payment_account) {
        this.payment_account = payment_account;
    }

}
