package com.administrator.jibaijia.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.BaseAdapter.CommonViewHolder;
import com.administrator.jibaijia.base.BaseAdapter.RecycleAdapter;
import com.administrator.jibaijia.base.BaseFragment;
import com.administrator.jibaijia.bean.BannerBean;
import com.administrator.jibaijia.bean.LoanListBean;
import com.administrator.jibaijia.bean.MarqueenBean;
import com.administrator.jibaijia.constant.APIConstant;
import com.administrator.jibaijia.ui.activity.DetailLoanActivity;
import com.administrator.jibaijia.util.volley.VolleyRequest;
import com.administrator.jibaijia.util.volley.VolleyRequstUtil;
import com.administrator.jibaijia.view.MarqueeView;
import com.administrator.jibaijia.view.banner.MZBannerView;
import com.administrator.jibaijia.view.banner.creator.MZHolderCreator;
import com.administrator.jibaijia.view.banner.creator.MZViewHolder;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
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

public class FragmentMainPage extends BaseFragment {
    private MZBannerView mMZBanner;
    private LoanPurseAdapter adapter;
    private RecyclerView ry_mp;
    private RefreshLayout refreshLayout;
    private MarqueeView marqueeView;
    private int PAGE = 1;
    List<LoanListBean.DataBeanX.DataBean> dataBeen = new ArrayList<>();

    @Override
    protected int setView() {
        return R.layout.fragment_mainpage;
    }


    @Override
    protected void init(View view) {
        mMZBanner = (MZBannerView) view.findViewById(R.id.banner);
        ry_mp = view.findViewById(R.id.ry_mp);
        refreshLayout = (RefreshLayout) view.findViewById(R.id.smartrefresh);
        marqueeView = view.findViewById(R.id.marqueeView);
    }

    @Override
    protected void initDataMoulde() {
        refreshLayout.autoRefresh();
        ry_mp.setLayoutManager(new LinearLayoutManager(getActivity()));
        ry_mp.setNestedScrollingEnabled(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                dataBeen.clear();
                PAGE = 1;
                ry_mp.removeAllViews();
                refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                initBanner();
                initLoanList(1);
                initMarqueen();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                PAGE++;
                System.out.println(PAGE);
                initLoanListMore(PAGE);
            }
        });


    }


    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    /**
     * 加载Banner
     */
    private void initBanner() {
        addQueue(VolleyRequstUtil.Request(APIConstant.BANNER_LIST, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                BannerBean loanListBean = gson.fromJson(jsonObject, BannerBean.class);
                int status = loanListBean.getStatus();
                if (status == 200) {
                    List<BannerBean.DataBean> list = loanListBean.getData();
                    List<String> banner = new ArrayList<String>();
                    for (int i = 0; i < list.size(); i++) {
                        banner.add(list.get(i).getBannerurl());
                    }
                    mMZBanner.setPages(banner, new MZHolderCreator<BannerViewHolder>() {
                        @Override
                        public BannerViewHolder createViewHolder() {
                            return new BannerViewHolder();
                        }
                    });
                    mMZBanner.setDelayedTime(5000);
                    mMZBanner.start();
                }
            }

            @Override
            public void onerror(VolleyError error) throws Exception {

            }
        }));
    }

    /***
     * 加载跑马灯
     */
    private void initMarqueen() {
        addQueue(VolleyRequstUtil.Request(APIConstant.MARQUEEN_LIST, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                MarqueenBean loanListBean = gson.fromJson(jsonObject, MarqueenBean.class);
                int status = loanListBean.getStatus();
                if (status == 200) {
                    List<MarqueenBean.DataBean> list = loanListBean.getData();
                    List<String> marqueenlist = new ArrayList<String>();
                    for (int i = 0; i < list.size(); i++) {
                        marqueenlist.add(list.get(i).getText1());
                    }
                    marqueeView.startWithList(marqueenlist);
                    marqueeView.startWithList(marqueenlist, R.anim.anim_bottom_in, R.anim.anim_top_out);
                }
            }

            @Override
            public void onerror(VolleyError error) throws Exception {

            }
        }));
    }

    /**
     * 加载列表初始化
     */
    private void initLoanList(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.LOAN_LIST, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                LoanListBean loanListBean = gson.fromJson(jsonObject, LoanListBean.class);
                int status = loanListBean.getStatus();
                if (status == 200) {
                    dataBeen.addAll(loanListBean.getData().getData());
                    adapter = new LoanPurseAdapter(getActivity(), dataBeen);
                    ry_mp.setAdapter(adapter);


                }
            }

            @Override
            public void onerror(VolleyError error) throws Exception {
                Toast.makeText(getActivity(), "数据获取错误！", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    /**
     * 加载列表上拉加载更多
     */
    private void initLoanListMore(int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.LOAN_LIST, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                LoanListBean loanListBean = gson.fromJson(jsonObject, LoanListBean.class);
                int status = loanListBean.getStatus();
                if (status == 200) {
                    dataBeen.addAll(loanListBean.getData().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onerror(VolleyError error) throws Exception {
                Toast.makeText(getActivity(), "数据获取错误！", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    /**
     * Banner适配器
     */
    public class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            Glide.with(getActivity()).load(data).into(mImageView);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mMZBanner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        mMZBanner.start();//开始轮播
    }

    /**
     * 列表适配器
     */
    public static class LoanPurseAdapter extends RecycleAdapter<LoanListBean.DataBeanX.DataBean> {
        private Context context;

        public LoanPurseAdapter(Context context, List<LoanListBean.DataBeanX.DataBean> dataList) {
            super(context, dataList, R.layout.ry_loanfragment_loan_itelayout);
            this.context = context;
        }

        @Override
        public void bindData(CommonViewHolder holder, final LoanListBean.DataBeanX.DataBean data, int postion) {
            holder.setImageResourceUrl(R.id.img_loan, data.getTubiao())//图标
                    .setText(R.id.tv_loan_month_loan_interest, data.getYuelixi() + "%")//利息
                    .setText(R.id.tv_loan_max, data.getZuigaoedu() + "万")//最高额度
                    .setText(R.id.tv_loan_type, data.getHuankuanfangshi())//还款方式
                    .setText(R.id.tv_loan_name, data.getDaikuanmc())//名称
                    .setText(R.id.tv_loan_interest, data.getHuankuangqixian() + "个月")
                    .setOnClickListener(new CommonViewHolder.OnClickListener() {
                        @Override
                        public void onItemClickListener(int position) {
                            Intent intent = new Intent(context, DetailLoanActivity.class);
                            intent.putExtra("id", data.getId());
                            context.startActivity(intent);
                        }
                    });//放款时间
        }
    }
}
