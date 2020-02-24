package com.example.tempconverter2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar; //declare seekbar object
    TextView textView;
    //declare member variables for SeekBar
    int discrete = 0;
    int start = 50;
    int start_position = 50; //progress tracker
    int temp = 0;
    //declare objects for ViewStub
    ViewStub stub;
    CheckBox checkBox;
    ListView lv; //declare Listview object
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare viewstub object
        stub = findViewById(R.id.viewStub1);
        @SuppressWarnings("unused")
        View inflated = stub.inflate();
        stub.setVisibility(View.INVISIBLE);
        //ViewStub logic
        checkBox = findViewById(R.id.checkBox1);
        //handle checkbox click event
        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if (isChecked) {
                    checkBox.toggle(); // uncheck the checkbox after the user checks it
                    //remove objs from parent view to allow for child view objs
                    checkBox.setVisibility(View.GONE);
                    seekBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    stub.setVisibility(View.VISIBLE);
                }
            }
        });
        //seekbar logic
        textView = findViewById(R.id.textview);
        textView.setText(" Celsius at 0 degrees");
        //set default view
        seekBar = findViewById(R.id.seekbar);
        seekBar.setProgress(start_position);
        //create event handler for SeekBar
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (temp == 0) //for initial view result
                    Toast.makeText(getBaseContext(), "Fahrenheit result: 32 degrees",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Fahrenheit result: "
                            + String.valueOf(discrete) +
                            " degrees",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress, boolean fromUser) {
                // To convert progress passed as discrete (Fahrenheit) value
                temp = progress - start;
                discrete = (int) Math.round((((temp * 9.0) /
                        5.0) + 32)); //convert C to F temp
                textView.setText(" Celsius at " + temp + " degrees");
            }
        });
        //Listview logic
        String[] wkTemps = new String[]{"37", "32", "28", "28", "30"};
        lv = findViewById(R.id.listView);
        @SuppressWarnings({"unchecked", "rawtypes"})
        /*
         * To use a basic ArrayAdapter, you just need to initialize the adapter and
         * attach the adapter to the ListView. First, initialize the adapter...:
         *
         */
                ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, wkTemps);
        // Assign adapter to ListView
        lv.setAdapter(adapter);

        final Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                checkBox.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                stub.setVisibility(View.GONE);
            }
        });
    }//end onCreate method
}//end class MainActivity
