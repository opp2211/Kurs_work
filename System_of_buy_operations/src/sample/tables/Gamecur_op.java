package sample.tables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gamecur_op {

    private int id, quantity;
    private String date, comment, game;

    public Gamecur_op(int id, String date, int quantity, String comment, String game) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
