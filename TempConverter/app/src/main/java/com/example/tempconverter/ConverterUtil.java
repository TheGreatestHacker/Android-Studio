package com.example.tempconverter;

public class ConverterUtil {
    public static double convertFahrenheitToCelsius(float fahrenheit){
        return ((fahrenheit-32)*5.0/9.0);
    }//end of method convertFahrenheitToCelsius

    public static double convertCelsiusToFahrenheit(float celsius) {
        return (celsius*(9/5.0))+32;
    }//end of method converterCelsiusToFahrenheit

}//end of class ConverterUtil
