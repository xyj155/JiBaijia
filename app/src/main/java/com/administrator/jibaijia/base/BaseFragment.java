package com.administrator.jibaijia.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.baseactivity.OnClickListener;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



/**
 * Created by Adaministrator on 2018/4/13.
 */

public abstract class BaseFragment extends Fragment {
    private RequestQueue mQueue;
    private Toolbar toolbar;

    protected abstract int setView();

    protected abstract void init(View view);
    protected abstract void initDataMoulde();

    protected abstract void initData(Bundle savedInstanceState);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(setView(), container, false);
        toolbar = view.findViewById(R.id.toolbar);
        mQueue = Volley.newRequestQueue(getActivity());
        return view;
    }

    public BaseFragment addQueue(Request queue) {
        mQueue.add(queue);
        return this;
    }

    public BaseFragment setToolBarTitle(String title) {
        toolbar.setTitle(title);
        return this;
    }

    public BaseFragment setToolBarBackIco(int ico) {
        toolbar.setNavigationIcon(ico);
        return this;
    }

    public BaseFragment setToolBarSubtitle(String title) {
        toolbar.setSubtitle(title);
        return this;
    }

    public BaseFragment setToolBarSubtitleColor(int title) {
        toolbar.setSubtitleTextColor(title);
        return this;
    }

    public BaseFragment setToolBartitleColor(int title) {
        toolbar.setTitleTextColor(title);
        return this;
    }

    public BaseFragment setToolBarOnClick(final OnClickListener click) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.OnClick();
            }
        });
        return this;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        initDataMoulde();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

}