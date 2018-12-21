package com.example.estephens.r6matchhistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewMatchFragment extends Fragment {

    private SQLCommands SQL;
    private int max_ID = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SQL = new SQLCommands(getContext());
        max_ID = SQL.getLastID().getInt(0);
        return inflater.inflate(R.layout.new_match_fragment, null);
    }
}
