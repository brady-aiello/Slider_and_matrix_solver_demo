package com.example.android.slider_graph_demo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import Jama.Matrix;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBarTop;
    SeekBar seekBar2;
    TextView textViewZinLevel;
    TextView textViewCabLevel;
    //TextView textViewPinotNoirLevel;

    TextView textViewEarthyLevel;
    TextView textViewFruityLevel;
    TextView textViewNuttyLevel;

    SeekBar seekBarEarthy;
    SeekBar seekBarFruity;
    SeekBar seekBarNutty;
    Button button;
    int progress1, progress2, progress3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarTop = (SeekBar)findViewById(R.id.slider_top);
        seekBar2 = (SeekBar) findViewById(R.id.slider_2);
        textViewZinLevel = (TextView) findViewById(R.id.tv_top);
        textViewCabLevel = (TextView) findViewById(R.id.tv_2);
        button = (Button) findViewById(R.id.button_to_wine_solver_activity);
        final Context context = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WineBlendSolverActivity.class);
                startActivity(intent);
            }
        });
        //textViewPinotNoirLevel = (TextView) findViewById(R.id.tv_pinot_noir_level);

        textViewEarthyLevel = (TextView) findViewById(R.id.tv_earthy_level);
        textViewFruityLevel = (TextView) findViewById(R.id.tv_fruity_level);
        textViewNuttyLevel = (TextView) findViewById(R.id.tv_nutty_level);

        seekBarEarthy = (SeekBar) findViewById(R.id.progress_earthiness);
        seekBarFruity = (SeekBar) findViewById(R.id.progress_fruity);
        seekBarNutty = (SeekBar) findViewById(R.id.progress_nutty);
        FlavorProfile flavorProfileZin = new FlavorProfile(50, 50, 70, 10, 50);
        FlavorProfile flavorProfileCab = new FlavorProfile(10, 100, 30, 30, 40);
        //FlavorProfile flavorProfilePinotNoir = new FlavorProfile(5, 40, 20, 40, 15);
        final int earthyZin = flavorProfileZin.getEarthy();
        final int earthyCab = flavorProfileCab.getEarthy();
        //final int earthyPinotNoir = flavorProfilePinotNoir.getEarthy();

        final int fruityZin = flavorProfileZin.getFruity();
        final int fruityCab = flavorProfileCab.getFruity();
        //final int fruityPinotNoir = flavorProfilePinotNoir.getFruity();

        final int nuttyZin = flavorProfileZin.getNutty();
        final int nuttyCab = flavorProfileCab.getNutty();
        //final int nuttyPinotNoir = flavorProfilePinotNoir.getNutty();

        FlavorProfile flavorProfiletarget = new FlavorProfile(0, 0, 0, 0, 0);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress1 = progress;
                int left = 100 - progress;
                progress2 = left;
                seekBar2.setProgress(progress2);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewZinLevel.setText(Integer.toString(progress1));
                textViewCabLevel.setText(Integer.toString(progress2));
                int progressEarthy = ((progress1 * earthyZin) + (progress2 * earthyCab)) / 200;
                int progressFruity = ((progress1 * fruityZin) + (progress2 * fruityCab)) / 200;
                int progressNutty = ((progress1 * nuttyZin) + (progress2 * nuttyCab)) / 200;
                seekBarEarthy.setProgress(progressEarthy);
                seekBarFruity.setProgress(progressFruity);
                textViewEarthyLevel.setText(Integer.toString(progressEarthy));
                textViewFruityLevel.setText(Integer.toString(progressFruity));
                textViewNuttyLevel.setText(Integer.toString(progressNutty));
            }
        };
        seekBarTop.setOnSeekBarChangeListener(listener);
        SeekBar.OnSeekBarChangeListener listener2 = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress2 = progress;
                progress1 = 100 - progress2;
                seekBarTop.setProgress(progress1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewZinLevel.setText(Integer.toString(progress1));
                textViewCabLevel.setText(Integer.toString(progress2));
                int progressEarthy = ((progress1 * earthyZin) + (progress2 * earthyCab)) / 200;
                int progressFruity = ((progress1 * fruityZin) + (progress2 * fruityCab)) / 200;
                int progressNutty = ((progress1 * nuttyZin) + (progress2 * nuttyCab)) / 200;
                seekBarEarthy.setProgress(progressEarthy);
                seekBarFruity.setProgress(progressFruity);
                textViewEarthyLevel.setText(Integer.toString(progressEarthy));
                textViewFruityLevel.setText(Integer.toString(progressFruity));
                textViewNuttyLevel.setText(Integer.toString(progressNutty));
            }
        };
        seekBar2.setOnSeekBarChangeListener(listener2);
    }
}
