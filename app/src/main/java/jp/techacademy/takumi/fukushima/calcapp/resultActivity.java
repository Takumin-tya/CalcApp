package jp.techacademy.takumi.fukushima.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultText = (TextView) findViewById(R.id.resultText);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result",0);

        resultText.setText(String.valueOf(result));
    }
}
