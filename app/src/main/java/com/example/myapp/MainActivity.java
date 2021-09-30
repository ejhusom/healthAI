package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.opencsv.CSVReader;

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

            int subsequenceSize = 10;
            int numRawFeatures = 6;
//            double[][] subsequence = new double[subsequenceSize][numRawFeatures];
            double[][] subsequence = new double[numRawFeatures][subsequenceSize];


            String[] nextLine;
            double[] preprocessedSubsequence;

            // Looping through all data
            //while ((nextLine = reader.readNext()) != null) {
            for (int k = 0; k < 1; k++) {

                // Loop to get subsequence of input data
                for (int i = 0; i < subsequenceSize; i++) {
                    nextLine = reader.readNext();

                    // Saving each column as a row for easy access later
                    for (int j = 0; j < numRawFeatures; j++) {
                        subsequence[j][i] = Double.parseDouble(nextLine[j+2]);
                    }

//                    System.out.println(subsequence[i][0] + ", " + subsequence[i][1]);
                }

                preprocessedSubsequence = preprocess(subsequence);


                //System.out.println(subsequence);
                System.out.println(preprocessedSubsequence);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }
    }

    public double[] preprocess(double[][] rawData) {

        int numRawFeatures = rawData[1].length;
        int numFeatures = 3 * numRawFeatures;
        double[] preprocessedData = new double[numFeatures];

        int idx = 0;

        for (int i = 0; i < numRawFeatures; i++) {
            preprocessedData[idx] = calculateMean(rawData[i]);
            preprocessedData[idx + 1] = findMin(rawData[i]);
            preprocessedData[idx + 2] = findMax(rawData[i]);
            idx += 3;
        }

        return preprocessedData;
    }

    public static double calculateMean(double[] array) {
        double mean;
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        mean = sum / (double)array.length;

        return mean;
    }

    public static double findMin(double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static double findMax(double[] array) {
        double max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

//    public static double calculateVariance(double[] array) {
//        double var;
//        double mean = calculateMean(array);
//        double x;
//
//        for (int i = 0; i < array.length; i++) {
//            x = Math.abs(array[i] - mean);
//        }
//
//        var = calculateMean(x);
//
//        return var;
//    }
}
