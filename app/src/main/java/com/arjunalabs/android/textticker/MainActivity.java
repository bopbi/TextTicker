package com.arjunalabs.android.textticker;

import android.animation.Animator;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private LinearLayout container;
    private EditText editTextInput;
    private Button buttonPlay;
    private TextView runningText;
    int duration = 3 * 1000; // 3s

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);
        editTextInput = (EditText) findViewById(R.id.edit_input);
        buttonPlay = (Button) findViewById(R.id.button_play);
        runningText = (TextView) findViewById(R.id.text_running);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveText();
            }
        });
    }

    void moveText() {
        buttonPlay.setEnabled(false);
        runningText.setText(editTextInput.getText().toString());
        runningText.animate().translationX(container.getWidth()).setDuration(duration)
                .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                runningText.animate().x(0).setDuration(0);
                buttonPlay.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

}
