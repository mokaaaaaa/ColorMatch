package com.example.husse.colormatch;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.graphics.Color.CYAN;
import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
//Variables
    int[] colors = {
            Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.BLACK, Color.WHITE, Color.YELLOW, Color.GRAY, Color.MAGENTA
    };
    String[] colorNames =
            {
                    "RED", "GREEN", "BLUE", "CYAN", "BLACK", "WHITE", "YELLOW", "GRAY", "MAGENTA"
            };

    Random r = new Random();
    int i1 = 0, i2 = 0, score = 0, wrongScore = 0;
    TextView scoreView = null, colorView = null;
    Button  right = null,wrong = null,reset = null;
//End of  Variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r = new Random();
        i1 = (r.nextInt(9) + 0);
        i2 = (r.nextInt(9) + 0);
        scoreView = (TextView) findViewById(R.id.scoreTxt);
        colorView = (TextView) findViewById(R.id.colorTxt);
        colorView.setText(colorNames[i1]);
        colorView.setTextColor(colors[i2]);
        right  = (Button) findViewById(R.id.rightBtn);
        wrong =  (Button) findViewById(R.id.wrongBtn);
        reset = (Button) findViewById(R.id.resetBtn);
    }

    //Right Click Function
    public void rightClick(View view) {
        if (i1 == i2) {
            score++;
            i1 = (r.nextInt(9) + 0);
            i2 = (r.nextInt(9) + 0);
            if (score + wrongScore == 9) {
                scoreView.setText(" ");
                colorView.setTextColor(Color.BLACK);
                colorView.setText("Game Over \n Your Score :" + String.valueOf(score));
                right.setEnabled(false);
                wrong.setEnabled(false);
                reset.setVisibility(View.VISIBLE);

            } else {
                scoreView.setText(String.valueOf(score));
                colorView.setText(colorNames[i1]);
                colorView.setTextColor(colors[i2]);
            }

        } else if (i1 != i2) {
            wrongScore++;
            i1 = (r.nextInt(9) + 0);
            i2 = (r.nextInt(9) + 0);
            if (score + wrongScore == 9) {
                scoreView.setText(" ");
                colorView.setTextColor(Color.BLACK);
                colorView.setText("Game Over \n Your Score :" + String.valueOf(score));
                right.setEnabled(false);
                wrong.setEnabled(false);
                reset.setVisibility(View.VISIBLE);
            } else {
                colorView.setText(colorNames[i1]);
                colorView.setTextColor(colors[i2]);
            }
        }

    } // End of right Click


    //Wrong Click Function
    public void wrongClick(View view) {

        if (i1 != i2) {
            score++;
            i1 = (r.nextInt(9) + 0);
            i2 = (r.nextInt(9) + 0);
            if (score + wrongScore == 9) {
                scoreView.setText(" ");
                colorView.setTextColor(Color.BLACK);
                colorView.setText("Game Over \n Your Score :" + String.valueOf(score));
                right.setEnabled(false);
                wrong.setEnabled(false);
                reset.setVisibility(View.VISIBLE);

            } else {
                scoreView.setText(String.valueOf(score));
                colorView.setText(colorNames[i1]);
                colorView.setTextColor(colors[i2]);
            }

        } else if (i1 == i2) {
            wrongScore++;
            if (score + wrongScore == 9) {
                scoreView.setText(" ");
                colorView.setTextColor(Color.BLACK);
                colorView.setText("Game Over \n Your Score :" + String.valueOf(score));
                right.setEnabled(false);
                wrong.setEnabled(false);
                reset.setVisibility(View.VISIBLE);

            } else {
                i1 = (r.nextInt(9) + 0);
                i2 = (r.nextInt(9) + 0);
                colorView.setText(colorNames[i1]);
                colorView.setTextColor(colors[i2]);
            }
        }
    }//End of wrong Click


    //Reset function
    public  void resetFunc (View view)
{
    score = 0;
    wrongScore = 0;
    scoreView.setText(String.valueOf(score));
    i1 = (r.nextInt(9) + 0);
    i2 = (r.nextInt(9) + 0);
    colorView.setText(colorNames[i1]);
    colorView.setTextColor(colors[i2]);
reset.setVisibility(View.INVISIBLE );
    right.setEnabled(true);
    wrong.setEnabled(true);

}//End of Reset



}//End of Activity
