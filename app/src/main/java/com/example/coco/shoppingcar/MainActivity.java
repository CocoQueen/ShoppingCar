package com.example.coco.shoppingcar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.coco.shoppingcar.adapter.MyGroupAdapter;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    private StickyListHeadersListView mLv_right;
    private List<ShuJu> data = new ArrayList<>();
    private List<Head> heads = new ArrayList<>();
//    private ListView mLv_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLv_right = findViewById(R.id.mLv_right);
//        mLv_left = findViewById(R.id.mLv_left);
        initDate();//初始化数据
        mLv_right.setAdapter(new MyGroupAdapter(data, this, heads));//设置适配器

    }

    private void initDate() {
        for (int i = 0; i < 9; i++) {
            Head head = new Head();
            head.info="头："+i;
            heads.add(head);
        }
        for (int i = 0; i < heads.size(); i++) {//嵌套使得数据同步
            for (int j = 0; j < 10; j++) {
                ShuJu shuJu = new ShuJu();
                shuJu.headId=i;
                shuJu.info="条目："+i+"条目数："+j;
                shuJu.headIndex=i;
                data.add(shuJu);
            }
        }
    }

    public class ShuJu {
        public String info;
        public int headId;
        public int headIndex;
    }

    public class Head {
        public String info;
    }
}
