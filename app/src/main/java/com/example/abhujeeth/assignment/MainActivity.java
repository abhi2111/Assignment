package com.example.abhujeeth.assignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    final int ACTIVITY_CHOOSE_FILE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button choosebtn = (Button) findViewById(R.id.choosebtn);
        choosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choosefile;
                Intent intent;
                choosefile = new Intent(Intent.ACTION_GET_CONTENT);
                choosefile.setType("file/*");
                intent = Intent.createChooser(choosefile, "Choose a file");
                startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ACTIVITY_CHOOSE_FILE: {
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    String filePath = uri.getPath();
                    String name = uri.getLastPathSegment();
                    EditText editText = (EditText) findViewById(R.id.filename);
                    editText.setText(filePath);
                    int j;


                    TextView textView = (TextView) findViewById(R.id.filename1);

                    File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    File file = new File(dir,name);

                    if (file.exists()) {
                        StringBuilder text = new StringBuilder();
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            String line;

                            while ((line = br.readLine()) != null) {
                                text.append(line + '\n');
                            }
                        } catch (IOException e) {
                            Log.e("Error!", "Error occured while reading text file from Internal Storage!");

                        }
                        textView.setText(text);

                    } else
                        textView.setText("none");
                }
            }
        }
    }
}



                      //  FileInputStream fIS = new FileInputStream(new File(filePath,name));
                       // InputStreamReader isr = new InputStreamReader(fIS, "UTF-8");
                      //  BufferedReader br = new BufferedReader(isr);

                      ////  String line;

                       // while ((line = br.readLine()) != null) {
                       //     text.append(line + '\n');
                        //}
                       // br.close();
                        //fIS.close();












