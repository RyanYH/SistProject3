package com.sist.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MovieManager {
	public String movie_review(String title, int page) {
		StringBuffer sb = new StringBuffer();
		try {
			//ddcf4460013008172d4b85dea4263c64
			//41cb729c29ba4d6d3f797aa183cae694
			//80411406ba4ab7fc579820a0960441fc
			//8123d2ef182943b3955ba0e0567824b6
			//a68708ccdf2933fd8dc33c16d2339cd5
			String key = "80411406ba4ab7fc579820a0960441fc";
			String query = "https://apis.daum.net/search/blog?" + "apikey=" + key + "&result=20&output=json&pageno="
					+ page + "&q=" + URLEncoder.encode(title, "UTF-8");
			URL url = new URL(query);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			if (conn != null) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				String data = "";
				while (true) {
					data = in.readLine();
					if (data == null)
						break;
					sb.append(data + "\n");
				}
			}
			conn.disconnect();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return sb.toString();
	}
	
	public String naverMovie_review(String title, int page){
		// 28fc6760099689b89827707a3e14542f
		// 5441797270a10ef57cfe8555671ece2d  -- use
		// 115c2c464de916fe1b6a04ca269996d9  -- use
		// a5cbc0f61e847f43dfa9c5ba55566f33
		// f69af58eb2814c20d428a3819d4296ef  -- 사용
		String apiKey = "5441797270a10ef57cfe8555671ece2d";
		String uri = "";
		try{
    		uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=blog&query=" + 
    		URLEncoder.encode(title, "UTF-8")+"&start="+page;
    	}catch(UnsupportedEncodingException e){
    		System.out.println(e);
    	}
		return uri;
	}

	
	public static String getContent(Element element, String tagName)
	{
		 NodeList list = element.getElementsByTagName(tagName);
		 Element cElement = (Element)list.item(0);
		 
		 if(cElement.getFirstChild()!=null){
			return cElement.getFirstChild().getNodeValue();
		 }else{
			return "";
		 }
	}
	
	public void parse(String uri)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try
		{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");
			String desc = "";
		    for(int i=0; i<list.getLength();i++){
				Element element = (Element)list.item(i);
				String naverReview = getContent(element,"description");
				desc += naverReview + "\n";
			}
		    FileWriter fw = new FileWriter(
					"/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/desc.txt",
					true);
			fw.write(desc);
			fw.close();
		}
		catch(Exception ex){
			System.out.println("parse error() : "+ex.getMessage());
		}
	}
	
	public void json_parse(String json) {
		try {
			JSONParser jc = new JSONParser();
			JSONObject jo = (JSONObject) jc.parse(json);
			JSONObject channel = (JSONObject) jo.get("channel");
			JSONArray item = (JSONArray) channel.get("item");
			String desc = "";
			for (int i = 0; i < item.size(); i++) {
				JSONObject obj = (JSONObject) item.get(i);
				String review = (String) obj.get("description");
				// System.out.println(review);
				desc += review + "\n";
			}
			desc = desc.replaceAll("[A-Za-z0-9]", "");
			desc = desc.replace("&", "");
			desc = desc.replace(".", "");
			desc = desc.replace("#", "");
			desc = desc.replace("?", "");
			desc = desc.replace("/", "");
			desc = desc.replace(";", "");
			desc = desc.replace("(", "");
			desc = desc.replace(")", "");
			desc = desc.replace("[", "");
			desc = desc.replace("]", "");
			desc = desc.replace("+", "");
			desc = desc.replace(",", "");
			desc = desc.replace("'", "");
			desc = desc.replace("~", "");
			// desc=desc.replace("+", "");
			// System.out.println(desc);

			FileWriter fw = new FileWriter(
					"/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/desc.txt",
					true);
			fw.write(desc);
			fw.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String rGraph(MovieVO vo) {
		String res = "";
		try {
			
			RConnection rc = new RConnection();
			rc.voidEval(
					"review<-read.table(\"/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/output/part-r-00000\")");
			/*
			 * rc.voidEval(
			 * "png(\"/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MovieProject/recommand.png\",width=800,height=600)"
			 * ); rc.voidEval("par(mfrow=c(1,2))"); rc.voidEval(
			 * "pie(review$V2, labels=review$V1, col=rainbow(15))");
			 * rc.voidEval(
			 * "barplot(review$V2, names.arg=review$V1, col=rainbow(15))");
			 * rc.voidEval("dev.off()");
			 */
			REXP p = rc.eval("review$V1");
			String[] title = p.asStrings();
			p = rc.eval("review$V2");
			int[] count = p.asIntegers();

			String feel = "";
			String cnt = "";
			for (int i = 0; i < title.length; i++) {
				if (count[i] >= 1) {
					feel = feel + title[i] + ",";
					cnt = cnt + count[i] + ",";
				}
			}
			vo.setFeel(feel);
			vo.setCount(cnt);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return res;
	}

	public List<String> read_review() {
		List<String> list = new ArrayList<String>();
		try {
			RConnection rc = new RConnection();
			rc.setStringEncoding("utf8");
			rc.voidEval(
					"review<-readLines(\"/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/desc.txt\")");
			REXP p = rc.eval("review");
			String[] data = p.asStrings();
			for (String s : data) {
				list.add(s);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}
}
