package com.example.android.slider_graph_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


import Jama.Matrix;

public class WineBlendSolverActivity extends AppCompatActivity {
    EditText w1_Fruity, w1_Nutty, w1_Earthy;
    EditText w2_Fruity, w2_Nutty, w2_Earthy;
    EditText w3_Fruity, w3_Nutty, w3_Earthy;

    EditText targetFruity, targetNutty, targetEarthy;
    TextView target_w1, target_w2, target_w3;
    Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_blend_solver);
        w1_Fruity       = (EditText)findViewById(R.id.edit_text_w1_fruity);
        w1_Nutty        = (EditText) findViewById(R.id.edit_text_w1_nutty);
        w1_Earthy       = (EditText)findViewById(R.id.edit_text_w1_earthy);
        w2_Fruity       = (EditText)findViewById(R.id.edit_text_w2_fruity);
        w2_Nutty        = (EditText) findViewById(R.id.edit_text_w2_nutty);
        w2_Earthy       = (EditText)findViewById(R.id.edit_text_w2_earthy);
        w3_Fruity       = (EditText)findViewById(R.id.edit_text_w3_fruity);
        w3_Nutty        = (EditText) findViewById(R.id.edit_text_w3_nutty);
        w3_Earthy       = (EditText)findViewById(R.id.edit_text_w3_earthy);
        targetFruity    = (EditText) findViewById(R.id.tv_target_fruity);
        targetNutty     = (EditText) findViewById(R.id.tv_target_nutty);
        targetEarthy    = (EditText) findViewById(R.id.tv_target_earthy);
        target_w1       = (TextView) findViewById(R.id.tv_w1_amt);
        target_w2       = (TextView) findViewById(R.id.tv_w2_amt);
        target_w3       = (TextView) findViewById(R.id.tv_w3_amt);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }
    public void calculate(){
        //Creating  Arrays Representing Equations
        double[][] lhsArray = {{Double.parseDouble(w1_Fruity.getText().toString()),
                                Double.parseDouble(w2_Fruity.getText().toString()),
                                Double.parseDouble(w3_Fruity.getText().toString())},
                               {Double.parseDouble(w1_Nutty.getText().toString()),
                                Double.parseDouble(w2_Nutty.getText().toString()),
                                Double.parseDouble(w3_Nutty.getText().toString())},
                               {Double.parseDouble(w1_Earthy.getText().toString()),
                                Double.parseDouble(w2_Earthy.getText().toString()),
                                Double.parseDouble(w3_Earthy.getText().toString())}};
        double[] rhsArray =    {Double.parseDouble(targetFruity.getText().toString()),
                                Double.parseDouble(targetNutty.getText().toString()),
                                Double.parseDouble(targetEarthy.getText().toString())};
        //Creating Matrix Objects with arrays
        Matrix lhs = new Matrix(lhsArray);
        Matrix rhs = new Matrix(rhsArray, 3);

        //Calculate Solved Matrix
        Matrix ans = lhs.solve(rhs);
        //Printing Answers
        DecimalFormat decimalFormat = new DecimalFormat(".##");
        target_w1.setText(decimalFormat.format(ans.get(0,0)));
        target_w2.setText(decimalFormat.format(ans.get(1,0)));
        target_w3.setText(decimalFormat.format(ans.get(2,0)));

        Log.d("x", "x = " + (ans.get(0, 0)));
        Log.d("y,", "y = " + (ans.get(1, 0)));
        Log.d("z", "z = " + (ans.get(2, 0)));
    }
}
