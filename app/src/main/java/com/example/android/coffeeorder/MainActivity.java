package com.example.android.coffeeorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
import android.widget.CheckBox;
import android.util.Log;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=0;
    int price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked
     */
    public void incrementOrder (View view) {
        if (quantity>=0){
            quantity +=1;
            price= quantity*5;}
        displayQuantity (quantity);
        displayPrice(price);
    }

    /**
     * This method is called when the minus button is clicked
     */
    public void decrementOrder (View view) {
        if (quantity>0){
            quantity -=1;
            price= quantity*5;}
        displayQuantity (quantity);
        displayPrice(price);
    }

    /**
     * This method is calculating a price
     */
    private int calculatePrice () {return quantity * 5;}

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox= (CheckBox) findViewById(R.id.whipped_cream_checbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();

        int price=calculatePrice();
        String priceMessage = createOrderSummary (price, hasWhippedCream);
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     *This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    /**
     * This method display summary of the order
     */
    private String createOrderSummary(int price, boolean addWheepedCream){
        String priceMessage = "Name: Egi Uli";
        priceMessage += "\nAdd whipped cream? "+ addWheepedCream;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: " + NumberFormat.getCurrencyInstance().format(price);
        priceMessage += "\nThank you!";
        return priceMessage;
    }
}