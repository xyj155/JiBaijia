package com.administrator.jibaijia.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.ui.fragment.FragmentLoan;
import com.administrator.jibaijia.ui.fragment.FragmentMainPage;
import com.administrator.jibaijia.ui.fragment.FragmentTool;
import com.administrator.jibaijia.ui.fragment.FragmentTourist;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends AppCompatActivity {
    private FragmentMainPage fragment1;
    private FragmentLoan fragment2;
    private FragmentTool fragment3;
    private FragmentTourist fragment4;
    private static final int FRAGMENT_ONE = 0;
    private static final int FRAGMENT_TWO = 1;
    private static final int FRAGMENT_THREE = 2;
    public static final int SCAN_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = getSharedPreferences("interest", Context.MODE_PRIVATE).edit();
        editor.putInt("type",0);
        editor.apply();

        BottomNavigationBar bar = (BottomNavigationBar) findViewById(R.id.bottomBar);
        show(0);
        bar.addItem(new BottomNavigationItem(R.mipmap.ic_bottom_mainpage, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_loan, "贷款"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_tool, "工具"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_bottom_user, "我的"))
                .setMode(MODE_FIXED)
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        show(position);
                    }

                    @Override
                    public void onTabUnselected(int position) {

                    }

                    @Override
                    public void onTabReselected(int position) {

                    }
                })
                .initialise();
    }

    public void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case FRAGMENT_ONE:
                if (fragment1 == null) {
                    fragment1 = new FragmentMainPage();
                    ft.add(R.id.contentContainer, fragment1);
                } else {
                    ft.show(fragment1);
                }
                break;
            case FRAGMENT_TWO:
                if (fragment2 == null) {
                    fragment2 = new FragmentLoan();
                    ft.add(R.id.contentContainer, fragment2);
                } else {
                    ft.show(fragment2);
                }
                break;
            case FRAGMENT_THREE:
                if (fragment3 == null) {
                    fragment3 = new FragmentTool();
                    ft.add(R.id.contentContainer, fragment3);
                } else {
                    ft.show(fragment3);
                }
                break;
            case SCAN_CODE:
                if (fragment4 == null) {
                    fragment4 = new FragmentTourist();
                    ft.add(R.id.contentContainer, fragment4);
                } else {
                    ft.show(fragment4);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    /**
     * 闅愯棌Fragment
     *
     * @param ft
     */
    public void hideFragment(FragmentTransaction ft) {

        if (fragment1 != null) {
            ft.hide(fragment1);
        }
        if (fragment2 != null) {
            ft.hide(fragment2);
        }
        if (fragment3 != null) {
            ft.hide(fragment3);
        }
        if (fragment4 != null) {
            ft.hide(fragment4);
        }
    }

    private void show(int position) {
        switch (position) {
            case 0:
                showFragment(0);
                break;
            case 1:
                showFragment(1);
                break;
            case 2:
                showFragment(2);
                break;
            case 3:
                showFragment(3);
                break;
            default:
                break;
        }
    }

}
