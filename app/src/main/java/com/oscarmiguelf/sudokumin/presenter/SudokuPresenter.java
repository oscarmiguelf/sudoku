package com.oscarmiguelf.sudokumin.presenter;

import android.util.Log;
import android.widget.EditText;

import com.oscarmiguelf.sudokumin.model.SudokuModel;
import com.oscarmiguelf.sudokumin.util.Grid;
import com.oscarmiguelf.sudokumin.view.SudokuView;

import java.util.ArrayList;
import java.util.List;

public class SudokuPresenter {

    private SudokuModel model;
    private SudokuView view;
    private Grid grid;

    public SudokuPresenter(SudokuModel model, SudokuView view) {
        this.model = model;
        this.view = view;
    }

    public void init() {
        Log.d("ini", "ini");
        view.init();
        view.setLevelName(model.getLevel());
        grid = model.getGrid();
        view.drawGrid(grid);
    }

    public void updateCell(int number) {
        int position = getPositionDBByColumnRow();
        model.updateCell(number, position);
    }

    public int getColumnSelected() {
        return model.getColumnSelected();
    }


    public int getRowSelected() {
        return model.getRowSelected();
    }

    private int getPositionDBByColumnRow() {
        int column = model.getColumnSelected();
        int row = model.getRowSelected();
        if (row == 0) {
            switch (column) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
                case 5:
                    return 6;
                case 6:
                    return 7;
                case 7:
                    return 8;
                case 8:
                    return 9;
                default:
                    return 0;
            }

        }
        if (row == 1) {
            switch (column) {
                case 0:
                    return 10;
                case 1:
                    return 11;
                case 2:
                    return 12;
                case 3:
                    return 13;
                case 4:
                    return 14;
                case 5:
                    return 15;
                case 6:
                    return 16;
                case 7:
                    return 17;
                case 8:
                    return 18;
                default:
                    return 0;
            }
        }
        if (row == 2) {
            switch (column) {
                case 0:
                    return 19;
                case 1:
                    return 20;
                case 2:
                    return 21;
                case 3:
                    return 22;
                case 4:
                    return 23;
                case 5:
                    return 24;
                case 6:
                    return 25;
                case 7:
                    return 26;
                case 8:
                    return 27;
                default:
                    return 0;
            }
        }
        if (row == 3) {
            switch (column) {
                case 0:
                    return 28;
                case 1:
                    return 29;
                case 2:
                    return 30;
                case 3:
                    return 31;
                case 4:
                    return 32;
                case 5:
                    return 33;
                case 6:
                    return 34;
                case 7:
                    return 35;
                case 8:
                    return 36;
                default:
                    return 0;
            }
        }
        if (row == 4) {
            switch (column) {
                case 0:
                    return 37;
                case 1:
                    return 38;
                case 2:
                    return 38;
                case 3:
                    return 40;
                case 4:
                    return 41;
                case 5:
                    return 42;
                case 6:
                    return 43;
                case 7:
                    return 44;
                case 8:
                    return 45;
                default:
                    return 0;
            }
        }
        if (row == 5) {
            switch (column) {
                case 0:
                    return 46;
                case 1:
                    return 47;
                case 2:
                    return 48;
                case 3:
                    return 49;
                case 4:
                    return 50;
                case 5:
                    return 51;
                case 6:
                    return 52;
                case 7:
                    return 53;
                case 8:
                    return 54;
                default:
                    return 0;
            }
        }
        if (row == 6) {
            switch (column) {
                case 0:
                    return 55;
                case 1:
                    return 56;
                case 2:
                    return 57;
                case 3:
                    return 58;
                case 4:
                    return 59;
                case 5:
                    return 60;
                case 6:
                    return 61;
                case 7:
                    return 62;
                case 8:
                    return 63;
                default:
                    return 0;
            }
        }
        if (row == 7) {
            switch (column) {
                case 0:
                    return 64;
                case 1:
                    return 65;
                case 2:
                    return 66;
                case 3:
                    return 67;
                case 4:
                    return 68;
                case 5:
                    return 69;
                case 6:
                    return 70;
                case 7:
                    return 71;
                case 8:
                    return 72;
                default:
                    return 0;
            }
        }
        if (row == 8) {
            switch (column) {
                case 0:
                    return 73;
                case 1:
                    return 74;
                case 2:
                    return 75;
                case 3:
                    return 76;
                case 4:
                    return 77;
                case 5:
                    return 78;
                case 6:
                    return 79;
                case 7:
                    return 80;
                case 8:
                    return 81;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public void setEditTextSelected(EditText editTextSelected) {

        editTextSelected.getId();
        model.setEditTextSelected(editTextSelected);
    }

    public void setPositionEditTextSelected(List<List<EditText>> editTextList) {

        int id = getEditTextSelected().getId();

        ArrayList<EditText> auxList;
        for (int row = 0; row < 9; row++) {
            auxList = (ArrayList) editTextList.get(row);
            for (int column = 0; column < 9; column++) {
                if (auxList.get(column).getId() == id) {
                    model.setPosition(row, column);
                }
            }
        }
    }

    public EditText getEditTextSelected() {
        return model.getEditTextSelected();
    }

}
