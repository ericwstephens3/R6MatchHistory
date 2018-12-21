package com.example.estephens.r6matchhistory;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MatchHistoryFragment extends Fragment {

    private SQLCommands SQL;
    private ListView listView;
    private int maxID;
    private int usedID = 0;
    private ArrayAdapter<String> adapter;
    private CursorParser parser;
    private ArrayList<DatabaseItem> items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.match_history_fragment, null);
        Button nextButton = view.findViewById(R.id.nextButton);
        Button prevButton = view.findViewById(R.id.backButton);
        SQL = new SQLCommands(getContext());
        maxID = SQL.getLastID().getInt(0);
        usedID = maxID;
        parser = new CursorParser(SQL.getSearchByID(maxID));
        items = parser.getDatabaseItems();
        adapter = new matchHistoryAdapter(getContext(), R.layout.match_history_list_adapter, items);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usedID = usedID - 10;
                if (usedID < 0){
                    usedID = 0;
                }
                parser = new CursorParser(SQL.getSearchByID(usedID));
                items = parser.getDatabaseItems();
                adapter.notifyDataSetChanged();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usedID = usedID + 10;
                if (usedID > maxID){
                    usedID = maxID;
                }
                parser = new CursorParser(SQL.getSearchByID(usedID));
                items = parser.getDatabaseItems();
                adapter.notifyDataSetChanged();

            }
        });


        listView = view.findViewById(R.id.ListView);
        listView.setAdapter(adapter);
        return view;
    }
}
