package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    Activity context;
    TextView txtView;
    ArrayList<String> stringList = new ArrayList<String>();

    static int questionNum = 0;
    int stars=0;
    private RadioGroup radioQuestions;
    private RadioButton radioButton;

    ImageView image;
    ImageView recycle;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        rb = (RatingBar) findViewById(R.id.ratingBar);
        BackgroundTask bt = new BackgroundTask();
        bt.execute("http://www.papademas.net:81/sample.txt"); //grab url

        //rb.setRating(stars);
        rb.setVisibility(View.INVISIBLE);
    }//end onCreate

    //background process to download the file from internet
    private class BackgroundTask extends AsyncTask<String, Integer, Void> {

        protected void onPreExecute() {  }

        protected Void doInBackground(String... params) {
            URL url;
            String StringBuffer = null;
            try {
                //create url object to point to the file location on internet
                url = new URL(params[0]);
                //make a request to server
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                //get InputStream instance
                InputStream is = con.getInputStream();
                //create BufferedReader object
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                //read content of the file line by line & add it to Stringbuffer
                while ((StringBuffer = br.readLine()) != null) {
                    stringList.add(StringBuffer);  //add to Arraylist
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result) {
            txtView = findViewById(R.id.textView1);
            //display read text in TextVeiw
            txtView.setText(stringList.get(0));
            startQuiz();
        }
    }//end BackgroundTask class

    public void startQuiz() {
        buttonListener();
    }

    public void buttonListener() {
        Button btnDisplay;

        radioQuestions = findViewById(R.id.radioQuestions);
        btnDisplay = findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioQuestions.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = findViewById(selectedId);

                switch (questionNum) {
                    case 0:
                        //verify if result matches the right button selection
                        //i.e., (True or false!)
                        if (radioButton.getText().equals("True")) {
                            Toast.makeText(MainActivity.this,
                                    " Right!", Toast.LENGTH_SHORT).show();
                            stars++;
                            rb.setRating(stars);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    " Wrong!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 1:
                        //verify if result matches the right button selection
                        //i.e., (True or false!)
                        if (radioButton.getText().equals("False")) {
                            Toast.makeText(MainActivity.this,
                                    " Right!", Toast.LENGTH_SHORT).show();
                            stars++;
                            rb.setRating(stars);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    " Wrong!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    case 2:
                        if (radioButton.getText().equals("True")) {
                            Toast.makeText(MainActivity.this,
                                    " Right!", Toast.LENGTH_SHORT).show();
                            stars++;
                            rb.setRating(stars);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    " Wrong!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        if (radioButton.getText().equals("False")) {
                            Toast.makeText(MainActivity.this,
                                    " Right!", Toast.LENGTH_SHORT).show();
                            stars++;
                            rb.setRating(stars);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    " Wrong!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        if (radioButton.getText().equals("False")) {
                            Toast.makeText(MainActivity.this,
                                    " Right!", Toast.LENGTH_SHORT).show();
                            stars++;
                            rb.setRating(stars);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    " Wrong!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                }//end switch
            }//end onClick

        }); //onClickListener
        imageListener();
    }//end buttonListener

    public void imageListener() {
        image = findViewById(R.id.imageView1);
        recycle = findViewById(R.id.imageView2);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get new question for viewing
                //image.setImageResource(R.drawable.recycle);
                if ( questionNum < 4){
                    txtView.setText(stringList.get(++questionNum));
                    //reset radio button (radioTrue) to default
                    radioQuestions.check(R.id.radioTrue);
                } else {
                    txtView.setText("End of quiz. Final score is: ");
                    rb.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,
                            " End of quiz!", Toast.LENGTH_SHORT).show();
                }

            }//end onClick method
        });

        recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get new question for viewing
                //image.setImageResource(R.drawable.recycle);
                if ( questionNum == 4){
                    //reset count to -1 to start first question again
                    questionNum = -1;
                }
                txtView.setText(stringList.get(++questionNum));
                //reset radio button (radioTrue) to default
                radioQuestions.check(R.id.radioTrue);
                stars=0;
                rb.setRating(0);
                rb.setVisibility(view.INVISIBLE);
            }//end onClick method
        });

    }//end imageListener

}//end activity

