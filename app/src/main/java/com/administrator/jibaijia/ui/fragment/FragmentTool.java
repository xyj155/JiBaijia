package com.administrator.jibaijia.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.BaseAdapter.CommonViewHolder;
import com.administrator.jibaijia.base.BaseAdapter.RecycleAdapter;
import com.administrator.jibaijia.base.BaseFragment;
import com.administrator.jibaijia.bean.NewsBean;
import com.administrator.jibaijia.constant.APIConstant;
import com.administrator.jibaijia.util.volley.VolleyRequest;
import com.administrator.jibaijia.util.volley.VolleyRequstUtil;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/13.
 */

public class FragmentTool extends BaseFragment {
    private RecyclerView ry_news;
    private NewsAdapter adapter;
    private SmartRefreshLayout refreshLayout;
    private List<NewsBean.DataBeanX.DataBean> dataBeen = new ArrayList<>();
    public int PAGE;

    @Override
    protected int setView() {
        return R.layout.fragment_tool;
    }

    @Override
    protected void init(View view) {
        setToolBarSubtitle("工具").setToolBarSubtitleColor(0xffffffff);
        ry_news = view.findViewById(R.id.ry_news);
        refreshLayout = view.findViewById(R.id.smartrefresh);
        ry_news.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initDataMoulde() {
        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {


            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                dataBeen.clear();
                PAGE = 1;
                ry_news.removeAllViews();
                refreshLayout.finishRefresh(2000/*,false*/);
                initNewslist(1);

            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                PAGE++;
                NewListLoadMore(PAGE);
            }
        });


    }

    private void initNewslist(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.NEWS_LIST, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(jsonObject, NewsBean.class);
                if (newsBean.getStatus() == 200) {
                    dataBeen.addAll(newsBean.getData().getData());
                    adapter = new NewsAdapter(dataBeen);
                    ry_news.setAdapter(adapter);
                }

            }

            @Override
            public void onerror(VolleyError error) throws Exception {
                Toast.makeText(getActivity(), "请求出错：" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void NewListLoadMore(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.NEWS_LIST, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(jsonObject, NewsBean.class);
                if (newsBean.getStatus() == 200) {
                    dataBeen.addAll(newsBean.getData().getData());
                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onerror(VolleyError error) throws Exception {
                Toast.makeText(getActivity(), "请求出错：" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private class NewsAdapter extends RecycleAdapter<NewsBean.DataBeanX.DataBean> {


        public NewsAdapter(List<NewsBean.DataBeanX.DataBean> dataList) {
            super(getContext(), dataList, R.layout.ry_news_tool_item);
        }

        @Override
        public void bindData(CommonViewHolder holder, NewsBean.DataBeanX.DataBean data, int postion) {
            holder.setText(R.id.tv_news_title, data.getNewstitle())
                    .setText(R.id.tv_new_content, data.getNewscontents())
                    .setImageResourceURL(R.id.img_news, data.getZhaopaitupian());
        }
    }

}
