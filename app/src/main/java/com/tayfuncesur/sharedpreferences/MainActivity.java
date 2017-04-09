package com.tayfuncesur.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);


        findViewById(R.id.BTNYaz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences.edit().putString("TEST_DATA",((AppCompatEditText)findViewById(R.id.appCompatEditText)).getText().toString()).apply();

                /**
                 * if you care about the data is write successfully
                 * boolean result = sharedPreferences.edit().putString("TEST_DATA",((AppCompatEditText)findViewById(R.id.appCompatEditText)).getText().toString()).commit();
                 * if (result) {
                 *      //You can pretty sure about the data has written successfully
                 * }
                 * */
            }
        });

        findViewById(R.id.BTNOku).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,sharedPreferences.getString("TEST_DATA","Data not found"),Toast.LENGTH_SHORT).show();
            }
        });






    }
}
