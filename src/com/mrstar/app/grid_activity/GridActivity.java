
package com.mrstar.app.grid_activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.mrstar.grid_activity.R;

public class GridActivity extends Activity {

    protected ListAdapter mAdapter;

    protected GridView mGrid;

    private Handler mHandler = new Handler();
    private boolean mFinishedStart = false;
    private Runnable mRequestFocus = new Runnable() {
        public void run() {
            mGrid.focusableViewAvailable(mGrid);
        }
    };

    private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            onGridItemClick((GridView) parent, view, position, id);
        }
    };

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        View emptyView = findViewById(R.id.empty);
        mGrid = (GridView) findViewById(R.id.grid);
        if (mGrid == null) {
            throw new RuntimeException(
                    "Your content must have a GridView whose id attribute is " +
                            "'R.id.grid'");
        }
        if (emptyView != null) {
            mGrid.setEmptyView(emptyView);
        }
        mGrid.setOnItemClickListener(mOnClickListener);

        if (mFinishedStart) {
            setListAdapter(mAdapter);
        }
        mHandler.post(mRequestFocus);
        mFinishedStart = true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ensureGrid();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mRequestFocus);
        super.onDestroy();
    }

    public void setListAdapter(ListAdapter adapter) {
        synchronized (this) {
            ensureGrid();
            mAdapter = adapter;
            mGrid.setAdapter(adapter);
        }
    }

    public void setSelection(int position) {
        mGrid.setSelection(position);
    }

    public int getSelectedItemPosition() {
        return mGrid.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        return mGrid.getSelectedItemId();
    }

    public GridView getGridView() {
        ensureGrid();
        return mGrid;
    }

    public ListAdapter getListAdapter() {
        return mAdapter;
    }

    protected void onGridItemClick(GridView gridView, View view, int position, long id) {
    }

    private void ensureGrid() {
        if (mGrid != null) {
            return;
        }
        setContentView(R.layout.activity_grid);
    }
}
