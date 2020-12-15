package sample.tables;

public class Supplier {

    private int id;
    private String name, funpay_name, discord_name, payment_method, payment_adress, game;
    private double price;

    public Supplier(int id, String name, String funpay_name, String discord_name, double price,
                    String payment_method, String payment_adress, String game) {
        this.id = id;
        this.name = name;
        this.funpay_name = funpay_name;
        this.discord_name = discord_name;
        this.price = price;
        this.payment_method = payment_method;
        this.payment_adress = payment_adress;
        this.game = game;
    }

    public Supplier(int id, String name, String funpay_name, String discord_name) {
        this.id = id;
        this.name = name;
        this.funpay_name = funpay_name;
        this.discord_name = discord_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunpay_name() {
        return funpay_name;
    }

    public void setFunpay_name(String funpay_name) {
        this.funpay_name = funpay_name;
    }

    public String getDiscord_name() {
        return discord_name;
    }

    public void setDiscord_name(String discord_name) {
        this.discord_name = discord_name;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_adress() {
        return payment_adress;
    }

    public void setPayment_adress(String payment_adress) {
        this.payment_adress = payment_adress;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
