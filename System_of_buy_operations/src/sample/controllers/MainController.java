package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.forDb.DataBaseHandler;
import sample.tables.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane tabPane_system;

    /* Buy operation */
    @FXML
    private Tab buyop_tab;

    @FXML
    private TableView<Buy_operation> table_buyop;

    @FXML
    private TableColumn<Buy_operation, Integer> col_buyop_id;

    @FXML
    private TableColumn<Buy_operation, String> col_buyop_date;

    @FXML
    private TableColumn<Buy_operation, Integer> col_buyop_quantity;

    @FXML
    private TableColumn<Buy_operation, Double> col_buyop_price;

    @FXML
    private TableColumn<Buy_operation, Double> col_buyop_cost;

    @FXML
    private TableColumn<Buy_operation, String> col_buyop_game;

    @FXML
    private TableColumn<Buy_operation, String> col_buyop_supplier;

    @FXML
    private TableColumn<Buy_operation, String> col_buyop_payacc;

    @FXML
    private Button load_buyop;

    @FXML
    private Button delete_buyop_data;

    @FXML
    private Button update_buyop_data;

    @FXML
    private Button add_buyop_data;

    @FXML
    private TextField txt_buyop_id;

    @FXML
    private TextField txt_buyop_date;

    @FXML
    private TextField txt_buyop_quantity;

    @FXML
    private TextField txt_buyop_cost;

    @FXML
    private TextField txt_buyop_game;

    @FXML
    private TextField txt_buyop_supplier;

    @FXML
    private TextField txt_buyop_payacc;

    @FXML
    private TextField txt_buyop_price;

    @FXML
    private Button clear_txt_buyop;

    ObservableList<Buy_operation> buyOperations = FXCollections.observableArrayList();

    /* Financial_op */
    @FXML
    private Tab financialop_tab;

    @FXML
    private TableView<Financial_op> table_financialop;

    @FXML
    private TableColumn<Financial_op, Integer> col_financialop_id;

    @FXML
    private TableColumn<Financial_op, String> col_financialop_date;

    @FXML
    private TableColumn<Financial_op, Double> col_financialop_val;

    @FXML
    private TableColumn<Financial_op, String> col_financialop_comment;

    @FXML
    private TableColumn<Financial_op, String> col_financialop_payaccname;

    @FXML
    private TableColumn<Financial_op, String> col_financialop_type;

    @FXML
    private Button load_financialop;

    @FXML
    private Button delete_financialop_data;

    @FXML
    private Button update_financialop_data;

    @FXML
    private Button add_financialop_data;

    @FXML
    private TextField txt_financialop_id;

    @FXML
    private TextField txt_financialop_date;

    @FXML
    private TextField txt_financialop_value;

    @FXML
    private TextField txt_financialop_payaccname;

    @FXML
    private TextField txt_financialop_type;

    @FXML
    private TextField txt_financialop_comment;

    @FXML
    private Button clear_txt_financialop;

    ObservableList<Financial_op> financialOps = FXCollections.observableArrayList();

    /* Fin_op_type */
    @FXML
    private Tab finoptype_tab;

    @FXML
    private TableView<Fin_op_type> table_finoptype;

    @FXML
    private TableColumn<Fin_op_type, Integer> col_finoptype_id;

    @FXML
    private TableColumn<Fin_op_type, String> col_finoptype_name;

    @FXML
    private Button load_finoptype_data;

    @FXML
    private Button delete_finoptype_data;

    @FXML
    private Button update_finoptype_data;

    @FXML
    private Button add_finoptype_data;

    @FXML
    private TextField txt_finoptype_id;

    @FXML
    private TextField txt_finoptype_name;

    @FXML
    private Button clear_txt_finoptype;

    @FXML
    private Tab exchange_tab;

    ObservableList<Fin_op_type> finOpTypes = FXCollections.observableArrayList();

    /* Exchange */
    @FXML
    private TableView<Exchange> table_exchange;

    @FXML
    private TableColumn<Exchange, Integer> col_exchange_id;

    @FXML
    private TableColumn<Exchange, String> col_exchange_date;

    @FXML
    private TableColumn<Exchange, String> col_exchange_creditacc;

    @FXML
    private TableColumn<Exchange, Double> col_exchange_creditval;

    @FXML
    private TableColumn<Exchange, String> col_exchange_debitacc;

    @FXML
    private TableColumn<Exchange, Double> col_exchange_debitval;

    @FXML
    private Button load_exchange;

    @FXML
    private Button delete_exchange_data;

    @FXML
    private Button update_exchange_data;

    @FXML
    private Button add_exchange_data;

    @FXML
    private TextField txt_exchange_id;

    @FXML
    private TextField txt_exchange_date;

    @FXML
    private TextField txt_exchange_creditacc;

    @FXML
    private TextField txt_exchange_debitacc;

    @FXML
    private TextField txt_exchange_debitval;

    @FXML
    private TextField txt_exchange_creditval;

    @FXML
    private Button clear_txt_exchange;

    ObservableList<Exchange> exchanges = FXCollections.observableArrayList();

    /* Buyer */
    @FXML
    private Tab buyer_tab;

    @FXML
    private TableView<Buyer> table_buyer;

    @FXML
    private TableColumn<Buyer, Integer> col_buyer_id;

    @FXML
    private TableColumn<Buyer, String> col_buyer_name;

    @FXML
    private Button load_buyer_data;

    @FXML
    private Button delete_buyer_data;

    @FXML
    private Button update_buyer_data;

    @FXML
    private Button add_buyer_data;

    @FXML
    private TextField txt_buyer_id;

    @FXML
    private TextField txt_buyer_name;

    @FXML
    private Button clear_txt_buyer;

    ObservableList<Buyer> buyers = FXCollections.observableArrayList();

    /* Game */
    @FXML
    private Tab game_tab;

    @FXML
    private TableView<Game> table_game;

    @FXML
    private TableColumn<Game, Integer> col_game_id;

    @FXML
    private TableColumn<Game, String> col_game_name;

    @FXML
    private Button load_game;

    @FXML
    private Button delete_game_data;

    @FXML
    private Button update_game_data;

    @FXML
    private Button add_game_data;

    @FXML
    private TextField txt_game_id;

    @FXML
    private TextField txt_game_name;

    @FXML
    private Button clear_txt_game;

    ObservableList<Game> games = FXCollections.observableArrayList();

    /* Sell_operation */
    @FXML
    private Tab sellop_tab;

    @FXML
    private TableView<Sell_operation> table_sellop;

    @FXML
    private TableColumn<Sell_operation, Integer> col_sellop_id;

    @FXML
    private TableColumn<Sell_operation, String> col_sellop_date;

    @FXML
    private TableColumn<Sell_operation, Integer> col_sellop_quantity;

    @FXML
    private TableColumn<Sell_operation, Double> col_sellop_price;

    @FXML
    private TableColumn<Sell_operation, Double> col_sellop_cost;

    @FXML
    private TableColumn<Sell_operation, String> col_sellop_payacc;

    @FXML
    private TableColumn<Sell_operation, String> col_sellop_buyer;

    @FXML
    private TableColumn<Sell_operation, String> col_sellop_game;

    @FXML
    private Button load_sellop;

    @FXML
    private Button delete_sellop_data;

    @FXML
    private Button update_sellop_data;

    @FXML
    private Button add_sellop_data;

    @FXML
    private TextField txt_sellop_id;

    @FXML
    private TextField txt_sellop_date;

    @FXML
    private TextField txt_sellop_quantity;

    @FXML
    private TextField txt_sellop_cost;

    @FXML
    private TextField txt_sellop_payacc;

    @FXML
    private TextField txt_sellop_buyer;

    @FXML
    private TextField txt_sellop_game;

    @FXML
    private TextField txt_sellop_price;

    @FXML
    private Button clear_txt_sellop;

    ObservableList<Sell_operation> sellOperations = FXCollections.observableArrayList();

    /* Gamecur_op */
    @FXML
    private Tab gamecurop_tab;

    @FXML
    private TableView<Gamecur_op> table_gamecurop;

    @FXML
    private TableColumn<Gamecur_op, Integer> col_gamecurop_id;

    @FXML
    private TableColumn<Gamecur_op, String> col_gamecurop_date;

    @FXML
    private TableColumn<Gamecur_op, Integer> col_gamecurop_quantity;

    @FXML
    private TableColumn<Gamecur_op, String> col_gamecurop_comment;

    @FXML
    private TableColumn<Gamecur_op, String> col_gamecurop_game;

    @FXML
    private Button load_gamecurop;

    @FXML
    private Button delete_gamecurop_data;

    @FXML
    private Button update_gamecurop_data;

    @FXML
    private Button add_gamecurop_data;

    @FXML
    private TextField txt_gamecurop_id;

    @FXML
    private TextField txt_gamecurop_date;

    @FXML
    private TextField txt_gamecurop_quantity;

    @FXML
    private TextField txt_gamecurop_game;

    @FXML
    private TextField txt_gamecurop_comment;

    @FXML
    private Button clear_txt_gamecurop;

    ObservableList<Gamecur_op> gamecurOps = FXCollections.observableArrayList();

    /* Supplier */
    @FXML
    private Tab supplier_tab;

    @FXML
    private TableView<Supplier> table_supplier;

    @FXML
    private TableColumn<Supplier, Integer> col_supplier_id;

    @FXML
    private TableColumn<Supplier, String> col_supplier_name;

    @FXML
    private TableColumn<Supplier, String> col_supplier_funname;

    @FXML
    private TableColumn<Supplier, String> col_supplier_discord;

    @FXML
    private TableColumn<Supplier, Double> col_supplier_price;

    @FXML
    private TableColumn<Supplier, String> col_supplier_paymeth;

    @FXML
    private TableColumn<Supplier, String> col_supplier_payaddr;

    @FXML
    private TableColumn<Supplier, String> col_supplier_game;

    @FXML
    private Button load_supplier;

    @FXML
    private Button delete_supplier_data;

    @FXML
    private Button update_supplier_data;

    @FXML
    private Button add_supplier_data;

    @FXML
    private TextField txt_supplier_id;

    @FXML
    private TextField txt_supplier_name;

    @FXML
    private TextField txt_supplier_funname;

    @FXML
    private TextField txt_supplier_price;

    @FXML
    private TextField txt_supplier_paymeth;

    @FXML
    private TextField txt_supplier_discord;

    @FXML
    private Button clear_txt_supplier;

    @FXML
    private TextField txt_supplier_payaddr;

    @FXML
    private TextField txt_supplier_game;

    ObservableList<Supplier> suppliers = FXCollections.observableArrayList();

    /* Payment_account */
    @FXML
    private Tab payment_tab;

    @FXML
    private TableView<Payment_account> table_payment;

    @FXML
    private TableColumn<Payment_account, Integer> col_payment_id;

    @FXML
    private TableColumn<Payment_account, String> col_payment_name;

    @FXML
    private Button load_payment;

    @FXML
    private Button delete_payment_data;

    @FXML
    private Button update_payment_data;

    @FXML
    private Button add_payment_data;

    @FXML
    private TextField txt_payment_id;

    @FXML
    private TextField txt_payment_name;

    @FXML
    private Button clear_txt_payment;

    ObservableList<Payment_account> paymentAccounts = FXCollections.observableArrayList();

    /* Вкладка выборок */
    @FXML
    private Tab querys_tab;

    // Первый запрос
    @FXML
    private TableView<Buy_operation> table_getBuyOpsSupp;

    @FXML
    private TableColumn<Buy_operation, Integer> col_getBuyOpsSupp_id;

    @FXML
    private TableColumn<Buy_operation, Double> col_getBuyOpsSupp_price;

    @FXML
    private TableColumn<Buy_operation, String> col_getBuyOpsSupp_supplier;

    @FXML
    private TextField txt_getBuyOpsSupp_min;

    @FXML
    private TextField txt_getBuyOpsSupp_max;

    @FXML
    private Button execute_getBuyOpsSupp;

    ObservableList<Buy_operation> getBuyOpsSupp_request = FXCollections.observableArrayList();

    // Второй запрос
    @FXML
    private TableView<Exchange> table_getExchangeType;

    @FXML
    private TableColumn<Exchange, Integer> col_getExchangeType_id;

    @FXML
    private TableColumn<Exchange, String> col_getExchangeType_creditacc;

    @FXML
    private ComboBox combobox_getExchangeType_types;

    @FXML
    private Button execute_getExchangeType;

    ObservableList<Exchange> getExchangeType_request = FXCollections.observableArrayList();

    ObservableList<String> getExchangeType_types = FXCollections.observableArrayList("Others", "Salary Ivanov");

    // Третий запрос
    @FXML
    private TableView<Buyer> table_getBuyerDate;

    @FXML
    private TableColumn<Buyer, Integer> col_getBuyerDate_id;

    @FXML
    private TableColumn<Buyer, String> col_getBuyerDate_name;

    @FXML
    private ComboBox combobox_getBuyerDate_dates;

    @FXML
    private Button execute_getBuyerDate;

    ObservableList<Buyer> getBuyerDate_request = FXCollections.observableArrayList();

    ObservableList<String> getBuyerDate_dates = FXCollections.observableArrayList("2020-11-07", "2020-12-07");

    // Четвертый запрос
    @FXML
    private TableView<Supplier> table_getSupplierQuantity;

    @FXML
    private TableColumn<Supplier, Integer> col_getSupplierQuantity_id;

    @FXML
    private TableColumn<Supplier, String> col_getSupplierQuantity_name;

    @FXML
    private TableColumn<Supplier, String> col_getSupplierQuantity_funpayname;

    @FXML
    private TableColumn<Supplier, String> col_getSupplierQuantity_discordname;

    @FXML
    private TextField txt_getSupplierQuantity_quantity;

    @FXML
    private Button execute_getSupplierQuantity;

    ObservableList<Supplier> getSupplierQuantity_request = FXCollections.observableArrayList();

    int index = -1;

    /* Вывод в текстбоксы информации из каждой таблицы по клику мыши на нужную строку */
    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {

        if (tabPane_system.getSelectionModel().isSelected(0)) {
            index = table_buyop.getSelectionModel().getFocusedIndex();
            txt_buyop_id.setText(col_buyop_id.getCellData(index).toString());
            txt_buyop_date.setText(col_buyop_date.getCellData(index).toString());
            txt_buyop_quantity.setText(col_buyop_quantity.getCellData(index).toString());
            txt_buyop_price.setText(col_buyop_price.getCellData(index).toString());
            txt_buyop_cost.setText(col_buyop_cost.getCellData(index).toString());
            txt_buyop_game.setText(col_buyop_game.getCellData(index).toString());
            txt_buyop_supplier.setText(col_buyop_supplier.getCellData(index).toString());
            txt_buyop_payacc.setText(col_buyop_payacc.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(1)) {
            index = table_financialop.getSelectionModel().getFocusedIndex();
            txt_financialop_id.setText(col_financialop_id.getCellData(index).toString());
            txt_financialop_date.setText(col_financialop_date.getCellData(index).toString());
            txt_financialop_value.setText(col_financialop_val.getCellData(index).toString());
            txt_financialop_comment.setText(col_financialop_comment.getCellData(index).toString());
            txt_financialop_payaccname.setText(col_financialop_payaccname.getCellData(index).toString());
            txt_financialop_type.setText(col_financialop_type.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(2)) {
            index = table_finoptype.getSelectionModel().getFocusedIndex();
            txt_finoptype_id.setText(col_finoptype_id.getCellData(index).toString());
            txt_finoptype_name.setText(col_finoptype_name.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(3)) {
            index = table_exchange.getSelectionModel().getFocusedIndex();
            txt_exchange_id.setText(col_exchange_id.getCellData(index).toString());
            txt_exchange_date.setText(col_exchange_date.getCellData(index).toString());
            txt_exchange_creditacc.setText(col_exchange_creditacc.getCellData(index).toString());
            txt_exchange_creditval.setText(col_exchange_creditval.getCellData(index).toString());
            txt_exchange_debitacc.setText(col_exchange_debitacc.getCellData(index).toString());
            txt_exchange_debitval.setText(col_exchange_debitval.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(4)) {
            index = table_buyer.getSelectionModel().getFocusedIndex();
            txt_buyer_id.setText(col_buyer_id.getCellData(index).toString());
            txt_buyer_name.setText(col_buyer_name.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(5)) {
            index = table_game.getSelectionModel().getFocusedIndex();
            txt_game_id.setText(col_game_id.getCellData(index).toString());
            txt_game_name.setText(col_game_name.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(6)) {
            index = table_sellop.getSelectionModel().getFocusedIndex();
            txt_sellop_id.setText(col_sellop_id.getCellData(index).toString());
            txt_sellop_date.setText(col_sellop_date.getCellData(index).toString());
            txt_sellop_quantity.setText(col_sellop_quantity.getCellData(index).toString());
            txt_sellop_price.setText(col_sellop_price.getCellData(index).toString());
            txt_sellop_cost.setText(col_sellop_cost.getCellData(index).toString());
            txt_sellop_payacc.setText(col_sellop_payacc.getCellData(index).toString());
            txt_sellop_buyer.setText(col_sellop_buyer.getCellData(index).toString());
            txt_sellop_game.setText(col_sellop_game.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(7)) {
            index = table_gamecurop.getSelectionModel().getFocusedIndex();
            txt_gamecurop_id.setText(col_gamecurop_id.getCellData(index).toString());
            txt_gamecurop_date.setText(col_gamecurop_date.getCellData(index).toString());
            txt_gamecurop_quantity.setText(col_gamecurop_quantity.getCellData(index).toString());
            txt_gamecurop_comment.setText(col_gamecurop_comment.getCellData(index).toString());
            txt_gamecurop_game.setText(col_gamecurop_game.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(8)) {
            index = table_supplier.getSelectionModel().getFocusedIndex();
            txt_supplier_id.setText(col_supplier_id.getCellData(index).toString());
            txt_supplier_name.setText(col_supplier_name.getCellData(index).toString());
            txt_supplier_funname.setText(col_supplier_funname.getCellData(index).toString());
            txt_supplier_discord.setText(col_supplier_discord.getCellData(index).toString());
            txt_supplier_price.setText(col_supplier_price.getCellData(index).toString());
            txt_supplier_paymeth.setText(col_supplier_paymeth.getCellData(index).toString());
            txt_supplier_payaddr.setText(col_supplier_payaddr.getCellData(index).toString());
            txt_supplier_game.setText(col_supplier_game.getCellData(index).toString());
        }

        if (tabPane_system.getSelectionModel().isSelected(9)) {
            index = table_payment.getSelectionModel().getFocusedIndex();
            txt_payment_id.setText(col_payment_id.getCellData(index).toString());
            txt_payment_name.setText(col_payment_name.getCellData(index).toString());
        }
    
    }

    @FXML
    void initialize() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        dataBaseHandler.getConnection();
        txt_buyop_id.setEditable(false);
        txt_buyer_id.setEditable(false);
        txt_exchange_id.setEditable(false);
        txt_finoptype_id.setEditable(false);
        txt_financialop_id.setEditable(false);
        txt_game_id.setEditable(false);
        txt_gamecurop_id.setEditable(false);
        txt_payment_id.setEditable(false);
        txt_sellop_id.setEditable(false);
        txt_supplier_id.setEditable(false);
        combobox_getBuyerDate_dates.setItems(getBuyerDate_dates);
        combobox_getExchangeType_types.setItems(getExchangeType_types);

        /* Загрузка данных */
        // Buy_operation
        load_buyop.setOnAction( event -> {
            col_buyop_id.setCellValueFactory(new PropertyValueFactory<Buy_operation, Integer>("id"));
            col_buyop_date.setCellValueFactory(new PropertyValueFactory<Buy_operation, String>("date"));
            col_buyop_quantity.setCellValueFactory(new PropertyValueFactory<Buy_operation, Integer>("quantity"));
            col_buyop_price.setCellValueFactory(new PropertyValueFactory<Buy_operation, Double>("price"));
            col_buyop_cost.setCellValueFactory(new PropertyValueFactory<Buy_operation, Double>("cost"));
            col_buyop_game.setCellValueFactory(new PropertyValueFactory<Buy_operation, String>("game"));
            col_buyop_supplier.setCellValueFactory(new PropertyValueFactory<Buy_operation, String>("supplier"));
            col_buyop_payacc.setCellValueFactory(new PropertyValueFactory<Buy_operation, String>("payment_account"));
            buyOperations = dataBaseHandler.getDataBuyOperation();
            table_buyop.setItems(buyOperations);
            load_buyop.setText("Перезагрузить страницу");
        });

        // Financial_op
        load_financialop.setOnAction( event -> {
            col_financialop_id.setCellValueFactory(new PropertyValueFactory<Financial_op, Integer>("id"));
            col_financialop_date.setCellValueFactory(new PropertyValueFactory<Financial_op, String>("date"));
            col_financialop_val.setCellValueFactory(new PropertyValueFactory<Financial_op, Double>("value"));
            col_financialop_comment.setCellValueFactory(new PropertyValueFactory<Financial_op, String>("comment"));
            col_financialop_payaccname.setCellValueFactory(new PropertyValueFactory<Financial_op, String>("payment_account_name"));
            col_financialop_type.setCellValueFactory(new PropertyValueFactory<Financial_op, String>("type"));
            financialOps = dataBaseHandler.getDataFinancialOp();
            table_financialop.setItems(financialOps);
            load_financialop.setText("Перезагрузить страницу");
        });

        // Fin_op_type
        load_finoptype_data.setOnAction( event -> {
            col_finoptype_id.setCellValueFactory(new PropertyValueFactory<Fin_op_type, Integer>("id"));
            col_finoptype_name.setCellValueFactory(new PropertyValueFactory<Fin_op_type, String>("name"));
            finOpTypes = dataBaseHandler.getDataFinOpType();
            table_finoptype.setItems(finOpTypes);
            load_finoptype_data.setText("Перезагрузить страницу");
        });

        // Exchange
        load_exchange.setOnAction( event -> {
            col_exchange_id.setCellValueFactory(new PropertyValueFactory<Exchange, Integer>("id"));
            col_exchange_date.setCellValueFactory(new PropertyValueFactory<Exchange, String>("date"));
            col_exchange_creditacc.setCellValueFactory(new PropertyValueFactory<Exchange, String>("credit_account"));
            col_exchange_creditval.setCellValueFactory(new PropertyValueFactory<Exchange, Double>("credit_value"));
            col_exchange_debitacc.setCellValueFactory(new PropertyValueFactory<Exchange, String>("debit_account"));
            col_exchange_debitval.setCellValueFactory(new PropertyValueFactory<Exchange, Double>("debit_value"));
            exchanges = dataBaseHandler.getExchangeData();
            table_exchange.setItems(exchanges);
            load_exchange.setText("Перезагрузить страницу");
        });

        // Buyer
        load_buyer_data.setOnAction( event -> {
            col_buyer_id.setCellValueFactory(new PropertyValueFactory<Buyer, Integer>("id"));
            col_buyer_name.setCellValueFactory(new PropertyValueFactory<Buyer, String>("name"));
            buyers = dataBaseHandler.getDataBuyer();
            table_buyer.setItems(buyers);
            load_buyer_data.setText("Перезагрузить страницу");
        });

        // Game
        load_game.setOnAction( event -> {
            col_game_id.setCellValueFactory(new PropertyValueFactory<Game, Integer>("id"));
            col_game_name.setCellValueFactory(new PropertyValueFactory<Game, String>("name"));
            games = dataBaseHandler.getDataGame();
            table_game.setItems(games);
            load_financialop.setText("Перезагрузить страницу");
        });

        // Sell_operation
        load_sellop.setOnAction( event -> {
            col_sellop_id.setCellValueFactory(new PropertyValueFactory<Sell_operation, Integer>("id"));
            col_sellop_date.setCellValueFactory(new PropertyValueFactory<Sell_operation, String>("date"));
            col_sellop_quantity.setCellValueFactory(new PropertyValueFactory<Sell_operation, Integer>("quantity"));
            col_sellop_price.setCellValueFactory(new PropertyValueFactory<Sell_operation, Double>("price"));
            col_sellop_cost.setCellValueFactory(new PropertyValueFactory<Sell_operation, Double>("cost"));
            col_sellop_payacc.setCellValueFactory(new PropertyValueFactory<Sell_operation, String>("payment_account"));
            col_sellop_buyer.setCellValueFactory(new PropertyValueFactory<Sell_operation, String>("buyer"));
            col_sellop_game.setCellValueFactory(new PropertyValueFactory<Sell_operation, String>("game"));
            sellOperations = dataBaseHandler.getDataSellOp();
            table_sellop.setItems(sellOperations);
            load_financialop.setText("Перезагрузить страницу");
        });

        // Gamecur_op
        load_gamecurop.setOnAction( event -> {
            col_gamecurop_id.setCellValueFactory(new PropertyValueFactory<Gamecur_op, Integer>("id"));
            col_gamecurop_date.setCellValueFactory(new PropertyValueFactory<Gamecur_op, String>("date"));
            col_gamecurop_quantity.setCellValueFactory(new PropertyValueFactory<Gamecur_op, Integer>("quantity"));
            col_gamecurop_comment.setCellValueFactory(new PropertyValueFactory<Gamecur_op, String>("comment"));
            col_gamecurop_game.setCellValueFactory(new PropertyValueFactory<Gamecur_op, String>("game"));
            gamecurOps = dataBaseHandler.getGamecurOp();
            table_gamecurop.setItems(gamecurOps);
            load_gamecurop.setText("Перезагрузить страницу");
        });

        // Supplier
        load_supplier.setOnAction( event -> {
            col_supplier_id.setCellValueFactory(new PropertyValueFactory<Supplier, Integer>("id"));
            col_supplier_name.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
            col_supplier_funname.setCellValueFactory(new PropertyValueFactory<Supplier, String>("funpay_name"));
            col_supplier_discord.setCellValueFactory(new PropertyValueFactory<Supplier, String>("discord_name"));
            col_supplier_price.setCellValueFactory(new PropertyValueFactory<Supplier, Double>("price"));
            col_supplier_paymeth.setCellValueFactory(new PropertyValueFactory<Supplier, String>("payment_method"));
            col_supplier_payaddr.setCellValueFactory(new PropertyValueFactory<Supplier, String>("payment_adress"));
            col_supplier_game.setCellValueFactory(new PropertyValueFactory<Supplier, String>("game"));
            suppliers = dataBaseHandler.getDataSupplier();
            table_supplier.setItems(suppliers);
            load_supplier.setText("Перезагрузить страницу");
        });

        // Payment_account
        load_payment.setOnAction( event -> {
            col_payment_id.setCellValueFactory(new PropertyValueFactory<Payment_account, Integer>("id"));
            col_payment_name.setCellValueFactory(new PropertyValueFactory<Payment_account, String>("name"));
            paymentAccounts = dataBaseHandler.getDataPaymentAcc();
            table_payment.setItems(paymentAccounts);
            load_payment.setText("Перезагрузить страницу");
        });

        
        /* Очистка текстбоксов */
        // Buy_operation
        clear_txt_buyop.setOnAction( event -> {
            txt_buyop_id.setText("");
            txt_buyop_date.setText("");
            txt_buyop_quantity.setText("");
            txt_buyop_price.setText("");
            txt_buyop_cost.setText("");
            txt_buyop_game.setText("");
            txt_buyop_supplier.setText("");
            txt_buyop_payacc.setText("");
        });

        // Financial_op
        clear_txt_financialop.setOnAction( event -> {
            txt_financialop_id.setText("");
            txt_financialop_date.setText("");
            txt_financialop_value.setText("");
            txt_financialop_comment.setText("");
            txt_financialop_payaccname.setText("");
            txt_financialop_type.setText("");
        });

        // Fin_op_type
        clear_txt_finoptype.setOnAction( event -> {
            txt_finoptype_id.setText("");
            txt_finoptype_name.setText("");
        });

        // Exchange
        clear_txt_exchange.setOnAction( event -> {
            txt_exchange_id.setText("");
            txt_exchange_date.setText("");
            txt_exchange_creditacc.setText("");
            txt_exchange_creditval.setText("");
            txt_exchange_debitacc.setText("");
            txt_exchange_debitval.setText("");
        });

        // Buyer
        clear_txt_buyer.setOnAction( event -> {
            txt_buyer_id.setText("");
            txt_buyer_name.setText("");
        });

        // Game
        clear_txt_game.setOnAction( event -> {
            txt_game_id.setText("");
            txt_game_name.setText("");
        });

        // Sell_operation
        clear_txt_sellop.setOnAction( event -> {
            txt_sellop_id.setText("");
            txt_sellop_date.setText("");
            txt_sellop_quantity.setText("");
            txt_sellop_price.setText("");
            txt_sellop_cost.setText("");
            txt_sellop_payacc.setText("");
            txt_sellop_buyer.setText("");
            txt_sellop_game.setText("");
        });

        // Gamecur_op
        clear_txt_gamecurop.setOnAction( event -> {
            txt_gamecurop_id.setText("");
            txt_gamecurop_date.setText("");
            txt_gamecurop_quantity.setText("");
            txt_gamecurop_comment.setText("");
            txt_gamecurop_game.setText("");
        });

        // Supplier
        clear_txt_supplier.setOnAction( event -> {
            txt_supplier_id.setText("");
            txt_supplier_name.setText("");
            txt_supplier_funname.setText("");
            txt_supplier_discord.setText("");
            txt_supplier_price.setText("");
            txt_supplier_paymeth.setText("");
            txt_supplier_payaddr.setText("");
            txt_supplier_game.setText("");
        });

        // Payment_account
        clear_txt_payment.setOnAction( event -> {
            txt_payment_id.setText("");
            txt_payment_name.setText("");
        });

        /* Добавление новых данных */
        // Buy_operation
        add_buyop_data.setOnAction( event -> {
            dataBaseHandler.addBuyOperation(txt_buyop_date.getText(), Integer.parseInt(txt_buyop_quantity.getText()),
                    Double.parseDouble(txt_buyop_price.getText()), Double.parseDouble(txt_buyop_cost.getText()),
                    txt_buyop_game.getText(), txt_buyop_supplier.getText(), txt_buyop_payacc.getText());
            buyOperations = dataBaseHandler.getDataBuyOperation();
            table_buyop.setItems(buyOperations);
        });

        // Buyer
        add_buyer_data.setOnAction( event -> {
            dataBaseHandler.addBuyer(txt_buyer_name.getText());
            buyers = dataBaseHandler.getDataBuyer();
            table_buyer.setItems(buyers);
        });

        // Exchange
        add_exchange_data.setOnAction( event -> {
           dataBaseHandler.addExchange(txt_exchange_date.getText(), txt_exchange_creditacc.getText(), Double.parseDouble(
                   txt_exchange_creditval.getText()), txt_exchange_debitacc.getText(), Double.parseDouble(txt_exchange_debitval.getText()));
           exchanges = dataBaseHandler.getExchangeData();
           table_exchange.setItems(exchanges);
        });

        // Fin_op_type
        add_finoptype_data.setOnAction( event -> {
            dataBaseHandler.addFinOpType(txt_finoptype_name.getText());
            finOpTypes = dataBaseHandler.getDataFinOpType();
            table_finoptype.setItems(finOpTypes);
        });

        // Financial_op
        add_financialop_data.setOnAction( event -> {
            dataBaseHandler.addFinancialOp(txt_financialop_date.getText(), Double.parseDouble(txt_financialop_value.getText()),
                    txt_financialop_comment.getText(), txt_financialop_payaccname.getText(), txt_financialop_type.getText());
            financialOps = dataBaseHandler.getDataFinancialOp();
            table_financialop.setItems(financialOps);
        });

        // Game
        add_game_data.setOnAction( event -> {
            dataBaseHandler.addGame(txt_game_name.getText());
            games = dataBaseHandler.getDataGame();
            table_game.setItems(games);
        });

        // Gamecur_op
        add_gamecurop_data.setOnAction( event -> {
            dataBaseHandler.addGamecurOp(txt_gamecurop_date.getText(), Integer.parseInt(txt_gamecurop_quantity.getText()),
                    txt_gamecurop_comment.getText(), txt_gamecurop_game.getText());
            gamecurOps = dataBaseHandler.getGamecurOp();
            table_gamecurop.setItems(gamecurOps);
        });

        // Payment_account
        add_payment_data.setOnAction( event -> {
            dataBaseHandler.addPaymentAcc(txt_payment_name.getText());
            paymentAccounts = dataBaseHandler.getDataPaymentAcc();
            table_payment.setItems(paymentAccounts);
        });

        // Sell_operation
        add_sellop_data.setOnAction( event -> {
            dataBaseHandler.addSellOp(txt_sellop_date.getText(), Integer.parseInt(txt_sellop_quantity.getText()),
                    Double.parseDouble(txt_sellop_price.getText()), Double.parseDouble(txt_sellop_cost.getText()),
                    txt_sellop_payacc.getText(), txt_sellop_buyer.getText(), txt_sellop_game.getText());
            sellOperations = dataBaseHandler.getDataSellOp();
            table_sellop.setItems(sellOperations);
        });

        // Supplier
        add_supplier_data.setOnAction( event -> {
            dataBaseHandler.addSupplier(txt_supplier_name.getText(), txt_supplier_funname.getText(), txt_supplier_discord.getText(),
                    Double.parseDouble(txt_supplier_price.getText()), txt_supplier_paymeth.getText(), txt_supplier_payaddr.getText(),
                    txt_supplier_game.getText());
            suppliers = dataBaseHandler.getDataSupplier();
            table_supplier.setItems(suppliers);
        });

        /* Обновление данных */
        // Buy_operation
        update_buyop_data.setOnAction( event -> {
            dataBaseHandler.updateBuyOperation(Integer.parseInt(txt_buyop_id.getText()), txt_buyop_date.getText(), Integer.parseInt(txt_buyop_quantity.getText()),
                    Double.parseDouble(txt_buyop_price.getText()), Double.parseDouble(txt_buyop_cost.getText()),
                    txt_buyop_game.getText(), txt_buyop_supplier.getText(), txt_buyop_payacc.getText());
            buyOperations = dataBaseHandler.getDataBuyOperation();
            table_buyop.setItems(buyOperations);
        });

        // Buyer
        update_buyer_data.setOnAction( event -> {
            dataBaseHandler.updateBuyer(Integer.parseInt(txt_buyer_id.getText()), txt_buyer_name.getText());
            buyers = dataBaseHandler.getDataBuyer();
            table_buyer.setItems(buyers);
        });

        // Exchange
        update_exchange_data.setOnAction( event -> {
            dataBaseHandler.updateExchange(Integer.parseInt(txt_exchange_id.getText()), txt_exchange_date.getText(), txt_exchange_creditacc.getText(), Double.parseDouble(
                    txt_exchange_creditval.getText()), txt_exchange_debitacc.getText(), Double.parseDouble(txt_exchange_debitval.getText()));
            exchanges = dataBaseHandler.getExchangeData();
            table_exchange.setItems(exchanges);
        });

        // Fin_op_type
        update_finoptype_data.setOnAction( event -> {
            dataBaseHandler.updateFinOpType(Integer.parseInt(txt_finoptype_id.getText()), txt_finoptype_name.getText());
            finOpTypes = dataBaseHandler.getDataFinOpType();
            table_finoptype.setItems(finOpTypes);
        });

        // Financial_op
        update_financialop_data.setOnAction( event -> {
            dataBaseHandler.updateFinancialOp(Integer.parseInt(txt_financialop_id.getText()), txt_financialop_date.getText(), Double.parseDouble(txt_financialop_value.getText()),
                    txt_financialop_comment.getText(), txt_financialop_payaccname.getText(), txt_financialop_type.getText());
            financialOps = dataBaseHandler.getDataFinancialOp();
            table_financialop.setItems(financialOps);
        });

        // Game
        update_game_data.setOnAction( event -> {
            dataBaseHandler.updateGame(Integer.parseInt(txt_game_id.getText()), txt_game_name.getText());
            games = dataBaseHandler.getDataGame();
            table_game.setItems(games);
        });

        // Gamecur_op
        update_gamecurop_data.setOnAction( event -> {
            dataBaseHandler.updateGamecurOp(Integer.parseInt(txt_gamecurop_id.getText()), txt_gamecurop_date.getText(), Integer.parseInt(txt_gamecurop_quantity.getText()),
                    txt_gamecurop_comment.getText(), txt_gamecurop_game.getText());
            gamecurOps = dataBaseHandler.getGamecurOp();
            table_gamecurop.setItems(gamecurOps);
        });

        // Payment_account
        update_payment_data.setOnAction( event -> {
            dataBaseHandler.updatePaymentAcc(Integer.parseInt(txt_payment_id.getText()), txt_payment_name.getText());
            paymentAccounts = dataBaseHandler.getDataPaymentAcc();
            table_payment.setItems(paymentAccounts);
        });

        // Sell_operation
        update_sellop_data.setOnAction( event -> {
            dataBaseHandler.updateSellOp(Integer.parseInt(txt_sellop_id.getText()), txt_sellop_date.getText(), Integer.parseInt(txt_sellop_quantity.getText()),
                    Double.parseDouble(txt_sellop_price.getText()), Double.parseDouble(txt_sellop_cost.getText()),
                    txt_sellop_payacc.getText(), txt_sellop_buyer.getText(), txt_sellop_game.getText());
            sellOperations = dataBaseHandler.getDataSellOp();
            table_sellop.setItems(sellOperations);
        });

        // Supplier
        update_supplier_data.setOnAction( event -> {
            dataBaseHandler.updateSupplier(Integer.parseInt(txt_supplier_id.getText()), txt_supplier_name.getText(), txt_supplier_funname.getText(), txt_supplier_discord.getText(),
                    Double.parseDouble(txt_supplier_price.getText()), txt_supplier_paymeth.getText(), txt_supplier_payaddr.getText(),
                    txt_supplier_game.getText());
            suppliers = dataBaseHandler.getDataSupplier();
            table_supplier.setItems(suppliers);
        });

        /* Удаление данных */
        // Buy_operation
        delete_buyop_data.setOnAction( event -> {
            dataBaseHandler.deleteBuyOperation(Integer.parseInt(txt_buyop_id.getText()));
            buyOperations = dataBaseHandler.getDataBuyOperation();
            table_buyop.setItems(buyOperations);
        });

        // Buyer
        delete_buyer_data.setOnAction( event -> {
            dataBaseHandler.deleteBuyer(txt_buyer_name.getText());
            buyers = dataBaseHandler.getDataBuyer();
            table_buyer.setItems(buyers);
        });

        // Exchange
        delete_exchange_data.setOnAction( event -> {
            dataBaseHandler.deleteExchange(Integer.parseInt(txt_exchange_id.getText()));
            exchanges = dataBaseHandler.getExchangeData();
            table_exchange.setItems(exchanges);
        });

        // Fin_op_type
        delete_finoptype_data.setOnAction( event -> {
            dataBaseHandler.deleteFinOpType(txt_finoptype_name.getText());
            finOpTypes = dataBaseHandler.getDataFinOpType();
            table_finoptype.setItems(finOpTypes);
        });

        // Financial_op
        delete_financialop_data.setOnAction( event -> {
            dataBaseHandler.deleteFinancialOp(Integer.parseInt(txt_financialop_id.getText()));
            financialOps = dataBaseHandler.getDataFinancialOp();
            table_financialop.setItems(financialOps);
        });

        // Game
        delete_game_data.setOnAction( event -> {
            dataBaseHandler.deleteGame(txt_game_name.getText());
            games = dataBaseHandler.getDataGame();
            table_game.setItems(games);
        });

        // Gamecur_op
        delete_gamecurop_data.setOnAction( event -> {
            dataBaseHandler.deleteGamecurOp(Integer.parseInt(txt_gamecurop_id.getText()));
            gamecurOps = dataBaseHandler.getGamecurOp();
            table_gamecurop.setItems(gamecurOps);
        });

        // Payment_account
        delete_payment_data.setOnAction( event -> {
            dataBaseHandler.deletePaymentAcc(txt_payment_name.getText());
            paymentAccounts = dataBaseHandler.getDataPaymentAcc();
            table_payment.setItems(paymentAccounts);
        });

        // Sell_operation
        delete_sellop_data.setOnAction( event -> {
            dataBaseHandler.deleteSellOp(Integer.parseInt(txt_sellop_id.getText()));
            sellOperations = dataBaseHandler.getDataSellOp();
            table_sellop.setItems(sellOperations);
        });

        // Supplier
        delete_supplier_data.setOnAction( event -> {
            dataBaseHandler.deleteSupplier(Integer.parseInt(txt_supplier_id.getText()));
            suppliers = dataBaseHandler.getDataSupplier();
            table_supplier.setItems(suppliers);
        });

        /* Выборки */
        // Первый запрос
        execute_getBuyOpsSupp.setOnAction( event -> {
            col_getBuyOpsSupp_id.setCellValueFactory(new PropertyValueFactory<Buy_operation, Integer>("id"));
            col_getBuyOpsSupp_price.setCellValueFactory(new PropertyValueFactory<Buy_operation, Double>("price"));
            col_getBuyOpsSupp_supplier.setCellValueFactory(new PropertyValueFactory<Buy_operation, String>("supplier"));
            getBuyOpsSupp_request = dataBaseHandler.getBuyOpsSupp(Double.parseDouble(txt_getBuyOpsSupp_min.getText()), Double.parseDouble(txt_getBuyOpsSupp_max.getText()));
            table_getBuyOpsSupp.setItems(getBuyOpsSupp_request);
        });

        // Второй запрос
        execute_getExchangeType.setOnAction( event -> {
            col_getExchangeType_id.setCellValueFactory(new PropertyValueFactory<Exchange, Integer>("id"));
            col_getExchangeType_creditacc.setCellValueFactory(new PropertyValueFactory<Exchange, String>("credit_account"));
            getExchangeType_request = dataBaseHandler.getExchangeType((String) combobox_getExchangeType_types.getValue());
            table_getExchangeType.setItems(getExchangeType_request);
        });

        // Третий запрос
        execute_getBuyerDate.setOnAction( event -> {
            col_getBuyerDate_id.setCellValueFactory(new PropertyValueFactory<Buyer, Integer>("id"));
            col_getBuyerDate_name.setCellValueFactory(new PropertyValueFactory<Buyer, String>("name"));
            getBuyerDate_request = dataBaseHandler.getBuyerDate((String) combobox_getBuyerDate_dates.getValue());
            table_getBuyerDate.setItems(getBuyerDate_request);
        });

        // Четвертый запрос
        execute_getSupplierQuantity.setOnAction( event -> {
            col_getSupplierQuantity_id.setCellValueFactory(new PropertyValueFactory<Supplier, Integer>("id"));
            col_getSupplierQuantity_name.setCellValueFactory(new PropertyValueFactory<Supplier, String>("name"));
            col_getSupplierQuantity_funpayname.setCellValueFactory(new PropertyValueFactory<Supplier, String>("funpay_name"));
            col_getSupplierQuantity_discordname.setCellValueFactory(new PropertyValueFactory<Supplier, String>("discord_name"));
            getSupplierQuantity_request = dataBaseHandler.getSupplierQuantity(Integer.parseInt(txt_getSupplierQuantity_quantity.getText()));
            table_getSupplierQuantity.setItems(getSupplierQuantity_request);
        });

    }
}
