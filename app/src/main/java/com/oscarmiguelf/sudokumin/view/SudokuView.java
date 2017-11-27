package com.oscarmiguelf.sudokumin.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.oscarmiguelf.sudokumin.R;
import com.oscarmiguelf.sudokumin.activity.SudokuActivity;
import com.oscarmiguelf.sudokumin.presenter.SudokuPresenter;
import com.oscarmiguelf.sudokumin.util.Grid;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SudokuView {

    private EditText txt11, txt12, txt13, txt14, txt15, txt16, txt17, txt18, txt19;
    private EditText txt21, txt22, txt23, txt24, txt25, txt26, txt27, txt28, txt29;
    private EditText txt31, txt32, txt33, txt34, txt35, txt36, txt37, txt38, txt39;
    private EditText txt41, txt42, txt43, txt44, txt45, txt46, txt47, txt48, txt49;
    private EditText txt51, txt52, txt53, txt54, txt55, txt56, txt57, txt58, txt59;
    private EditText txt61, txt62, txt63, txt64, txt65, txt66, txt67, txt68, txt69;
    private EditText txt71, txt72, txt73, txt74, txt75, txt76, txt77, txt78, txt79;
    private EditText txt81, txt82, txt83, txt84, txt85, txt86, txt87, txt88, txt89;
    private EditText txt91, txt92, txt93, txt94, txt95, txt96, txt97, txt98, txt99;

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;

    private List<List<EditText>> editTextList = new ArrayList<>();

    private SudokuActivity activity;
    private WeakReference<SudokuActivity> weakReferenceActivity;

    private Grid grid;

    public SudokuView(SudokuActivity activity) {
        this.weakReferenceActivity = new WeakReference<>(activity);
        this.activity = weakReferenceActivity.get();
    }

    public void init() {

        btnOne = activity.findViewById(R.id.btnOne);
        btnTwo = activity.findViewById(R.id.btnTwo);
        btnThree = activity.findViewById(R.id.btnThree);
        btnFour = activity.findViewById(R.id.btnFour);
        btnFive = activity.findViewById(R.id.btnFive);
        btnSix = activity.findViewById(R.id.btnSix);
        btnSeven = activity.findViewById(R.id.btnSeven);
        btnEight = activity.findViewById(R.id.btnEight);
        btnNine = activity.findViewById(R.id.btnNine);

        txt11 = activity.findViewById(R.id.txt11);
        txt12 = activity.findViewById(R.id.txt12);
        txt13 = activity.findViewById(R.id.txt13);
        txt14 = activity.findViewById(R.id.txt14);
        txt15 = activity.findViewById(R.id.txt15);
        txt16 = activity.findViewById(R.id.txt16);
        txt17 = activity.findViewById(R.id.txt17);
        txt18 = activity.findViewById(R.id.txt18);
        txt19 = activity.findViewById(R.id.txt19);

        ArrayList list1 = new ArrayList();
        list1.add(txt11);
        list1.add(txt12);
        list1.add(txt13);
        list1.add(txt14);
        list1.add(txt15);
        list1.add(txt16);
        list1.add(txt17);
        list1.add(txt18);
        list1.add(txt19);

        editTextList.add(list1);

        txt21 = activity.findViewById(R.id.txt21);
        txt22 = activity.findViewById(R.id.txt22);
        txt23 = activity.findViewById(R.id.txt23);
        txt24 = activity.findViewById(R.id.txt24);
        txt25 = activity.findViewById(R.id.txt25);
        txt26 = activity.findViewById(R.id.txt26);
        txt27 = activity.findViewById(R.id.txt27);
        txt28 = activity.findViewById(R.id.txt28);
        txt29 = activity.findViewById(R.id.txt29);

        ArrayList list2 = new ArrayList();
        list2.add(txt21);
        list2.add(txt22);
        list2.add(txt23);
        list2.add(txt24);
        list2.add(txt25);
        list2.add(txt26);
        list2.add(txt27);
        list2.add(txt28);
        list2.add(txt29);

        editTextList.add(list2);

        txt31 = activity.findViewById(R.id.txt31);
        txt32 = activity.findViewById(R.id.txt32);
        txt33 = activity.findViewById(R.id.txt33);
        txt34 = activity.findViewById(R.id.txt34);
        txt35 = activity.findViewById(R.id.txt35);
        txt36 = activity.findViewById(R.id.txt36);
        txt37 = activity.findViewById(R.id.txt37);
        txt38 = activity.findViewById(R.id.txt38);
        txt39 = activity.findViewById(R.id.txt39);

        ArrayList list3 = new ArrayList();
        list3.add(txt31);
        list3.add(txt32);
        list3.add(txt33);
        list3.add(txt34);
        list3.add(txt35);
        list3.add(txt36);
        list3.add(txt37);
        list3.add(txt38);
        list3.add(txt39);

        editTextList.add(list3);

        txt41 = activity.findViewById(R.id.txt41);
        txt42 = activity.findViewById(R.id.txt42);
        txt43 = activity.findViewById(R.id.txt43);
        txt44 = activity.findViewById(R.id.txt44);
        txt45 = activity.findViewById(R.id.txt45);
        txt46 = activity.findViewById(R.id.txt46);
        txt47 = activity.findViewById(R.id.txt47);
        txt48 = activity.findViewById(R.id.txt48);
        txt49 = activity.findViewById(R.id.txt49);

        ArrayList list4 = new ArrayList();
        list4.add(txt41);
        list4.add(txt42);
        list4.add(txt43);
        list4.add(txt44);
        list4.add(txt45);
        list4.add(txt46);
        list4.add(txt47);
        list4.add(txt48);
        list4.add(txt49);

        editTextList.add(list4);

        txt51 = activity.findViewById(R.id.txt51);
        txt52 = activity.findViewById(R.id.txt52);
        txt53 = activity.findViewById(R.id.txt53);
        txt54 = activity.findViewById(R.id.txt54);
        txt55 = activity.findViewById(R.id.txt55);
        txt56 = activity.findViewById(R.id.txt56);
        txt57 = activity.findViewById(R.id.txt57);
        txt58 = activity.findViewById(R.id.txt58);
        txt59 = activity.findViewById(R.id.txt59);

        ArrayList list5 = new ArrayList();
        list5.add(txt51);
        list5.add(txt52);
        list5.add(txt53);
        list5.add(txt54);
        list5.add(txt55);
        list5.add(txt56);
        list5.add(txt57);
        list5.add(txt58);
        list5.add(txt59);

        editTextList.add(list5);

        txt61 = activity.findViewById(R.id.txt61);
        txt62 = activity.findViewById(R.id.txt62);
        txt63 = activity.findViewById(R.id.txt63);
        txt64 = activity.findViewById(R.id.txt64);
        txt65 = activity.findViewById(R.id.txt65);
        txt66 = activity.findViewById(R.id.txt66);
        txt67 = activity.findViewById(R.id.txt67);
        txt68 = activity.findViewById(R.id.txt68);
        txt69 = activity.findViewById(R.id.txt69);

        ArrayList list6 = new ArrayList();
        list6.add(txt61);
        list6.add(txt62);
        list6.add(txt63);
        list6.add(txt64);
        list6.add(txt65);
        list6.add(txt66);
        list6.add(txt67);
        list6.add(txt68);
        list6.add(txt69);

        editTextList.add(list6);

        txt71 = activity.findViewById(R.id.txt71);
        txt72 = activity.findViewById(R.id.txt72);
        txt73 = activity.findViewById(R.id.txt73);
        txt74 = activity.findViewById(R.id.txt74);
        txt75 = activity.findViewById(R.id.txt75);
        txt76 = activity.findViewById(R.id.txt76);
        txt77 = activity.findViewById(R.id.txt77);
        txt78 = activity.findViewById(R.id.txt78);
        txt79 = activity.findViewById(R.id.txt79);

        ArrayList list7 = new ArrayList();
        list7.add(txt71);
        list7.add(txt72);
        list7.add(txt73);
        list7.add(txt74);
        list7.add(txt75);
        list7.add(txt76);
        list7.add(txt77);
        list7.add(txt78);
        list7.add(txt79);

        editTextList.add(list7);

        txt81 = activity.findViewById(R.id.txt81);
        txt82 = activity.findViewById(R.id.txt82);
        txt83 = activity.findViewById(R.id.txt83);
        txt84 = activity.findViewById(R.id.txt84);
        txt85 = activity.findViewById(R.id.txt85);
        txt86 = activity.findViewById(R.id.txt86);
        txt87 = activity.findViewById(R.id.txt87);
        txt88 = activity.findViewById(R.id.txt88);
        txt89 = activity.findViewById(R.id.txt89);

        ArrayList list8 = new ArrayList();
        list8.add(txt81);
        list8.add(txt82);
        list8.add(txt83);
        list8.add(txt84);
        list8.add(txt85);
        list8.add(txt86);
        list8.add(txt87);
        list8.add(txt88);
        list8.add(txt89);

        editTextList.add(list8);

        txt91 = activity.findViewById(R.id.txt91);
        txt92 = activity.findViewById(R.id.txt92);
        txt93 = activity.findViewById(R.id.txt93);
        txt94 = activity.findViewById(R.id.txt94);
        txt95 = activity.findViewById(R.id.txt95);
        txt96 = activity.findViewById(R.id.txt96);
        txt97 = activity.findViewById(R.id.txt97);
        txt98 = activity.findViewById(R.id.txt98);
        txt99 = activity.findViewById(R.id.txt99);

        ArrayList list9 = new ArrayList();
        list9.add(txt91);
        list9.add(txt92);
        list9.add(txt93);
        list9.add(txt94);
        list9.add(txt95);
        list9.add(txt96);
        list9.add(txt97);
        list9.add(txt98);
        list9.add(txt99);

        editTextList.add(list9);

        addListeners();
    }

    public void addListeners() {
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performNumberClick("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performNumberClick("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("3");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                performNumberClick("9");
            }
        });
    }

    private void performNumberClick(String number) {
        if (getPresenter().getEditTextSelected() != null) {
            getPresenter().getEditTextSelected().setText(number);
            getPresenter().setPositionEditTextSelected(editTextList);
            getPresenter().updateCell(Integer.parseInt(number));
            verify();
        }
    }

    private void verify() {
        int row = getPresenter().getRowSelected();
        int column = getPresenter().getColumnSelected();
        boolean isInRow = verifyByRow(row);
        boolean isInColumn = verifyByColumn(column);

        if (isInRow || isInColumn) {
            getPresenter().getEditTextSelected().setTextColor(getActivity().getResources().getColor(R.color.colorAccent));
        } else {
            getPresenter().getEditTextSelected().setTextColor(getActivity().getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private boolean verifyByColumn(int column) {
        int value = Integer.parseInt(getPresenter().getEditTextSelected().getText().toString());
        for (int row = 0; row < 9; row++) {
            if (column != getPresenter().getColumnSelected()) {
                int auxValue = grid.getCell(row, column).getValue();
                if (auxValue == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyByRow(int row) {
        int value = Integer.parseInt(getPresenter().getEditTextSelected().getText().toString());
        for (int column = 0; row < 9; row++) {
            if (row != getPresenter().getRowSelected()) {
                int auxValue = grid.getCell(row, column).getValue();
                if (auxValue == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public void drawGrid(Grid grid) {
        this.grid = grid;
        int size = grid.getSize();
        ArrayList<EditText> auxList;
        for (int row = 0; row < size; row++) {
            auxList = (ArrayList) editTextList.get(row);
            for (int column = 0; column < size; column++) {
                Grid.Cell cell = grid.getCell(row, column);
                String text = cell.getValue() != 0 ? String.valueOf(cell.getValue()) : "";
                if (cell.isPermanent()) {
                    auxList.get(column).setClickable(false);
                    auxList.get(column).setCursorVisible(false);
                    auxList.get(column).setFocusable(false);
                    auxList.get(column).setFocusableInTouchMode(false);
                } else {
                    auxList.get(column).setTextColor(activity.getResources().getColor(R.color.colorPrimaryDark));
                    auxList.get(column).setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            noColorEditText();
                            view.setBackground(activity.getResources().getDrawable(R.drawable.squared_box_gray));
                            getPresenter().setEditTextSelected((EditText) view);
                            return true;
                        }
                    });

                }
                auxList.get(column).setText(text);
            }
        }
    }

    private void noColorEditText() {
        int size = 9;
        ArrayList<EditText> auxList;
        for (int row = 0; row < size; row++) {
            auxList = (ArrayList) editTextList.get(row);
            for (int column = 0; column < size; column++) {
                auxList.get(column).setBackground(activity.getResources().getDrawable(R.drawable.squared_box));
            }
        }
    }

    public void setLevelName(String levelName) {

    }

    public SudokuActivity getActivity() {
        return activity;
    }

    public SudokuPresenter getPresenter() {
        return getActivity().getPresenter();
    }
}
