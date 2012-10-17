package de.vogella.android.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
    }
    public void onClick(View view){
    	switch (view.getId()){
    	case R.id.button1:
    		RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
    		RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
    		if (text.getText().length() == 0) {
    			Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
    			return;
    		}
    		
    		float inputValue = Float.parseFloat(text.getText().toString());
    		if (celsiusButton.isChecked()){
    			text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
    			celsiusButton.setChecked(false);
    			fahrenheitButton.setChecked(true);
    		}else{
    			text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
    			fahrenheitButton.setChecked(false);
    			celsiusButton.setChecked(true);
    		}
    		break;
    }
}

    private float convertFahrenheitToCelsius(float fahrenheit) {
    	return ((fahrenheit - 32) *5 / 9);
    }
    
    private float convertCelsiusToFahrenheit(float celsius){
    	return ((celsius * 9) / 5) + 32;
    }
}
