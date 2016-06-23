package com.taobao.module;

import org.json.JSONException;
import org.json.JSONObject;

import com.uzmap.pkg.uzcore.UZResourcesIDFinder;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;

import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ModuleTest extends UZModule {

	public ModuleTest(UZWebView webView) {
		super(webView);
	}

	public void jsmethod_test(final UZModuleContext moduleContext) {

		// js向java传参
		// int paramInt = moduleContext.optInt("paramInt");
		// Toast.makeText(mContext, String.valueOf(paramInt),
		// Toast.LENGTH_LONG).show();

		// java回调js
		// final JSONObject ret = new JSONObject();
		// try {
		// ret.put("callback", "This is callback");
		// final Handler handler = new Handler();
		// Runnable runnable = new Runnable() {
		// @Override
		// public void run() {
		// moduleContext.success(ret, true);
		// handler.postDelayed(this, 2000);
		// }
		// };
		// handler.post(runnable);
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	// java获取资源id
	public void jsmethod_test1() {

		// java获取资源id
		LinearLayout testLayout = null;
		int layoutId = UZResourcesIDFinder.getResLayoutID("test_btn");
		testLayout = (LinearLayout) mContext.findViewById(layoutId);
		Button btn = null;
		int btnId = UZResourcesIDFinder.getResIdID("btn");
		btn = (Button) testLayout.findViewById(btnId);
		Toast.makeText(mContext, String.valueOf(btnId), Toast.LENGTH_LONG).show();
	}
	
	//getConfig
	public void jsmethod_getConfig(final UZModuleContext moduleContext) {
		String config = getFeatureValue("test", "testfeature");
		JSONObject ret = new JSONObject();
		try {
			ret.put("configParam", config);
			moduleContext.success(ret, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void jsmethod_getKey(final UZModuleContext moduleContext){
		String key = getSecureValue("key1");
		JSONObject ret = new JSONObject();
		try {
			ret.put("key1", key);
			moduleContext.success(ret, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
