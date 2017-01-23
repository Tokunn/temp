package com.example.tokunn.libraryparser;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//import org.w3c.dom.Text;

import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean flag = false;
    private TextView textBox;
    private TextView resultBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = (TextView) findViewById(R.id.textbox);
        textBox.setText("hello");

        resultBox = (TextView) findViewById(R.id.resultbox);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                if (flag) {
                    textBox.setText("hello");
                    flag = false;
                }
                else {
                    textBox.setText("World");
                    flag = true;
                }

                /*TcpTest tt = new TcpTest();
                tt.start();*/
                Toast.makeText(MainActivity.this, "検索中...", Toast.LENGTH_LONG).show();
                ExecutorService executor = Executors.newCachedThreadPool();
                Future<String> future = executor.submit(new TcpTest());
                try {
                    String result = future.get();
                    resultBox.setText(result);
                    Log.d("uDbg", result);
                }
                catch (Exception e) {
                    Log.d("uDbg", "Error"+e.getMessage());
                }
                executor.shutdown();
            }
        });
    }
}
