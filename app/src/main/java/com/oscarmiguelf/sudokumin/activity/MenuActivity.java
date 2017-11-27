package com.oscarmiguelf.sudokumin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.oscarmiguelf.sudokumin.R;
import com.oscarmiguelf.sudokumin.model.MenuModel;

public class MenuActivity extends AppCompatActivity {

    private Button btnEasy, btnMid, btnHard, btnVeryHard, btnContinue, btnNew;
    private String level;
    private FloatingActionButton startButton;
    private MenuModel model;
    private FrameLayout frameLayout;
    private FrameLayout frameLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        model = new MenuModel(this);
        btnEasy = findViewById(R.id.btnEasy);
        btnMid = findViewById(R.id.btnMid);
        btnHard = findViewById(R.id.btnHard);
        btnVeryHard = findViewById(R.id.btnVeryHard);
        btnContinue = findViewById(R.id.btnContinue);
        btnNew = findViewById(R.id.btnNew);
        startButton = findViewById(R.id.floatingActionButton);
        frameLayout = findViewById(R.id.frameLayout);
        frameLayout2 = findViewById(R.id.frameLayout2);
        addTouchListeners();
        putDefaultLevel();

    }

    public void putDefaultLevel() {
        setLevel("easy");
        changeStyleSelectedButton(btnEasy);
    }

    private void addTouchListeners() {

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSudoku();
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Borrar level
                model.deleteGrid();
                goToSudoku();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model.getSavedGrid() != null) {
                    frameLayout.setVisibility(View.GONE);
                    frameLayout2.setVisibility(View.VISIBLE);
                    startButton.setVisibility(View.GONE);

                } else {
                    goToSudoku();
                }
            }
        });
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLevel("easy");
                changeStyleSelectedButton(view);
            }
        });

        btnMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLevel("medium");
                changeStyleSelectedButton(view);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLevel("hard");
                changeStyleSelectedButton(view);
            }
        });

        btnVeryHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLevel("veryhard");
                changeStyleSelectedButton(view);
            }
        });
    }


    private void goToSudoku() {
        Intent intent = new Intent(MenuActivity.this, SudokuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("level", getLevel());
        startActivity(intent);
    }

    private void setLevel(String level) {
        this.level = level;
    }

    private String getLevel() {
        return level;
    }

    private void changeStyleSelectedButton(View view) {
        resetFontSizeButtons();
        ((Button) view).setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50f);
    }

    private void resetFontSizeButtons() {
        btnEasy.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
        btnHard.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
        btnMid.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
        btnVeryHard.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30f);
    }
}
