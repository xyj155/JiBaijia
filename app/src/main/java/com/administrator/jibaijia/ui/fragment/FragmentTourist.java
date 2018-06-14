package com.administrator.jibaijia.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.BaseFragment;

/**
 * Created by Administrator on 2018/6/13.
 */

public class FragmentTourist extends BaseFragment {
    @Override
    protected int setView() {
        return R.layout.fragment_tourist;
    }

    @Override
    protected void init(View view) {
        setToolBarSubtitle("用户").setToolBarSubtitleColor(0xffffffff);
    }

    @Override
    protected void initDataMoulde() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

}
