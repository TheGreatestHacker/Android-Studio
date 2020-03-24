package com.example.tempconverter2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar; //declare seekbar object
    TextView textView;
    TextView textView3;
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
        textView3 = findViewById(R.id.textView3);
        //handle checkbox click event
        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if (isChecked) {
                    checkBox.toggle(); // uncheck the checkbox after the user checks it
                    //remove objs from parent view to allow for child view objs
                    checkBox.setVisibility(View.GONE);
                    seekBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    textView3.setVisibility(View.GONE);
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
        final TextView tv = (TextView)findViewById(R.id.textView3);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (temp == 0) //for initial view result
                    //Toast.makeText(getBaseContext(), "Fahrenheit result: 32 degrees", Toast.LENGTH_SHORT).show();
                    tv.setText("Fahrenheit results: 32 degrees");
                else
                    //Toast.makeText(getBaseContext(), "Fahrenheit result: "
                    //        + String.valueOf(discrete) +
                    //        " degrees",Toast.LENGTH_SHORT).show();
                    tv.setText("Fahrenheit results: " + String.valueOf(discrete) + " degrees");
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
        String[] wkDays = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        lv = findViewById(R.id.listView);
        @SuppressWarnings({"unchecked", "rawtypes"})
        /*
         * To use a basic ArrayAdapter, you just need to initialize the adapter and
         * attach the adapter to the ListView. First, initialize the adapter...:
         *
         */

        /*
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, wkTemps);
        // Assign adapter to ListView
        lv.setAdapter(adapter);
        */


        ListView resultsListView = (ListView) findViewById(R.id.listView);
        HashMap<String, String> dayTemp = new HashMap<>();
        dayTemp.put("Fri", "38");
        dayTemp.put("Thur", "37");
        dayTemp.put("Wed", "33");
        dayTemp.put("Tue", "31");
        dayTemp.put("Mon", "30");

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text3, R.id.text4});

        Iterator it = dayTemp.entrySet().iterator();
        while (it.hasNext()){
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        resultsListView.setAdapter(adapter);



        final Button button = findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                checkBox.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                stub.setVisibility(View.GONE);
            }
        });
    }//end onCreate method
}//end class MainActivity
