package com.yangfuhai.asimplecachedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yangfuhai.asimplecachedemo.beans.UserBean;

import org.afinal.simplecache.ACache;

/**
 * 
 * @ClassName: SaveObjectActivity
 * @Description: 缓存jsonobject
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-8 下午2:13:16
 * 
 */
public class SaveObjectActivity extends Activity {

	private TextView mOriginalTextView, mResTextView;
	private UserBean userBean;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_object);
		// 初始化控件
		initView();

		mCache = ACache.get(this);
		userBean = new UserBean();
		userBean.setAge("18");
		userBean.setName("HaoYoucai");
		mOriginalTextView.setText(userBean.toString());
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		mOriginalTextView = (TextView) findViewById(R.id.tv_object_original);
		mResTextView = (TextView) findViewById(R.id.tv_object_res);
	}

	/**
	 * 点击save事件
	 * 
	 * @param v
	 */
	public void save(View v) {
		mCache.put("testObject", userBean);
	}

	/**
	 * 点击read事件
	 * 
	 * @param v
	 */
	public void read(View v) {
		UserBean testObject = (UserBean) mCache.getAsObject("testObject");
		if (testObject == null) {
			Toast.makeText(this, "Object cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mResTextView.setText(null);
			return;
		}
		mResTextView.setText(testObject.toString());
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
