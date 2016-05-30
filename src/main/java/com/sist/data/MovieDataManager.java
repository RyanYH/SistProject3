package com.sist.data;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;
import java.util.*;

@Component
public class MovieDataManager {

	public static List<MovieDTO> movieAllData(){
		List<MovieDTO> list= new ArrayList<MovieDTO>();
		try{
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			//System.out.println(doc);
			Elements titleElem=doc.select("div.box-contents strong.title");
			Elements percentElem=doc.select("div.box-contents strong.percent");
			Elements imgElem=doc.select("div.box-image span.thumb-image img");
			Elements likeElem=doc.select("div.box-contents span.like span.count strong i");
			Elements rElem=doc.select("div.box-contents span.txt-info strong");
			Elements sElem=doc.select("div.box-contents span.percent");
			for(int i=0;i<titleElem.size();i++){
				Element telem=titleElem.get(i);
				Element pelem=percentElem.get(i);
				Element ielem=imgElem.get(i);
				Element lelem=likeElem.get(i);
				Element relem=rElem.get(i);
				Element selem=sElem.get(i);
				String img=ielem.attr("src");
				MovieDTO d=new MovieDTO();
				d.setNo(i);
				d.setTitle(telem.text());
				d.setImage(img);
				int like=Integer.parseInt(lelem.text().replace(",", ""));
				d.setLike(like);
				d.setRegdate(relem.text().substring(0, relem.text().indexOf("개봉")).trim());
				String percent=pelem.text();
				if(percent.equals("?"))
					percent="0%";
				d.setPercent(percent.substring(3, percent.indexOf('%')));
				//d.setReserve(Double.parseDouble(selem.text().substring(0, selem.text().indexOf('%'))));
				list.add(d);
				String reserve = selem.text();
				if(reserve.equals("?"))
					reserve="0%";
				int n = reserve.lastIndexOf('%');
				if(n==0){
					d.setReserve(Double.parseDouble(reserve));
				}else{
					d.setReserve(Double.parseDouble(reserve.substring(0, reserve.indexOf('%'))));
				}
				//System.out.println(telem.text()+" "+pelem.text()+" "+img+" "+lelem.text()+" "+relem.text()+" "+selem.text());
			}
			
		}catch(Exception ex){
			System.out.println("여기"+ex.getMessage());
		}
		return list;
	}

	public List<String> recommandMovie(){
		List<String> list = new ArrayList<String>();
		try{
			Document doc=Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20160524").get();
			Elements elems=doc.select("td.title div.tit5");
			for(int i=0;i<elems.size();i++){
				Element td=elems.get(i);
				list.add(td.text());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

}
