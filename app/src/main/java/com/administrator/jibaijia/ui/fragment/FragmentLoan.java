package com.administrator.jibaijia.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.BaseFragment;
import com.administrator.jibaijia.bean.LoanListBean;
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

public class FragmentLoan extends BaseFragment implements View.OnClickListener {
    private ListView popListView;
    private List<Map<String, String>> menuData1, menuData2, menuData3;
    private PopupWindow popMenu;
    private SimpleAdapter menuAdapter1, menuAdapter2, menuAdapter3;
    private int PAGE = 1;
    private LinearLayout product, sort, activity;
    private List<LoanListBean.DataBeanX.DataBean> dataBeen = new ArrayList<>();
    private TextView productTv, sortTv, activityTv;

    private String currentProduct, currentSort, currentActivity;
    private int menuIndex = 0;
    private FragmentMainPage.LoanPurseAdapter adapter;
    private RecyclerView ry_kind;
    private SmartRefreshLayout refreshLayout;

    @Override
    protected int setView() {
        return R.layout.fragment_loan;
    }

    @Override
    protected void init(View view) {
        refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smartrefresh);
        product = (LinearLayout) view.findViewById(R.id.supplier_list_product);
        sort = (LinearLayout) view.findViewById(R.id.supplier_list_sort);
        activity = (LinearLayout) view.findViewById(R.id.supplier_list_activity);
        productTv = (TextView) view.findViewById(R.id.supplier_list_product_tv);
        sortTv = (TextView) view.findViewById(R.id.supplier_list_sort_tv);
        activityTv = (TextView) view.findViewById(R.id.supplier_list_activity_tv);
        ry_kind = view.findViewById(R.id.ry_kind);
        ry_kind.setLayoutManager(new LinearLayoutManager(getActivity()));
        product.setOnClickListener(this);
        sort.setOnClickListener(this);
        activity.setOnClickListener(this);
        initMenuData();
        initPopMenu();
        setToolBarSubtitleColor(0xffffffff).setToolBarSubtitle("贷款");
    }


    @Override
    protected void initDataMoulde() {
        refreshLayout.autoRefresh();
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                dataBeen.clear();
                PAGE = 1;
                ry_kind.removeAllViews();
                refreshLayout.finishRefresh(2000/*,false*/);
                SharedPreferences sp = getActivity().getSharedPreferences("interest", Context.MODE_PRIVATE);
                LoadByKind(sp.getInt("type", 55));
                System.out.println(sp.getInt("type", 55)+"TYPE");
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                PAGE++;
                SharedPreferences sp = getActivity().getSharedPreferences("interest", Context.MODE_PRIVATE);
                LoadByKindMore(sp.getInt("type", 55), PAGE);
            }
        });
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    /**
     * 加载下拉列表
     */
    private void initMenuData() {
        menuData1 = new ArrayList<Map<String, String>>();
        String[] menuStr1 = new String[]{"房贷", "车贷", "保单贷", "工薪贷", "月供贷",
                "装修贷", "业主贷", "小微信用贷", "现金赎楼贷", "应收账贷", "设备贷", "其他"};
        Map<String, String> map1;
        for (int i = 0, len = menuStr1.length; i < len; ++i) {
            map1 = new HashMap<String, String>();
            map1.put("name", menuStr1[i]);
            menuData1.add(map1);
        }

        menuData2 = new ArrayList<Map<String, String>>();
        String[] menuStr2 = new String[]{"月利息", "放款额度", "放款期限"};
        Map<String, String> map2;
        for (int i = 0, len = menuStr2.length; i < len; ++i) {
            map2 = new HashMap<String, String>();
            map2.put("name", menuStr2[i]);
            menuData2.add(map2);
        }

        menuData3 = new ArrayList<Map<String, String>>();
        String[] menuStr3 = new String[]{"由低到高", "由高到低"};
        Map<String, String> map3;
        for (int i = 0, len = menuStr3.length; i < len; ++i) {
            map3 = new HashMap<String, String>();
            map3.put("name", menuStr3[i]);
            menuData3.add(map3);
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.supplier_list_product:
                productTv.setTextColor(Color.parseColor("#ff7f50"));
                popListView.setAdapter(menuAdapter1);
                popMenu.showAsDropDown(product);
                menuIndex = 0;
                break;
            case R.id.supplier_list_sort:
                sortTv.setTextColor(Color.parseColor("#ff7f50"));
                popListView.setAdapter(menuAdapter2);
                popMenu.showAsDropDown(product);
                menuIndex = 1;
                break;
            case R.id.supplier_list_activity:
                activityTv.setTextColor(Color.parseColor("#ff7f50"));
                popListView.setAdapter(menuAdapter3);
                popMenu.showAsDropDown(product);
                menuIndex = 2;
                break;

        }
    }

    /**
     * 加载列表
     */
    private void LoadByKind(int type) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(1));
        map.put("kind", String.valueOf(type));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.LOAN_BY_KIND, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                LoanListBean loanListBean = gson.fromJson(jsonObject, LoanListBean.class);
                int status = loanListBean.getStatus();
                if (status == 200) {
                    dataBeen.addAll(loanListBean.getData().getData());
                    adapter = new FragmentMainPage.LoanPurseAdapter(getActivity(), dataBeen);
                    ry_kind.setAdapter(adapter);
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
    private void LoadByKindMore(int type, int page) {
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(page));
        map.put("kind", String.valueOf(type));
        addQueue(VolleyRequstUtil.RequestWithParams(APIConstant.LOAN_BY_KIND, map, new VolleyRequest() {
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
     * 加载POPWINDOW
     */
    private void initPopMenu() {
        initMenuData();
        View contentView = View.inflate(getActivity(), R.layout.popwin_supplier_list,
                null);
        popMenu = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        popMenu.setOutsideTouchable(true);
        popMenu.setBackgroundDrawable(new BitmapDrawable());
        popMenu.setFocusable(true);
        popMenu.setAnimationStyle(R.style.popwin_anim_style);
        popMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                productTv.setTextColor(Color.parseColor("#5a5959"));
                sortTv.setTextColor(Color.parseColor("#5a5959"));
                activityTv.setTextColor(Color.parseColor("#5a5959"));
            }
        });

        popListView = (ListView) contentView
                .findViewById(R.id.popwin_supplier_list_lv);
        contentView.findViewById(R.id.popwin_supplier_list_bottom)
                .setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        popMenu.dismiss();
                    }
                });
        menuAdapter1 = new SimpleAdapter(getActivity(), menuData1,
                R.layout.item_listview_popwin, new String[]{"name"},
                new int[]{R.id.listview_popwind_tv});
        menuAdapter2 = new SimpleAdapter(getActivity(), menuData2,
                R.layout.item_listview_popwin, new String[]{"name"},
                new int[]{R.id.listview_popwind_tv});
        menuAdapter3 = new SimpleAdapter(getActivity(), menuData3,
                R.layout.item_listview_popwin, new String[]{"name"},
                new int[]{R.id.listview_popwind_tv});

        popListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                popMenu.dismiss();
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("interest", Context.MODE_PRIVATE).edit();
                if (menuIndex == 0) {
                    currentProduct = menuData1.get(pos).get("name");
                    productTv.setText(currentProduct);
                    /***
                     * 1-12 种类选择
                     * 13-15其他种选择
                     * 16-17 利息选择
                     */
                    String[] menuStr1 = new String[]{"房贷", "车贷", "保单贷", "工薪贷", "月供贷",
                            "装修贷", "业主贷", "小微信用贷", "现金赎楼贷", "应收账贷", "设备贷", "其他"};
                    for (int i = 0; i < menuStr1.length; i++) {
                        if (currentProduct.equals(menuStr1[i])) {
                            editor.putInt("type", i + 1);
                            LoadByKind(1);
                        }
                    }
                } else if (menuIndex == 1) {
                    currentSort = menuData2.get(pos).get("name");
                    sortTv.setText(currentSort);
                    String[] menuStr2 = new String[]{"月利息", "放款额度", "放款期限"};
                    for (int i = 0; i < menuStr2.length; i++) {
                        if (currentSort.equals(menuStr2[i])) {
                            editor.putInt("type", i + 13);
                            LoadByKind(1);
                        }
                    }
                } else {
                    currentActivity = menuData3.get(pos).get("name");
                    activityTv.setText(currentActivity);
                    String[] menuStr3 = new String[]{"由低到高", "由高到低"};
                        for (int i = 0; i < menuStr3.length; i++) {
                            if (currentActivity.equals(menuStr3[i])) {
                                editor.putInt("type", i + 16);
                                LoadByKind(1);
                            }
                    }
                }
                editor.apply();
                refreshLayout.autoRefresh();
            }
        });
    }


}
