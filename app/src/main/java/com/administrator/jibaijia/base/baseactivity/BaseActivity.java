package com.administrator.jibaijia.base.baseactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.administrator.jibaijia.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



/**
 * Created by Adaministrator on 2018/4/11.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public static final String ACTION_NETWORK_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static final String ACTION_PUSH_DATA = "fm.data.push.action";
    public static final String ACTION_NEW_VERSION = "apk.update.action";
    protected static UIHandler handler = new UIHandler(Looper.getMainLooper());
    private RequestQueue mQueue;
    private SwipeRefreshLayout swipeRefreshLayout;

    public BaseActivity() {

    }

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBase();
        setHandler();
        initContentView(savedInstanceState);
        initView();
        initListner();
        mQueue = Volley.newRequestQueue(getApplicationContext());

    }

    /**
     * Volley队列添加
     * @param t
     * @return
     */
    public BaseActivity addQueen(Request t){
        mQueue.add(t);
        return this;
    }

    /**
     * 初始化SwipRefreshLayout
     * @param id
     * @return
     */
    public BaseActivity InitRefreshLayout(int id) {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(id);
        return this;
    }

    /**
     * 刷新回调
     */
    public interface RefreshClallBack {
        void Refresh();
    }

    /**
     * 实现刷新
     * @param minute
     * @param refresh
     * @return
     */
    public BaseActivity setRefreshListener(final long minute, final RefreshClallBack refresh) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.Refresh();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, minute);
            }
        });
        return this;
    }

    /**
     * 初始化Toolbar
     * @return
     */
       public BaseActivity InitToolbarView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        return this;
    }

    /**
     * 设置toolbar副标题
     * @param title
     * @return
     */
    public BaseActivity setNaviTitle(String title) {
        toolbar.setNavigationContentDescription(title);
        return this;
    }

    /**
     * 设置toolbar标题
     * @param title
     * @return
     */
    public BaseActivity setToolTitle(String title) {
        toolbar.setTitle(title);
        return this;
    }

    /**
     * 设置toolbar子标题
     * @param subTitle
     * @return
     */
    public BaseActivity setToolSubTitle(String subTitle) {
        toolbar.setSubtitle(subTitle);
        return this;
    }

    /**
     *设置toolbar子标题字体颜色
     * @param subTitle
     * @return
     */
    public BaseActivity setToolSubTitleColor(int subTitle) {
        toolbar.setSubtitleTextColor(subTitle);
        return this;
    }

    /**
     * 设置toolbar左边按钮
     * @param resid
     * @return
     */
    public BaseActivity setToolbarIco(int resid) {
        toolbar.setNavigationIcon(resid);
        return this;
    }

    /**
     * 设置toolbar标题颜色
     * @param color
     * @return
     */
    public BaseActivity setToolbarTitleColor(int color) {
        toolbar.setTitleTextColor(color);
        return this;
    }

    /**
     * 设置toolbar图标点击事件
     * @param onClickListenerOfToolBar
     * @return
     */
    public BaseActivity setToolbarIcoListner(final OnClickListener onClickListenerOfToolBar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListenerOfToolBar.OnClick();
            }
        });
        return this;
    }

    /**
     * 初始化监听器
     */
    public abstract void initListner();

    /**
     * 初始化View
     */
    public abstract void initView();

    private void setHandler() {
        handler.setHandler(new IHandler() {
            @Override
            public void handleMessage(Message msg) {
                handler(msg);
            }
        });
    }


    protected abstract void initContentView(Bundle savedInstanceState);

    /**
     * 可能全屏或者没有ActionBar等
     */
    private void setBase() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }


    /**
     * //让子类处理消息
     * @param msg
     */

    protected abstract void handler(Message msg);


    /**
     *  横竖屏切换，键盘等
     */

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        try {
            super.onRestoreInstanceState(savedInstanceState);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 你可以添加多个Action捕获
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NETWORK_CHANGE);
        filter.addAction(ACTION_PUSH_DATA);
        filter.addAction(ACTION_NEW_VERSION);
        registerReceiver(receiver, filter);
        //还可能发送统计数据，比如第三方的SDK 做统计需求
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        //还可能发送统计数据，比如第三方的SDK 做统计需求
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 处理各种情况
            String action = intent.getAction();
            if (ACTION_NETWORK_CHANGE.equals(action)) { // 网络发生变化

            } else if (ACTION_NEW_VERSION.equals(action)) { // 可能发现新版本
                // VersionDialog 可能是版本提示是否需要下载的对话框
            }
        }
    };



}