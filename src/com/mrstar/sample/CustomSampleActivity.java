
package com.mrstar.sample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrstar.app.grid_activity.GridActivity;
import com.mrstar.grid_activity.R;

import java.util.ArrayList;
import java.util.List;

public class CustomSampleActivity extends GridActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom);

        List<Data> list = new ArrayList<CustomSampleActivity.Data>();
        for (int i = 0; i < 16; i++) {
            list.add(new Data(R.drawable.ic_launcher, String.format("No.%d", i)));
        }

        setListAdapter(new CustomAdapter(this, list));
    }

    private static class CustomAdapter extends ArrayAdapter<Data> {

        private final LayoutInflater mLayoutInflater;

        public CustomAdapter(Context context, List<Data> dataList) {
            super(context, R.layout.cell, dataList);
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.cell, null);
                viewHolder = new ViewHolder();
                viewHolder.mTextView = (TextView) convertView.findViewById(R.id.text_view);
                viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.image_view);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Data data = getItem(position);
            viewHolder.mImageView.setImageResource(data.getImageId());
            viewHolder.mTextView.setText(data.getName());

            return convertView;
        }

        public static class ViewHolder {
            ImageView mImageView;
            TextView mTextView;
        }
    }

    private static class Data {
        private final int mImageId;
        private final String mName;

        public Data(int imageId, String name) {
            mImageId = imageId;
            mName = name;
        }

        public int getImageId() {
            return mImageId;
        }

        public String getName() {
            return mName;
        }
    }

}
