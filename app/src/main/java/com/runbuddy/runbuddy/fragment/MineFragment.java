package com.runbuddy.runbuddy.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.runbuddy.runbuddy.R;

/**
 * Created by Jonney Chou on 2016/7/11.
 */
public class MineFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, null);
        return view;


/*        if (getArguments() != null)
        {
            mTitle = getArguments().getString(TITLE);
        }

        TextView tv = new TextView(getActivity());
        tv.setTextSize(20);
        tv.setBackgroundColor(Color.parseColor("#ffffffff"));
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);
        return tv;
    */
    }

    /*
    * 设置actionBar的style
    * */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        setHasOptionsMenu(true);
        menu.clear();
        //setHasOptionsMenu(true);
        inflater.inflate(R.menu.mine,menu);
    }

    @Override
    public void onClick(View view) {

    }
}
