package com.taobao.module;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.sdk.android.AlibabaSDK;
import com.taobao.tae.sdk.callback.InitResultCallback;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;


public class AliBaBa extends UZModule {

	public AliBaBa(UZWebView webView) {
		super(webView);
	}
	
	
	public void jsmethod_asyncInit(final UZModuleContext moduleContext) {
		
		AlibabaSDK.asyncInit(moduleContext.getContext(), new InitResultCallback() {
			 
            @Override
            public void onSuccess() {
            	JSONObject ret = new JSONObject();
            	JSONObject err = new JSONObject();
            	try {
					ret.put("msg", "初始化成功");
					moduleContext.success(ret, true);
				} catch (JSONException e) {
					try {
						err.put("msg", e.getMessage());
						moduleContext.error(ret, err, true);
					} catch (JSONException e1) {
					}
				}
            }
 
            @Override
            public void onFailure(int code, String message) {
            	JSONObject ret = new JSONObject();
            	JSONObject err = new JSONObject();
            	
            	try {
					err.put("code", code);
					err.put("msg", message);
				} catch (JSONException e) {
					moduleContext.error(ret, err, true);
				}
            }
 
        });
		
	}
}
