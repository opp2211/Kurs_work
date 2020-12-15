package sample.tables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Financial_op {

    private int id;
    private String date, comment, type, payment_account_name;
    private double value;

    public Financial_op(int id, String date, double value, String comment, String payment_account_name,  String type) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.comment = comment;
        this.payment_account_name = payment_account_name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayment_account_name() {
        return payment_account_name;
    }

    public void setPayment_account_name(String payment_account_name) {
        this.payment_account_name = payment_account_name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
