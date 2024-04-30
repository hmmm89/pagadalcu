package com.example.pagadthirdguidedexercise;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView lblFirstNum, lblSecondNum, lblTitle, lblResult;
    Button btnSum, btnAverage, btnDifference, btnMultiply, btnQuotient, btnModulo;
    double firstNum, secondNum, resultNum;
    EditText txtFirstNum, txtSecondNum;
    Toast viewMessage;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculator_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lblFirstNum = findViewById(R.id.lblFirstNum);
        lblSecondNum = findViewById(R.id.lblSecondNum);
        lblTitle = findViewById(R.id.lblTitle);

        btnSum = findViewById(R.id.btnSum);
        btnAverage = findViewById(R.id.btnAverage);
        btnDifference = findViewById(R.id.btnDifference);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnQuotient = findViewById(R.id.btnQuotient);
        btnModulo = findViewById(R.id.btnModulo);

        txtFirstNum = findViewById(R.id.txtFirstNum);
        txtSecondNum = findViewById(R.id.txtSecondNum);

        txtFirstNum.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        txtSecondNum.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);

        computeTotal();
    }

    public void computeTotal(){
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSum.setActivated(true);
                displayErrorMessage();
                btnSum.setActivated(false);
                Toast.makeText(getApplicationContext(),
                        "SUM: " + resultNum,Toast.LENGTH_SHORT).show();
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAverage.setActivated(true);
                displayErrorMessage();
                btnAverage.setActivated(false);
                Toast.makeText(getApplicationContext(),
                        "AVERAGE: " + resultNum,Toast.LENGTH_SHORT).show();
            }
        });

        btnDifference.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnDifference.setActivated(true);
                displayErrorMessage();
                btnDifference.setActivated(false);
                Toast.makeText(getApplicationContext(),
                        "DIFFERENCE: " + resultNum,Toast.LENGTH_SHORT).show();
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                btnMultiply.setActivated(true);
                displayErrorMessage();
                btnMultiply.setActivated(false);
                Toast.makeText(getApplicationContext(),
                        "PRODUCT: " + resultNum, Toast.LENGTH_SHORT).show();
            }
        });

        btnQuotient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnQuotient.setActivated(true);
                displayErrorMessage();
                btnQuotient.setActivated(false);
                Toast.makeText(getApplicationContext(),
                        "QUOTIENT: " + resultNum,Toast.LENGTH_SHORT).show();
            }
        });

        btnModulo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnModulo.setActivated(true);
                displayErrorMessage();
                btnModulo.setActivated(false);
                Toast.makeText(getApplicationContext(),
                    "MODULO: " + resultNum,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void displayErrorMessage(){
        if(txtFirstNum.getText().toString().isEmpty() || txtSecondNum.getText().toString().isEmpty()){
            viewMessage = Toast.makeText(getApplicationContext(),
                "Please Enter a Number", Toast.LENGTH_SHORT);
            view = viewMessage.getView();
            //view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
            viewMessage.setGravity(Gravity.CENTER, 0,0);
            viewMessage.show();
        }
        else{
            firstNum = Double.parseDouble(txtFirstNum.getText().toString());
            secondNum = Double.parseDouble(txtSecondNum.getText().toString());
            isClicked();
        }
    }

    public void isClicked(){
        if(btnAverage.isActivated()){
            resultNum = (firstNum + secondNum) / 2;
        }
        else if(btnSum.isActivated()){
            resultNum = firstNum + secondNum;
        }
        else if(btnDifference.isActivated()){
            resultNum = firstNum - secondNum;
        }
        else if(btnMultiply.isActivated()){
            resultNum = firstNum * secondNum;
        }
        else if(btnModulo.isActivated()){
            resultNum = firstNum % secondNum;
        }
        else{
            resultNum = firstNum / secondNum;
        }
    }
}