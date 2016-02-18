package com.example.user.scnariofirst;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_items);


        ItemAdapter adp = new ItemAdapter(this, getItemsList(), R.layout.item_list, (TextView) findViewById(R.id.txt_place4));
        recyclerView.setAdapter(adp);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // for horizontal
        linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //////View pager
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            return DemoFragment.newInstance(pos);

        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public static class DemoFragment extends Fragment {
        public static DemoFragment newInstance(int pos) {
            DemoFragment f = new DemoFragment();
            Bundle b = new Bundle();
            b.putInt("Pos", pos+1);
            f.setArguments(b);
            return f;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.layout_fragments, container, false);

            TextView txt_click = (TextView) v.findViewById(R.id.txt_click);
            txt_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast tost = Toast.makeText(getActivity(), "Fragment " + (getArguments().getInt("Pos")), Toast.LENGTH_LONG);
                    tost.setGravity(Gravity.CENTER, 0, 0);
                    tost.show();
                }
            });

            return v;
        }
    }

    public void onButtonClick(View v) {
        LinearLayout btn_container = (LinearLayout) findViewById(R.id.btn_container);
        switch (v.getId()) {
            case R.id.button1:
                btn_container.setBackgroundColor(Color.RED);
                break;
            case R.id.button2:
                btn_container.setBackgroundColor(Color.BLUE);
                break;
            case R.id.button3:
                btn_container.setBackgroundColor(Color.GREEN);
                break;
        }
    }

    private ArrayList<String> getItemsList() {
        ArrayList<String> ItemList = new ArrayList<>();
        ItemList.add("Item1");
        ItemList.add("Item2");
        ItemList.add("Item3");
        ItemList.add("Item4");
        ItemList.add("Item5");
        return ItemList;
    }

}
