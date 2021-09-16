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

        // Read csv file

        try {
            AssetManager mng = getApplicationContext().getAssets();
            InputStream is = mng.open("data.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is));

            //String[] nextLine = reader.readNext()
            int subsequenceSize = 10;
            int numFeatures = 24;
            double[][] subsequence = new double[subsequenceSize][numFeatures];
            Log.d("HELLO", "yo2");
            //while ((nextLine = reader.readNext()) != null) {
            for (int i = 0; i < subsequenceSize; i++) {
                Log.d("HELLO", "yo3");
                String[] nextLine = reader.readNext();
                Log.d("READING", nextLine[0]);
                for (int j = 0; i < numFeatures; j++) {
                    subsequence[i][j] = Double.parseDouble(nextLine[j]);
                }
                // nextLine[] is an array of values from the line
                // System.out.println(nextLine[1] + nextLine[1]);
            }
            //System.out.println(subsequence);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void preprocess(double[] rawData) {

        double[] preprocessedData;
    }
}
