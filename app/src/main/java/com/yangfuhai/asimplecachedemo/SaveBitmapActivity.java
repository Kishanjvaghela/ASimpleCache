package com.yangfuhai.asimplecachedemo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.afinal.simplecache.ACache;

/**
 * 
 * @ClassName: SaveBitmapActivity
 * @Description: 缓存bitmap
 * @Author Yoson Hao
 * @WebSite www.haoyuexing.cn
 * @Email haoyuexing@gmail.com
 * @Date 2013-8-7 下午5:20:37
 * 
 */
public class SaveBitmapActivity extends Activity {

	private ImageView mIvBitmapRes;

	private ACache mCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_save_bitmap);
		// 初始化控件
		initView();

		mCache = ACache.get(this);
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		mIvBitmapRes = (ImageView) findViewById(R.id.iv_bitmap_res);
	}

	/**
	 * 点击save事件
	 * 
	 * @param v
	 */
	public void save(View v) {
		Resources res = getResources();
		Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.img_test);
		mCache.put("testBitmap", bitmap);
	}

	/**
	 * 点击read事件
	 * 
	 * @param v
	 */
	public void read(View v) {
		Bitmap testBitmap = mCache.getAsBitmap("testBitmap");
		if (testBitmap == null) {
			Toast.makeText(this, "Bitmap cache is null ...", Toast.LENGTH_SHORT)
					.show();
			mIvBitmapRes.setImageBitmap(null);
			return;
		}
		mIvBitmapRes.setImageBitmap(testBitmap);
	}

	/**
	 * 点击clear事件
	 * 
	 * @param v
	 */
	public void clear(View v) {
		mCache.remove("testBitmap");
	}
}
