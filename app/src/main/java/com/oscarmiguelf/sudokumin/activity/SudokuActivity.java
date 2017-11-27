package com.oscarmiguelf.sudokumin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.oscarmiguelf.sudokumin.R;
import com.oscarmiguelf.sudokumin.model.SudokuModel;
import com.oscarmiguelf.sudokumin.presenter.SudokuPresenter;
import com.oscarmiguelf.sudokumin.view.SudokuView;

public class SudokuActivity extends AppCompatActivity {

    private SudokuPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        String level = getIntent().getExtras().getString("level");
        Log.d("level", level);
        presenter = new SudokuPresenter(new SudokuModel(level,  this), new SudokuView(this));
        presenter.init();

    }

    public SudokuPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
