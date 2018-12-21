package com.example.estephens.r6matchhistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class NewMatchFragment extends Fragment {

    private SQLCommands SQL;
    private EditText date;
    private Spinner map;
    private Spinner attackOps;
    private Spinner defendOps;
    private RadioButton win;
    private RadioButton loss;
    private EditText score;
    private EditText comments;
    private Button send;
    private RadioGroup radioGroup;
    private String dateString;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_match_fragment, null);
        SQL = new SQLCommands(getContext());

        date = view.findViewById(R.id.dateEditText);
        map = view.findViewById(R.id.mapSpinner);
        attackOps = view.findViewById(R.id.attackingOpsSpinner);
        defendOps = view.findViewById(R.id.defendingOpsSpinner);
        win = view.findViewById(R.id.winRadioButton);
        loss = view.findViewById(R.id.lossRadioButton);
        radioGroup = view.findViewById(R.id.WinLossRadioGroup);
        score = view.findViewById(R.id.scoreEditText);
        comments = view.findViewById(R.id.commentEditText);
        send = view.findViewById(R.id.saveButton);

        send.setOnClickListener(sendButtonOnClickListener);
        date.setOnEditorActionListener(dateListener);
        

        return view;
    }

    private Button.OnClickListener sendButtonOnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {

        }
    };

    private EditText.OnEditorActionListener dateListener = new EditText.OnEditorActionListener(){

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE){
               dateString = textView.getText().toString();
            }
            return false;
        }
    };
}
