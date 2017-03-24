package com.yangfuhai.asimplecachedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yangfuhai.asimplecachedemo.beans.UserBean;

import org.afinal.simplecache.ACache;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SaveObjectActivity
 * @Description: 缓存jsonobject
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-8 下午2:13:16
 */
public class SaveObjectListActivity extends Activity {

    private TextView mTv_object_original, mTv_object_res;
    private List<UserBean> userBeanList = new ArrayList<>();

    private ACache mCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_object);
        // 初始化控件
        initView();

        mCache = ACache.get(this);
        userBeanList = new ArrayList<>();
        UserBean userBean1 = new UserBean();
        userBean1.setAge("18");
        userBean1.setName("HaoYoucai");
        userBeanList.add(userBean1);
        UserBean userBean2 = new UserBean();
        userBean2.setAge("25");
        userBean2.setName("Test");
        userBeanList.add(userBean2);
        displayValue(mTv_object_original, userBeanList);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mTv_object_original = (TextView) findViewById(R.id.tv_object_original);
        mTv_object_res = (TextView) findViewById(R.id.tv_object_res);
    }

    /**
     * 点击save事件
     *
     * @param v
     */
    public void save(View v) {
        mCache.put("testObject", userBeanList);
    }

    /**
     * 点击read事件
     *
     * @param v
     */
    public void read(View v) {
        List<UserBean> testObject = mCache.getAsObjectList("testObject", UserBean.class);
        if (testObject == null) {
            Toast.makeText(this, "Object cache is null ...", Toast.LENGTH_SHORT)
                    .show();
            mTv_object_res.setText(null);
            return;
        }
        displayValue(mTv_object_res, testObject);
    }

    private void displayValue(TextView textView, List<UserBean> testObject) {
        StringBuilder builder = new StringBuilder();
        for (UserBean userBean : testObject) {
            builder.append(userBean.toString()).append("\n");
        }
        textView.setText(builder.toString());
    }

    /**
     * 点击clear事件
     *
     * @param v
     */
    public void clear(View v) {
        mCache.remove("testObject");
    }
}
