package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.JMUtil;


/*
 * Copyright (C) 2010-2015 Jumei Inc.All Rights Reserved.
 * FileName：TestDriver.java
 * Description：
 * History：
 * 1.0 denverhan 2016-2-25 Create
 */

public class TestDriver
{


	public static String		url			= "{\"1080\":\"http://showlive-10012585.image.myqcloud.com/92dd7b2f-7e8f-4bcb-9b29-202789ec4e9a/1280x640\",\"1280\":\"http://showlive-10012585.image.myqcloud.com/92dd7b2f-7e8f-4bcb-9b29-202789ec4e9a/1280x640\",\"640\":\"http://showlive-10012585.image.myqcloud.com/92dd7b2f-7e8f-4bcb-9b29-202789ec4e9a/750x375\",\"720\":\"http://showlive-10012585.image.myqcloud.com/92dd7b2f-7e8f-4bcb-9b29-202789ec4e9a/750x375\"}";
	static String				imgTest		= "{\"1080\":\"http://mp2.jmstatic.com/product/001/564/1564334_std/1564334_350_350.jpg?imageView2/2/w/540&v=1462858128\",\"480\":\"http://mp1.jmstatic.com/c_zoom,w_240,q_70/product/001/564/1564334_std/1564334_350_350.jpg?v=1462858128\",\"320\":\"http://mp1.jmstatic.com/c_zoom,w_160,q_70/product/001/564/1564334_std/1564334_350_350.jpg?v=1462858128\",\"640\":\"http://mp1.jmstatic.com/c_zoom,w_320,q_70/product/001/564/1564334_std/1564334_350_350.jpg?v=1462858128\"}";

	public static String		jmimg		= "{\"1080\":\"http://images2.jumei.com/user_avatar/092/909/92909501-200.jpg?1458828594\",\"1280\":\"http://images2.jumei.com/user_avatar/092/909/92909501-200.jpg?1458828594\",\"640\":\"http://images2.jumei.com/user_avatar/092/909/92909501-100.jpg?1458828647\",\"720\":\"http://images2.jumei.com/user_avatar/092/909/92909501-100.jpg?1458828647\"}";
	public static final String	testCase	= "{\"denver\":21, \"Data\":{\"good_value\":" + url + "}  ,\"name\":[\"namea\",\"nameb\",\"namec\",\"named\",\"namee\"] 			 }";

	public  static String nameArray = "[{\"name\":\"1\"},\n" + 	"{\"name\":\"2\"}\n" + 	"]";
	
	public static class CName
	{
		public String name;
	}
	public static void main(String[] args)
	{
		String c = getFileContent();
		System.out.println(c);
		AppConfigResp p = JSON.parseObject(c, AppConfigResp.class);
		List<CName> cn = JSON.parseObject(nameArray, new TypeReference<List<CName>>() {});
		
//		System.out.println("imgUrl:" + p.imgUrl);
//		System.out.println("data.value:" + p.mData.getValue());
//		String s = JMUtil.parseImageJson(url, false);
		System.out.println("s:" + p.toString());

	}
	
	
	static String getFileContent()
	{
		   StringBuilder s = new StringBuilder();
		   String readPath="./test_text.txt";
	        try{
	            File file =new File(readPath);
	            BufferedReader  bf =new BufferedReader(new FileReader(file));	       
	            //临时变量
	            String tempString = null;
	            //逐行读取
	            while ((tempString=bf.readLine())!=null){
	                s.append(tempString.trim());
	            }
	            //关闭
	            bf.close();
	        }catch(Exception e){
	            //TODO 处理异常
	        }
	        return s.toString();
	}
}
