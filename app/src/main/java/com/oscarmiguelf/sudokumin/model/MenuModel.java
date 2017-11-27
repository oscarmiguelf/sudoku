package com.oscarmiguelf.sudokumin.model;

import android.content.Context;
import android.util.Log;

import com.oscarmiguelf.sudokumin.util.DataBaseHelper;
import com.oscarmiguelf.sudokumin.util.Grid;

import java.util.ArrayList;

public class MenuModel {
    private DataBaseHelper dataBaseHelper;

    public MenuModel(Context context) {
        dataBaseHelper = DataBaseHelper.getInstance(context);
    }

    public void deleteGrid(){
        dataBaseHelper.deleteGrid();
    }

    public Grid getSavedGrid() {
        if (getRawGrid() != null) {
            ArrayList<Grid.Cell> rawCell = getRawInlineGrid();
            Grid grid = Grid.of(getRawGrid());
            int aux = 0;
            int size = grid.getSize();
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    Grid.Cell cell = grid.getCell(row, column);
                    Log.d("row column", "" + row + " - " + column);
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

    private ArrayList<Grid.Cell> getRawInlineGrid() {
        return dataBaseHelper.getInlineGrid();
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
            Log.d("return ", "rawGrid"+ rawGrid[1][1]);
            return rawGrid;
        } else {
            Log.d("return ", "null");
            return null;
        }
    }

}
