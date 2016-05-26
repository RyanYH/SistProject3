package com.sist.dao;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sist.hadoop.MovieDriver;

import java.io.*;
public class MainClass {
	public static void main(String[] args){
		MovieDAO dao = new MovieDAO();

		for(int i=18;i<=19;i++){
			try{
					Document doc = Jsoup.connect("http://new.cinefox.com/vod/movie/list?page="+i).get();
					Elements movieNO = doc.select("div.listBox ul.list li div.postimg");
					Elements elemGradeCount = doc.select("div.user");
					System.out.println(i+"번째 돌아가는 중");
					int zz=0;
					String kkkkkkkkkk="";
					for(int j=0;j<movieNO.size();j++){
						try{
						
						Element noelem = movieNO.get(j);
						Element gradeCountElem = elemGradeCount.get(j);
						String gce = gradeCountElem.text();
						gce = gce.replace(",", "");
						gce = gce.substring(0, gce.lastIndexOf("명"));
						System.out.println("gce:"+gce);
						String no1 = noelem.attr("onclick");
						no1 = no1.substring(no1.lastIndexOf('=')+1,no1.lastIndexOf(")")-1);
						kkkkkkkkkk = no1;
						Document doc1 = Jsoup.connect("http://new.cinefox.com/vod/view?product_seq="+no1).get();
						Elements titleElem = doc1.select("title");
						Elements posterElem = doc1.select("img#PIMG");
						Elements ratingElem = doc1.select("div.metaInfoWrap div:eq(0)");
						Elements directorElem = doc1.select("div.metaInfoWrap div:eq(1)");
						Elements synopsisElem = doc1.select("div#content");
						Elements gradeElem = doc1.select("span.startNum");
						String title = titleElem.text();
						title = title.substring(6);   // title
						String poster = posterElem.attr("src");   // poster
						if(poster.charAt(0)=='/')
							poster = "http://thailove.net/data/cheditor4/1412/20141223141216_ywrvusmx.jpg";
						System.out.println(title + " : "+poster);
						String director = directorElem.text();
						if(director.substring(0,director.lastIndexOf("|")-1).length()>6)
							director = director.substring(director.indexOf(":")+2, director.lastIndexOf("|"));  // director
						else
							director = "";
						String actor = directorElem.text();
						if(actor.substring(actor.lastIndexOf(":")).length()>9)
							if(actor.contains("다운로드"))
								actor = actor.substring(actor.lastIndexOf(":")+2,actor.lastIndexOf(" "));  // actor
							else
								actor = actor.substring(actor.lastIndexOf(":")+2);  // actor
						else
							actor = "";
						String time = ratingElem.text();
						time = time.substring(0,time.indexOf("|")); // time
						String synopsis = synopsisElem.text(); // synopsis
						String token = ratingElem.text();
						StringTokenizer st = new StringTokenizer(token, "|");
						st.nextToken();
						st.nextToken();
						String genre = st.nextToken(); // genre
						String temp = st.nextToken(); // playdate
						String playdate = temp;
						String rating = st.nextToken();
						if(!temp.contains("개봉")){
							playdate = "";
							rating = temp;
						}
						if(rating.contains("바로")){
							rating = rating.substring(0,rating.lastIndexOf("가")+1);
						}
						
						String strGrade = gradeElem.text();
						if(strGrade.trim()==null || strGrade.equals(""))
							strGrade = "5.0";
						double grade = Double.parseDouble(strGrade.trim()); // grade
						
						MovieVO vo = new MovieVO();
						vo.setNo(Integer.parseInt(no1));
						vo.setTitle(title);
						vo.setPoster(poster);
						vo.setRating(rating);
						vo.setDirector(director);
						vo.setActor(actor);
						vo.setTime(time);
						vo.setSynopsis(synopsis);
						vo.setGenre(genre);
						vo.setPlaydate(playdate);
						vo.setGrade(grade);
						vo.setGradeCount(Integer.parseInt(gce));
						
						MovieManager m=new MovieManager();
						File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/desc.txt");
						if(file.exists())
							file.delete();
						
//						for(int k=1;k<=3;k++){
//						    String json=m.movie_review(vo.getTitle(), k);
//						    m.json_parse(json);
//						}
						for(int k=1;k<=35;k++){
							String json=m.naverMovie_review(vo.getTitle(), k);
							m.parse(json);
						}
						MovieDriver md = new MovieDriver();
						md.movieMapReduce();
						m.rGraph(vo);
						

						
						dao.MovieInsert(vo);
						zz++;
						}catch(Exception ex){
							System.out.println("두번째 포문"+zz+"번째 에러 : no:"+kkkkkkkkkk);
						}
					}
	
				
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println(i+"번째에서 에러."+ex.getMessage());
				break;
			}
		}
		//BeerVO vo = new BeerVO();\
		MovieVO vo = new MovieVO();
		MovieManager m=new MovieManager();
		File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BookTilesProject/desc.txt");
		if(file.exists())
			file.delete();
			try{
		file.createNewFile();
			}catch(Exception ex){
				
			}
		for(int k=1;k<=3;k++){
		    String json=m.movie_review("곡성", k);
		    m.json_parse(json);
		}
	
		MovieDriver md = new MovieDriver();
		md.movieMapReduce();
		String res = m.rGraph(vo);
		
		/*s*/
		
		/*vo.setFeel(feel);
		vo.setCount(count);*/
		  
	}
}
