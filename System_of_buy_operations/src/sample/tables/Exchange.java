package sample.tables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exchange {

    private int id;
    private double credit_value, debit_value;
    private String date, credit_account, debit_account;

    public Exchange(int id, String date, String credit_account, double credit_value, String debit_account,
                    double debit_value) {
        this.id = id;
        this.date = date;
        this.credit_account = credit_account;
        this.credit_value = credit_value;
        this.debit_account = debit_account;
        this.debit_value = debit_value;
    }

    public Exchange(int id, String credit_account) {
        this.id = id;
        this.credit_account = credit_account;
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

    public double getCredit_value() {
        return credit_value;
    }

    public void setCredit_value(double credit_value) {
        this.credit_value = credit_value;
    }

    public double getDebit_value() {
        return debit_value;
    }

    public void setDebit_value(double debit_value) {
        this.debit_value = debit_value;
    }

    public String getCredit_account() {
        return credit_account;
    }

    public void setCredit_account(String credit_account) {
        this.credit_account = credit_account;
    }

    public String getDebit_account() {
        return debit_account;
    }

    public void setDebit_account(String debit_account) {
        this.debit_account = debit_account;
    }
}
