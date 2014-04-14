package com.imbryk.viewPager.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.imbryk.viewPager.LoopViewPager;
import com.imbryk.viewPager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzl on 14-4-6.
 */
public class SampleActivity extends Activity {
    LoopViewPager mVP;
    List<Integer> datas = new ArrayList<Integer>();
    SamplePagerAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        findView();
        initView();
    }

    private void initView() {
        initData();
        adapter = new SamplePagerAdapter();
        mVP.setAdapter(adapter);
    }

    private void initData() {
        resetDatas(2);
    }

    private void findView() {
        mVP = (LoopViewPager) findViewById(R.id.loop);
    }

    private void resetDatas(int count) {
        datas.clear();
        for (int i = 0; i < count; i++) {
            datas.add(i);
        }
    }

    public void onClickEvent0(View v) {
//        resetDatas(0);
//        adapter.notifyDataSetChanged();
        resetDatas(0);
        adapter = new SamplePagerAdapter();
        mVP.setAdapter(adapter);
    }

    public void onClickEvent1(View v) {
        resetDatas(1);
        adapter.notifyDataSetChanged();
    }

    public void onClickEvent2(View v) {
        resetDatas(2);
        adapter.notifyDataSetChanged();
    }

    public void onClickEvent3(View v) {
        resetDatas(3);
        adapter = new SamplePagerAdapter();
        mVP.setAdapter(adapter);
    }


    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(container.getContext());
            tv.setText(datas.get(position) + "");
            container.addView(tv, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }


    }


}