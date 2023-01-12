package com.example.tema2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                        public void onActivityResult( ActivityResult result){
            TextView textViewRez = findViewById(R.id.textViewRez);

            if(result.getResultCode()==RESULT_OK){
                Intent data = result.getData();
                if(data!=null){
                    int calc_result =data.getIntExtra("calc_result",0);
                    textViewRez.setText("Result "+calc_result);
                }
            }
            if(result.getResultCode()==RESULT_CANCELED){
                textViewRez.setText("Nothing ");
            }
                }


    }
    );









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  String recData11 = getIntent().getStringExtra("output_data");
       // String recData12 = getIntent().getStringExtra("output_data2");
      //  TextView textViewRez = findViewById(R.id.textViewRez);
      //  textViewRez.setText(recData11);

    }
    public void onClickCalculate(View view)
    {  EditText editTxtNr1= findViewById(R.id.editTxtNr1);
        EditText editTxtNr2= findViewById(R.id.editTxtNr2);

        if((editTxtNr1.getText().toString().equals(""))||(editTxtNr2.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(), "enter both numbers",Toast.LENGTH_LONG).show();

        }
        else {
            int nr1 = Integer.parseInt(editTxtNr1.getText().toString());
            int nr2 = Integer.parseInt(editTxtNr2.getText().toString());


            Intent intent_1 = new Intent(this, MainActivity2.class);
            intent_1.putExtra("first_number", nr1);
            intent_1.putExtra("second_number", nr2);

            activityLauncher.launch(intent_1);
        }
      //  Toast.makeText(getApplicationContext(),"Open Activity 2...",Toast.LENGTH_SHORT).show();
    //    startActivity(intent_1);
    }
}