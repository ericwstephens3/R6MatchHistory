package com.example.estephens.r6matchhistory;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class matchHistoryAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList<DatabaseItem> items;
    private Holder holder;
    private View row;
    private int pos;

    public matchHistoryAdapter(Context context, final int layoutResourceId, ArrayList<DatabaseItem> items) {
        super(context, layoutResourceId);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        row = convertView;

        pos = position;
        if (row == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.map =  row.findViewById(R.id.map);
            holder.date = row.findViewById(R.id.date);
            holder.winLoss = row.findViewById(R.id.winLoss);
            holder.edit = row.findViewById(R.id.editButton);
            holder.map.setTag(items.get(pos).getId());
            holder.date.setTag(items.get(pos).getId());
            holder.winLoss.setTag(items.get(pos).getId());
            holder.edit.setTag(items.get(pos).getId());
            row.setTag(holder);
        }

        else
        {
            holder = (Holder) row.getTag();
        }

        holder.map.setText(items.get(pos).getMapName());
        holder.date.setText(items.get(pos).getDate());

        boolean winLoss = items.get(pos).getWinLoss();

        if (winLoss){
            holder.winLoss.setText("Win");
            holder.winLoss.setTextColor(Color.GREEN);
        }
        else{
            holder.winLoss.setText("Loss");
            holder.winLoss.setTextColor(Color.RED);
        }

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO IMPLEMENT
            }
        });

        return row;
    }

    private class Holder {
        TextView map;
        TextView date;
        TextView winLoss;
        Button edit;
    }
}
