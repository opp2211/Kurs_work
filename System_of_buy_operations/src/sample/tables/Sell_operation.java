package sample.tables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sell_operation {

    private int id, quantity;
    private double price, cost;
    private String date, payment_account, buyer, game;

    public Sell_operation(int id, String date, int quantity, double price,
                          double cost, String payment_account, String buyer, String game) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
        this.payment_account = payment_account;
        this.buyer = buyer;
        this.game = game;
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

    public String getPayment_account() {
        return payment_account;
    }

    public void setPayment_account(String payment_account) {
        this.payment_account = payment_account;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }
}
