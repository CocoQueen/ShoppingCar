package com.example.coco.shoppingcar.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.coco.shoppingcar.MainActivity;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by coco on 2017/11/13.
 */

public class MyGroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<MainActivity.ShuJu> data;
    private MainActivity activity;
    private List<MainActivity.Head> head;

    public MyGroupAdapter(List<MainActivity.ShuJu> data, MainActivity activity, List<MainActivity.Head> head) {
        this.data = data;
        this.activity = activity;
        this.head = head;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(activity);
        tv.setText(data.get(position).info);
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        return tv;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        MainActivity.ShuJu shuJu = data.get(position);
        MainActivity.Head head = this.head.get(shuJu.headIndex);
        TextView mTv = new TextView(activity);
        mTv.setText(head.info);
        mTv.setBackgroundColor(Color.GREEN);
        return mTv;
    }

    @Override
    public long getHeaderId(int position) {
        int headId = data.get(position).headId;
        return headId;
    }
}
