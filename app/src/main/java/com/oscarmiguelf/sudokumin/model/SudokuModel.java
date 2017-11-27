package com.oscarmiguelf.sudokumin.model;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import com.oscarmiguelf.sudokumin.util.DataBaseHelper;
import com.oscarmiguelf.sudokumin.util.Generator;
import com.oscarmiguelf.sudokumin.util.Grid;

import java.util.ArrayList;

public class SudokuModel {

    private String level;
    private EditText editTextSelected;
    private DataBaseHelper dataBaseHelper;
    private int rowSelected;
    private int columnSelected;

    public SudokuModel(String level, Context context) {
        this.level = level;
        dataBaseHelper = DataBaseHelper.getInstance(context);
    }

    private Grid getInitGrid() {
        Generator generator = new Generator();
        Grid grid = generator.generate(getNumberOfEmptyCellsByLevel());
        saveGrid(grid);
        return grid;
    }


    public void saveGrid(Grid grid) {
        int size = grid.getSize();
        int aux = 0;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                aux++;
                Grid.Cell cell = grid.getCell(row, column);
                if (cell.isPermanent()) {
                    dataBaseHelper.saveCell(aux, String.valueOf(cell.getValue()), "P");
                } else {
                    dataBaseHelper.saveCell(aux, String.valueOf(cell.getValue()), "N");
                }

            }
        }
    }

    private Grid getSavedGrid() {
        if (getRawGrid() != null) {
            ArrayList<Grid.Cell> rawCell = getRawInlineGrid();
            Grid grid = Grid.of(getRawGrid());
            int aux = 0;
            int size = grid.getSize();
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    Grid.Cell cell = grid.getCell(row, column);
                    if (rawCell.get(aux).isPermanent()) {
                        cell.setPermanent(true);
                    } else {
                        cell.setPermanent(false);
                    }
                    aux++;
                }
            }
            return grid;

        } else {
            return null;
        }
    }

    private int[][] getRawGrid() {
        ArrayList<Grid.Cell> rawCell = getRawInlineGrid();
        int[][] rawGrid = new int[9][9];
        int aux = 0;
        int secondDigit = 0;
        if (rawCell.size() > 0) {
            for (Grid.Cell cell : rawCell) {
                if (aux < 9) {
                    rawGrid[0][secondDigit] = cell.getValue();
                    secondDigit++;
                } else if (aux < 18) {
                    rawGrid[1][secondDigit - 9] = cell.getValue();
                    secondDigit++;
                } else if (aux < 27) {
                    rawGrid[2][secondDigit - 18] = cell.getValue();
                    secondDigit++;
                } else if (aux < 36) {
                    rawGrid[3][secondDigit - 27] = cell.getValue();
                    secondDigit++;
                } else if (aux < 45) {
                    rawGrid[4][secondDigit - 36] = cell.getValue();
                    secondDigit++;
                } else if (aux < 54) {
                    rawGrid[5][secondDigit - 45] = cell.getValue();
                    secondDigit++;
                } else if (aux < 63) {
                    rawGrid[6][secondDigit - 54] = cell.getValue();
                    secondDigit++;
                } else if (aux < 72) {
                    rawGrid[7][secondDigit - 63] = cell.getValue();
                    secondDigit++;
                } else if (aux < 81) {
                    rawGrid[8][secondDigit - 72] = cell.getValue();
                    secondDigit++;
                }
                aux++;
            }
            Log.d("return ", "rawGrid" + rawGrid[1][1]);
            return rawGrid;
        } else {
            Log.d("return ", "null");
            return null;
        }
    }

    private ArrayList<Grid.Cell> getRawInlineGrid() {
        return dataBaseHelper.getInlineGrid();
    }

    public Grid getGrid() {
        Grid grid = getSavedGrid();
        if (grid != null) {
            return grid;
        } else {
            return getInitGrid();
        }
    }

    public int getNumberOfEmptyCellsByLevel() {
        switch (level) {
            case "easy":
                return 30;
            case "medium":
                return 35;
            case "hard":
                return 42;
            case "veryhard":
                return 52;
            default:
                return 10;
        }
    }

    public void setPosition(int row, int column){
        this.rowSelected = row;
        this.columnSelected = column;
    }

    public int getRowSelected(){
        return rowSelected;
    }

    public int getColumnSelected(){
        return columnSelected;
    }

    public void updateCell(int number, int position){
        dataBaseHelper.updateCell(number, position);
    }

    public String getLevel() {
        return level;
    }

    public EditText getEditTextSelected() {
        return editTextSelected;
    }

    public void setEditTextSelected(EditText editTextSelected) {
        this.editTextSelected = editTextSelected;
    }
}
