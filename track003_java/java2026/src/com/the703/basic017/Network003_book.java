package com.the703.basic017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Network003_book {

	public static void main(String[] args) {
		
		
		try {
			String aqiurl="https://openapi.naver.com/v1/search/book.xml?query="+URLEncoder.encode("etc", "UTF-8");;
		    URL	url = new URL(aqiurl);
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", "xuqdAQ1YqKezf_W5e6Fr");
			conn.setRequestProperty("X-Naver-Client-Secret", "LCI2xrrULC");
			
            int code = conn.getResponseCode();
			
			BufferedReader br;
			if(code==200) {br =new BufferedReader(new InputStreamReader(conn.getInputStream()));}
			else {br =new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
			String line="";
			StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null) {
				sb.append(line+"\n");
			}
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
        } catch (MalformedURLException e) {  e.printStackTrace();
		} catch (IOException e) {  e.printStackTrace(); }
		
		
		

	}

}
