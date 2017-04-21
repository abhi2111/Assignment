package com.example.abhujeeth.assignment;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by abhujeeth on 4/20/17.
 */

public class Readfile {


    public static String readFrom(Context context, String filename) {
        StringBuilder text = new StringBuilder();


        try {


            FileInputStream fIS = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fIS, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                text.append(line + '\n');
            }
            br.close();
        } catch (IOException e) {
            Log.e("Error!", "Error occured while reading text file from Internal Storage!");

        }

        return text.toString();
    }
}

