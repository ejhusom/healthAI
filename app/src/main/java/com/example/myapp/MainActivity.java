package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void loadData(View view) {
        //Intent intent = new Intent(this, ClassifyStress.class);
        //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

        // Read csv file

        try {
            //File csvfile = new File(Environment.getExternalStorageDirectory() + "/data.csv");
            //String csvfileString = this.getApplicationInfo().dataDir + File.separatorChar + "assets/data.csv";
            //String csvfileString ="C:\\Users\\erikhu\\AndroidStudioProjects\\MyApp\\app\\src\\main\\assets\\data.csv";
            //String csvfileString ="C:\\Users\\erikhu\\AndroidStudioProjects\\MyApp\\app\\src\\main\\assets\\data.csv";
            String csvfileString ="src/main/assets/data.csv";
            Log.d("LOADDATA", csvfileString);
            //File csvfile = new File(csvfileString);
            Log.d("LOADDATA", "YOOO1");
            //Log.d("LOADDATA", csvfile.getAbsolutePath());
            //FileReader filereader = new FileReader(csvfileString);
            Log.d("LOADDATA", "YOOO2");
            //CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
            //CSVReader reader = new CSVReader(filereader);

            AssetManager mng = getApplicationContext().getAssets();
            InputStream is = mng.open("data.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is));

            String[] nextLine;
            Log.d("LOADDATA", "YOOO3");
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[0] + nextLine[1] + "etc...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }
}

