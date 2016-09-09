package jp.techacademy.takumi.fukushima.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);

        editText2 = (EditText) findViewById(R.id.editText2);

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        Button subtractButton = (Button) findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(this);

        Button multiplyButton = (Button) findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(this);

        Button devideButton = (Button) findViewById(R.id.devideButton);
        devideButton.setOnClickListener(this);
    }

    public void onClick(View v){

        String inputValue1 = editText1.getText().toString();
        String inputValue2 = editText2.getText().toString();
        if(inputValue1.equals("") || inputValue2.equals("")){
            showAlertDialog("empty");
        }

        try {
            double value1 = Double.valueOf(editText1.getText().toString());
            double value2 = Double.valueOf(editText2.getText().toString());


            if (v.getId() == R.id.addButton) {
                Intent intent = new Intent(this, resultActivity.class);
                intent.putExtra("result", value1 + value2);
                Log.d("UI-PARTS", String.valueOf(value1 + value2));
                startActivity(intent);
            } else if (v.getId() == R.id.subtractButton) {
                Intent intent = new Intent(this, resultActivity.class);
                intent.putExtra("result", value1 - value2);
                Log.d("UI-PARTS", String.valueOf(value1 - value2));
                startActivity(intent);
            } else if (v.getId() == R.id.multiplyButton) {
                Intent intent = new Intent(this, resultActivity.class);
                intent.putExtra("result", value1 * value2);
                startActivity(intent);
            } else if (v.getId() == R.id.devideButton) {
                Intent intent = new Intent(this, resultActivity.class);
                intent.putExtra("result", value1 / value2);
                startActivity(intent);
            }
        }
        catch (NumberFormatException e) {
            showAlertDialog("illegal");
        }
    }

    private void showAlertDialog(String error){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラーメッセージ");
        if(error.equals("empty")) {
            alertDialogBuilder.setMessage("数値が入力されていません。");
        }else if (error.equals("illegal")) {
            alertDialogBuilder.setMessage("入力値が不正です");
        }

        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI-PARTS", "OKボタン押下");
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
