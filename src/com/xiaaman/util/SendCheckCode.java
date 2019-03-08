package com.xiaaman.util;

import java.io.IOException;

import org.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

/** 

* @author 作者 XIAAMAN

* @version 创建时间：Feb 14, 2019 3:39:11 PM 

* 类说明 :发送验证码

*/
public class SendCheckCode {
	
	//发送验证码，并返回验证码
		public static String sendCode(String telePhoneNumber) {
			
			// 短信应用SDK AppID
	        int appid = 1400183776; // 1400开头

	        // 短信应用SDK AppKey
	        String appkey = "af24b437156a91bde0f651de73d73c40";

	        String code="" + (int)((Math.random()*9+1)*100000);		//随机验证码
	        String message = code + "为您的登录验证码，请于两分钟内填写。如非本人操作，请忽略本短信。";

	        // 短信模板ID，需要在短信应用中申请
	        // NOTE: 这里的模板ID`7839`只是一个示例，
	        // 真实的模板ID需要在短信控制台中申请
	        int templateId = 277832;

	        // 签名
	        // NOTE: 这里的签名"腾讯云"只是一个示例，
	        // 真实的签名需要在短信控制台中申请，另外
	        // 签名参数使用的是`签名内容`，而不是`签名ID`
	        String smsSign = "腾讯云";

	        // 单发短信
	        try {
	            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
	            SmsSingleSenderResult result = ssender.send(0, "86", telePhoneNumber, message, "", "");
	            JSONObject object = JSONObject.parseObject(result.toString());
	            if (object.getIntValue("result") != 0) {	//表示发送验证码不成功
	            	code = "";		//将验证码设置为"",代表发送失败
	            }
	            System.out.print(result);
	        } catch (HTTPException e) {
	            // HTTP响应码错误
	            e.printStackTrace();
	        } catch (JSONException e) {
	            // json解析错误
	            e.printStackTrace();
	        } catch (IOException e) {
	            // 网络IO错误
	            e.printStackTrace();
	        }

			return code;
			
		}

}
