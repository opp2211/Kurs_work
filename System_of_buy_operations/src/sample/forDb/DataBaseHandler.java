package sample.forDb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import sample.tables.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseHandler extends Configs {

    Connection dbConnection;

    // подключение к базе данных
    public Connection getConnection() {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort
                + "/" + dbName + "?serverTimezone=" + dbTimezone;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Подключение");
            alert.setHeaderText("Результат:");
            alert.setContentText("Подключение установлено!");
            alert.showAndWait();
            return dbConnection;
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Подключение");
            alert.setHeaderText("Результат:");
            alert.setContentText("Подключение не установлено!");
            alert.showAndWait();
            return null;
        }
    }

    /* SELECT FROM */
    // select * from buy_operation
    public ObservableList<Buy_operation> getDataBuyOperation() {
        String sqlString = "SELECT * FROM buy_operation ORDER BY id ASC";
        ObservableList<Buy_operation> operations = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                operations.add(new Buy_operation(Integer.parseInt(resultSet.getString("id")), resultSet.getString(
                        "date"), Integer.parseInt(resultSet.getString("quantity")), Double.parseDouble(resultSet.getString("price")),
                        Double.parseDouble(resultSet.getString("cost")), resultSet.getString("game"),
                        resultSet.getString("supplier"), resultSet.getString("payment_account")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operations;
    }

    // select * from financial_op
    public ObservableList<Financial_op> getDataFinancialOp() {
        String sqlString = "SELECT * FROM financial_op ORDER BY id ASC";
        ObservableList<Financial_op> financialOps = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                financialOps.add(new Financial_op(Integer.parseInt(resultSet.getString("id")), resultSet.getString("date"),
                        Double.parseDouble(resultSet.getString("value")), resultSet.getString("comment"), resultSet.getString("payment_account_name"),
                        resultSet.getString("type")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return financialOps;
    }

    // select * from fin_op_type
    public ObservableList<Fin_op_type> getDataFinOpType() {
        String sqlString = "SELECT * FROM fin_op_type";
        ObservableList<Fin_op_type> finOpTypes = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                finOpTypes.add(new Fin_op_type(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finOpTypes;
    }

    // select * from exchange
    public ObservableList<Exchange> getExchangeData() {
        String sqlString = "SELECT * FROM exchange ORDER BY id ASC";
        ObservableList<Exchange> exchanges = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                exchanges.add(new Exchange(Integer.parseInt(resultSet.getString("id")), resultSet.getString("date"),
                        resultSet.getString("credit_account"), Double.parseDouble(resultSet.getString("credit_value")),
                        resultSet.getString("debit_account"), Double.parseDouble(resultSet.getString("debit_value"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchanges;
    }

    // select * from buyer
    public ObservableList<Buyer> getDataBuyer() {
        String sqlString = "SELECT * FROM buyer";
        ObservableList<Buyer> buyers = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                buyers.add(new Buyer(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyers;
    }

    // select * from game
    public ObservableList<Game> getDataGame() {
        String sqlString = "SELECT * FROM game";
        ObservableList<Game> games = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                games.add(new Game(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    // select * from sell_operation
    public ObservableList<Sell_operation> getDataSellOp() {
        String sqlString = "SELECT * FROM sell_operation ORDER BY id ASC";
        ObservableList<Sell_operation> sellOperations = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                sellOperations.add(new Sell_operation(Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("date"), Integer.parseInt(resultSet.getString("quantity")),
                        Double.parseDouble(resultSet.getString("price")), Double.parseDouble(resultSet.getString("cost")),
                        resultSet.getString("payment_account"), resultSet.getString("buyer"), resultSet.getString("game")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sellOperations;
    }

    // select * from gamecur_op
    public ObservableList<Gamecur_op> getGamecurOp() {
        String sqlString = "SELECT * FROM gamecur_op ORDER BY id ASC";
        ObservableList<Gamecur_op> gamecurOps = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                gamecurOps.add(new Gamecur_op(Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("date"), Integer.parseInt(resultSet.getString("quantity")),
                        resultSet.getString("comment"), resultSet.getString("game")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gamecurOps;
    }

    // select * from supplier
    public ObservableList<Supplier> getDataSupplier() {
        String sqlString = "SELECT * FROM supplier ORDER BY id";
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                suppliers.add(new Supplier(Integer.parseInt(resultSet.getString("id")),
                        resultSet.getString("name"), resultSet.getString("funpay_name"),
                        resultSet.getString("discord_name"), Double.parseDouble(resultSet.getString("price")),
                        resultSet.getString("payment_method"), resultSet.getString("payment_adress"),
                        resultSet.getString("game")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    // select * from payment_account
    public ObservableList<Payment_account> getDataPaymentAcc() {
        String sqlString = "SELECT * FROM payment_account";
        ObservableList<Payment_account> paymentAccounts = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                paymentAccounts.add(new Payment_account(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentAccounts;
    }

    /* INSERT INTO */
    // insert into buy_operation 
    public void addBuyOperation(String date, int quantity, double price, double cost, String game, String supplier, String payment_account) {
        String sqlString = "INSERT INTO buy_operation (date, quantity, price, cost, game, supplier, payment_account) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setDouble(4, cost);
            preparedStatement.setString(5, game);
            preparedStatement.setString(6, supplier);
            preparedStatement.setString(7, payment_account);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция покупки добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into buyer
    public void addBuyer(String name) {
        String sqlString = "INSERT INTO buyer (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Покупатель добавлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into exchange
    public void addExchange(String date, String credit_account, double credit_value, String debit_account, double debit_value) {
        String sqlString = "INSERT INTO exchange (date, credit_account, credit_value, debit_account, debit_value) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, credit_account);
            preparedStatement.setDouble(3, credit_value);
            preparedStatement.setString(4, debit_account);
            preparedStatement.setDouble(5, debit_value);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Обмен добавлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into fin_op_type
    public void addFinOpType(String name) {
        String sqlString = "INSERT INTO fin_op_type (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Тип операции добавлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into financial_op
    public void addFinancialOp(String date, double value, String comment, String payment_account_name, String type) {
        String sqlString = "INSERT INTO financial_op (date, value, comment, payment_account_name, type) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2, value);
            preparedStatement.setString(3, comment);
            preparedStatement.setString(4, payment_account_name);
            preparedStatement.setString(5, type);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Финансовая операция добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into game
    public void addGame(String name) {
        String sqlString = "INSERT INTO game (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Игра добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into gamecur_op
    public void addGamecurOp(String date, int quantity, String comment, String game) {
        String sqlString = "INSERT INTO gamecur_op (date, quantity, comment, game) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setString(3, comment);
            preparedStatement.setString(4, game);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция c игровой валютой добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into payment_account
    public void addPaymentAcc(String name) {
        String sqlString = "INSERT INTO payment_account (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Платёжная система добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into sell_operation
    public void addSellOp(String date, int quantity, double price, double cost, String payment_account, String buyer, String game) {
        String sqlString = "INSERT INTO sell_operation (date, quantity, price, cost, payment_account, buyer, game) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setDouble(4, cost);
            preparedStatement.setString(5, payment_account);
            preparedStatement.setString(6, buyer);
            preparedStatement.setString(7, game);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Продажа добавлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // insert into supplier
    public void addSupplier(String name, String funpay_name, String discord_name, double price, String payment_method, String payment_adress, String game)
    {
        String sqlString = "INSERT INTO sell_operation (name, funpay_name, discord_name, price, payment_method, payment_adress, game) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, funpay_name);
            preparedStatement.setString(3, discord_name);
            preparedStatement.setDouble(4, price);
            preparedStatement.setString(5, payment_method);
            preparedStatement.setString(6, payment_adress);
            preparedStatement.setString(7, game);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Поставщик добавлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* UPDATE */
    // update buy_operation 
    public void updateBuyOperation(int id, String date, int quantity, double price, double cost, String game, String supplier, String payment_account) {
        String sqlString = "UPDATE buy_operation SET date = ?, quantity = ?, price = ?, cost = ?, game = ?, supplier = ?, payment_account = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setDouble(4, cost);
            preparedStatement.setString(5, game);
            preparedStatement.setString(6, supplier);
            preparedStatement.setString(7, payment_account);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция покупки обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update buyer
    public void updateBuyer(int id, String name) {
        String sqlString = "UPDATE buyer SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Покупатель обновлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update exchange
    public void updateExchange(int id, String date, String credit_account, double credit_value, String debit_account, double debit_value) {
        String sqlString = "UPDATE exchange SET date = ?, credit_account = ?, credit_value = ?, debit_account = ?, debit_value = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, credit_account);
            preparedStatement.setDouble(3, credit_value);
            preparedStatement.setString(4, debit_account);
            preparedStatement.setDouble(5, debit_value);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Обмен обновлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update fin_op_type
    public void updateFinOpType(int id, String name) {
        String sqlString = "UPDATE fin_op_type SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Тип операции обновлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update financial_op
    public void updateFinancialOp(int id, String date, double value, String comment, String payment_account_name, String type) {
        String sqlString = "UPDATE financial_op SET date = ?, value = ?, comment = ?, payment_account_name = ?, type = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2, value);
            preparedStatement.setString(3, comment);
            preparedStatement.setString(4, payment_account_name);
            preparedStatement.setString(5, type);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Финансовая операция обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update game
    public void updateGame(int id, String name) {
        String sqlString = "UPDATE game SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Игра обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update gamecur_op
    public void updateGamecurOp(int id, String date, int quantity, String comment, String game) {
        String sqlString = "UPDATE gamecur_op SET date = ?, quantity = ?, comment = ?, game = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setString(3, comment);
            preparedStatement.setString(4, game);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция c игровой валютой обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update payment_account
    public void updatePaymentAcc(int id, String name) {
        String sqlString = "UPDATE payment_account SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Платёжная система обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update sell_operation
    public void updateSellOp(int id, String date, int quantity, double price, double cost, String payment_account, String buyer, String game) {
        String sqlString = "UPDATE sell_operation SET date = ?, quantity = ?, price = ?, cost = ?, payment_account = ?, buyer = ?, game = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setDouble(3, price);
            preparedStatement.setDouble(4, cost);
            preparedStatement.setString(5, payment_account);
            preparedStatement.setString(6, buyer);
            preparedStatement.setString(7, game);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Продажа обновлена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update supplier
    public void updateSupplier(int id, String name, String funpay_name, String discord_name, double price, String payment_method, String payment_adress, String game)
    {
        String sqlString = "UPDATE sell_operation SET name = ?, funpay_name = ?, discord_name = ?, price = ?, payment_method = ?, payment_adress = ?, game = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, funpay_name);
            preparedStatement.setString(3, discord_name);
            preparedStatement.setDouble(4, price);
            preparedStatement.setString(5, payment_method);
            preparedStatement.setString(6, payment_adress);
            preparedStatement.setString(7, game);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Поставщик обновлен успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* DELETE */
    // delete buy_operation 
    public void deleteBuyOperation(int id) {
        String sqlString = "DELETE FROM buy_operation WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция покупки удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete buyer
    public void deleteBuyer(String name) {
        String sqlString = "DELETE FROM buyer WHERE name = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Покупатель удален успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete exchange
    public void deleteExchange(int id) {
        String sqlString = "DELETE FROM exchange WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Обмен удален успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete fin_op_type
    public void deleteFinOpType(String name) {
        String sqlString = "DELETE FROM fin_op_type WHERE name = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Тип операции удален успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete financial_op
    public void deleteFinancialOp(int id) {
        String sqlString = "DELETE FROM financial_op WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Финансовая операция удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete game
    public void deleteGame(String name) {
        String sqlString = "DELETE FROM game WHERE name = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Игра удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete gamecur_op
    public void deleteGamecurOp(int id) {
        String sqlString = "DELETE FROM gamecur_op WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Операция c игровой валютой удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete payment_account
    public void deletePaymentAcc(String name) {
        String sqlString = "DELETE FROM payment_account WHERE name = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Платёжная система удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete sell_operation
    public void deleteSellOp(int id) {
        String sqlString = "DELETE FROM sell_operation WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Продажа удалена успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete supplier
    public void deleteSupplier(int id) {
        String sqlString = "DELETE FROM supplier WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Поставщик удален успешно!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Выборки */
    public ObservableList<Buy_operation> getBuyOpsSupp(double min, double max) {
        ObservableList<Buy_operation> buyOperations = FXCollections.observableArrayList();
        String sqlString = "SELECT id, price, supplier FROM buy_operation WHERE supplier in (SELECT name FROM supplier WHERE price BETWEEN ? AND ?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buyOperations.add(new Buy_operation(Integer.parseInt(resultSet.getString("id")),
                        Double.parseDouble(resultSet.getString("price")), resultSet.getString("supplier")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyOperations;
    }

    public ObservableList<Exchange> getExchangeType(String type) {
        ObservableList<Exchange> exchanges = FXCollections.observableArrayList();
        String sqlString = "SELECT id, credit_account FROM exchange WHERE credit_account IN (SELECT name FROM payment_account WHERE " +
                "name IN (SELECT payment_account_name FROM financial_op WHERE type = ?))";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                exchanges.add(new Exchange(Integer.parseInt(resultSet.getString("id")), resultSet.getString("credit_account")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exchanges;
    }

    public ObservableList<Buyer> getBuyerDate(String date) {
        ObservableList<Buyer> buyers = FXCollections.observableArrayList();
        String sqlString = "SELECT * FROM buyer WHERE name IN (SELECT buyer FROM sell_operation WHERE date = ?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                buyers.add(new Buyer(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyers;
    }

    public ObservableList<Supplier> getSupplierQuantity(int quantity) {
        ObservableList<Supplier> suppliers = FXCollections.observableArrayList();
        String sqlString = "SELECT id, name, funpay_name, discord_name FROM supplier WHERE name IN (SELECT supplier FROM buy_operation" +
                " WHERE quantity > ?)";
        try {
            PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlString);
            preparedStatement.setInt(1, quantity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                suppliers.add(new Supplier(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        resultSet.getString("funpay_name"), resultSet.getString("discord_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}
