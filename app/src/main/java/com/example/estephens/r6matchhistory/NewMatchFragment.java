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
    private EditText score;
    private EditText comments;
    private Button send;
    private RadioGroup radioGroup;
    private EditText playerScore;
    private DatabaseItem item;
    String[] attArray;
    String[] defArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_match_fragment, null);
        SQL = new SQLCommands(getContext());
        item = new DatabaseItem();

        attArray = getResources().getStringArray(R.array.Attacking_Operators_array);
        defArray = getResources().getStringArray(R.array.Defending_Operators_array);

        date = view.findViewById(R.id.dateEditText);
        map = view.findViewById(R.id.mapSpinner);
        attackOps = view.findViewById(R.id.attackingOpsSpinner);
        defendOps = view.findViewById(R.id.defendingOpsSpinner);
        radioGroup = view.findViewById(R.id.WinLossRadioGroup);
        score = view.findViewById(R.id.scoreEditText);
        comments = view.findViewById(R.id.commentEditText);
        send = view.findViewById(R.id.saveButton);
        playerScore = view.findViewById(R.id.playerScoreEditText);

        send.setOnClickListener(sendButtonOnClickListener);
        date.setOnEditorActionListener(dateListener);
        playerScore.setOnEditorActionListener(playerScoreListener);
        radioGroup.setOnCheckedChangeListener(radioGroupListener);
        score.setOnEditorActionListener(scoreListener);
        comments.setOnEditorActionListener(commentsListener);

        return view;
    }

    private Button.OnClickListener sendButtonOnClickListener = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            SQL.insert(item);
        }
    };

    private EditText.OnEditorActionListener dateListener = new EditText.OnEditorActionListener(){

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE){
               item.setDate(textView.getText().toString());
               return true;
            }
            return false;
        }
    };

    private EditText.OnEditorActionListener playerScoreListener = new EditText.OnEditorActionListener(){

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE){
                item.setPlayerScore(textView.getText().toString());
                return true;
            }
            return false;
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.winRadioButton)
                item.setwinLoss(true);
            else
                item.setwinLoss(false);
        }
    };

    private EditText.OnEditorActionListener scoreListener = new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE){
                item.setScore(textView.getText().toString());
                return true;
            }
            return false;

        }
    };

    private EditText.OnEditorActionListener commentsListener = new EditText.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE){
                item.setComments(textView.getText().toString());
                return true;
            }
            return false;
        }
    };
}
