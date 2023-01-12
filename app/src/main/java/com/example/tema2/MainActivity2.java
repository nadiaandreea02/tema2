package com.example.tema2;

import static java.lang.Math.addExact;
import static java.lang.Math.subtractExact;
import static java.lang.Math.toIntExact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
      int recData1,recData2, calc_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         recData1 = getIntent().getIntExtra("first_number",0);
       recData2 = getIntent().getIntExtra("second_number",0);

        TextView textViewNr = findViewById(R.id.textViewNr);
        textViewNr.setText("Numbers: "+ recData1+","+recData2);
    }
    public void onClickAdd(View view)
    {  calc_result= recData1+recData2;
        Intent intent_2= new Intent(this, MainActivity.class);

        intent_2.putExtra("calc_result",calc_result);
        setResult(RESULT_OK, intent_2);
        Toast.makeText(getApplicationContext(),"ADD..",Toast.LENGTH_SHORT).show();

        finish();
    }
    public void onClickSub(View view)
    {
        calc_result= recData1-recData2;
        Intent intent_3= new Intent(this, MainActivity.class);

        intent_3.putExtra("calc_result",calc_result);
       Toast.makeText(getApplicationContext(),"SUBSTRACT...",Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK, intent_3);
        finish();
    }
}