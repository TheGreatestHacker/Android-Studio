package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View view; //create object to manipulate background color
    private EditText text;
    private TextView symbol;
    private RadioButton celsiusButton;
    private RadioButton fahrenheitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
        symbol=findViewById(R.id.textView3);
        celsiusButton = findViewById(R.id.celsiusButton);
        fahrenheitButton = findViewById(R.id.FahrenheitButton);

    }//end of method onCreate

    /* this method is called when user clicks the button and is handled because we assigned the name to the "OnClick property" of the button */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                if (text.getText().length()==0){
                    Toast.makeText(this, "Please enter a valid number",Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue=Float.parseFloat(text.getText().toString());
                if(fahrenheitButton.isChecked()){
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    symbol.setText("°F");
                    celsiusButton.setChecked(true);
                    fahrenheitButton.setChecked(false);
                }
                else if(celsiusButton.isChecked()){
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    symbol.setText("°C");
                    fahrenheitButton.setChecked(true);
                    celsiusButton.setChecked(false);
                }
                //grab current result value now in text field
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                if (inputValue<90 && inputValue>0) {
                    //set hex color to skyblue
                    view.setBackgroundColor(Color.parseColor("#87ceff"));
                } else if (inputValue<0){
                    view.setBackgroundColor(Color.RED);
                } else {
                    view.setBackgroundColor(Color.YELLOW);
                }
                break;
        }//end of switch
    }//end of method onClick

    public void onClickRadio(View view){
        if(view.getId()==R.id.celsiusButton){
            symbol.setText("°F");
        }
        else if(view.getId()==R.id.FahrenheitButton) {
            symbol.setText("°C");
        }
    }//end of onClickRadio method

}//end of class MainActivity
