
package com.mrstar.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.mrstar.app.grid_activity.GridActivity;

import java.util.ArrayList;
import java.util.List;

public class SimpleSampleActivity extends GridActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 16; i++) {
            list.add(String.format("No.%d", i));
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        setListAdapter(arrayAdapter);

        getGridView().setNumColumns(4);
    }

    @Override
    protected void onGridItemClick(GridView gridView, View view, int position, long id) {
        super.onGridItemClick(gridView, view, position, id);

        String item = (String) gridView.getItemAtPosition(position);

        String messae = String.format("clicked item : %s ", item);

        Toast.makeText(this, messae, Toast.LENGTH_SHORT).show();
    }
}
