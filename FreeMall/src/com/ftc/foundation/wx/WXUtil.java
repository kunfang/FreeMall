package com.ftc.foundation.wx;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import net.sf.json.JSONObject;

import com.ftc.foundation.config.DefaultParams;
import com.ftc.foundation.http.HttpRequester;
import com.ftc.foundation.http.HttpRespons;

/**
 * 
 */
public class WXUtil {
	
	public static String WX_TICKET;
	
    /**
     * 
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp,
            String nonce) {
        String[] arr = new String[] { DefaultParams.findParam("wx.token"), timestamp, nonce };
        //Arrays.sort(arr);
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // ����������ַ�ƴ�ӳ�һ���ַ����sha1����
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

    public static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    
    private static String create_nonce_str() {
    	return UUID.randomUUID().toString();
    }
    
    private static String create_timestamp() {
    	return Long.toString(System.currentTimeMillis() / 1000);
    }
    
    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                  "&noncestr=" + nonce_str +
                  "&timestamp=" + timestamp +
                  "&url=" + url;

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appID", DefaultParams.findParam("wx.appID"));
        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    
    public static String getTicket() {
    	if (WX_TICKET == null) {
    		WX_TICKET = getTicketFromWX();
    		
    		// 此处执行定时任务,2个小时执行一次
        	new Timer().schedule(new TimerTask() {
    			
    			@Override
    			public void run() {
    				System.out.println("get new ticket");
    				WX_TICKET = getTicketFromWX();
    				System.out.println(WX_TICKET);
    			}
    		}, 7200*1000,7200*1000);
    	}
    	
    	return WX_TICKET;
    }
    
    private static String getTicketFromWX() {
    	HttpRequester request = new HttpRequester();
		request.setDefaultContentEncoding("utf-8");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", DefaultParams.findParam("wx.appID"));
		params.put("secret", DefaultParams.findParam("wx.appsecret"));
		HttpRespons response = null;
		try {
			response = request.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
			JSONObject json = JSONObject.fromObject(response.getContent());
			String access_token = (String)json.get("access_token");
			params = new HashMap<String, String>();
			params.put("access_token", access_token);
			params.put("type", "jsapi");
			
			response = request.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
			json = JSONObject.fromObject(response.getContent());
			
			return (String)json.get("ticket");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public static void main(String[] args) {
    	//getTicket();
    	System.out.println(getTicketFromWX());
	}
}