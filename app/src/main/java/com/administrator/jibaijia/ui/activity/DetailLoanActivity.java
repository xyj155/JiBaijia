package com.administrator.jibaijia.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.administrator.jibaijia.R;
import com.administrator.jibaijia.base.baseactivity.BaseActivity;
import com.administrator.jibaijia.base.baseactivity.OnClickListener;
import com.administrator.jibaijia.bean.SingleLoan;
import com.administrator.jibaijia.constant.APIConstant;
import com.administrator.jibaijia.util.volley.VolleyRequest;
import com.administrator.jibaijia.util.volley.VolleyRequstUtil;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class DetailLoanActivity extends BaseActivity {

    private RequestQueue queen;
    @BindView(R.id.img_loan)
    ImageView imgLoan;
    @BindView(R.id.tv_loan_name)
    TextView tvLoanName;
    @BindView(R.id.tv_loan_month_loan_interest)
    TextView tvLoanMonthLoanInterest;
    @BindView(R.id.tv_loan_type)
    TextView tvLoanType;
    @BindView(R.id.tv_loan_range)
    TextView tvLoanRange;
    @BindView(R.id.tv_loan_day_range)
    TextView tvLoanDayRange;
    @BindView(R.id.tv_chart_loan_per)
    TextView tvChartLoanPer;
    @BindView(R.id.tv_chart_loan_lixi)
    TextView tvChartLoanLixi;
    @BindView(R.id.tv_chart_loan_spend)
    TextView tvChartLoanSpend;
    @BindView(R.id.tv_chart_loan_inonce)
    TextView tvChartLoanInonce;
    @BindView(R.id.tv_loan_distribution)
    TextView tvLoanDistribution;
    @BindView(R.id.tv_loan_material)
    TextView tvLoanMaterial;
    private PieChartView chart;
    private PieChartData data;

    @Override
    public void initListner() {

    }

    @Override
    public void initView() {
        queen = Volley.newRequestQueue(DetailLoanActivity.this);
        InitToolbarView().setToolbarIco(R.mipmap.ic_back).setToolbarIcoListner(new OnClickListener() {
            @Override
            public void OnClick() {
                finish();
            }
        });
        chart = (PieChartView) findViewById(R.id.chart);
        generateData();
        Intent intent = getIntent();
        initData(intent.getIntExtra("id", 5));

    }

    private void initData(int id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));

        queen.add(VolleyRequstUtil.RequestWithParams(APIConstant.GET_LOAN_BYID, map, new VolleyRequest() {
            @Override
            public void onsuccess(String jsonObject) {
                Gson gson = new Gson();
                SingleLoan singleLoan = gson.fromJson(jsonObject, SingleLoan.class);
                if (singleLoan.getStatus() == 200) {
                    Glide.with(DetailLoanActivity.this).asBitmap().load(singleLoan.getData().getTubiao()).into(imgLoan);
                    tvLoanName.setText(singleLoan.getData().getDaikuanmc());//公司名称
                    tvLoanMonthLoanInterest.setText(singleLoan.getData().getYuelixi()+"%");//月利息
                    tvLoanType.setText(singleLoan.getData().getHuankuanfangshi());//种类
                    tvLoanRange.setText("贷款范围："+singleLoan.getData().getEdufanwei());//贷款范围
                    tvLoanDayRange.setText("还款时间："+singleLoan.getData().getQixianfanwei());//还款时间
                    tvChartLoanPer.setText("贷款： "+singleLoan.getData().getDaikuan()+"万元");//贷款
                    tvChartLoanLixi.setText("利息： "+singleLoan.getData().getLixijine()+"元");//利息
                    tvChartLoanSpend.setText("费用： "+singleLoan.getData().getFeiyong()+"元");//费用
                    tvChartLoanInonce.setText("一次性： "+singleLoan.getData().getYicixin()+"元");//一次性
                    tvLoanDistribution.setText(singleLoan.getData().getShenqintiaojian()+"");//申请条件
                    tvLoanMaterial.setText(singleLoan.getData().getShengqincailiao()+"");//准备材料
                }
            }

            @Override
            public void onerror(VolleyError error) throws Exception {
                Toast.makeText(DetailLoanActivity.this, "获取信息出错，请重试！", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<SliceValue>();
        SliceValue sliceValue1 = new SliceValue(100, 0xffff4500);
        SliceValue sliceValue2 = new SliceValue(60, 0xff9932CC);
        SliceValue sliceValue3 = new SliceValue(60, 0xff1e90ff);
        SliceValue sliceValue4 = new SliceValue(50, 0xffd2691e);
        values.add(sliceValue1);
        values.add(sliceValue2);
        values.add(sliceValue3);
        values.add(sliceValue4);
        data = new PieChartData(values);
        data.setHasLabels(false);
        data.setHasLabelsOnlyForSelected(true);
        data.setHasLabelsOutside(true);
        data.setHasCenterCircle(true);
        data.setCenterText1("公积金");
        data.setCenterText1FontSize(12);
        chart.setPieChartData(data);
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_detail_loan);
    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
