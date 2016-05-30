package com.sist.dao;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sist.hadoop.MovieDriver;
import com.sist.mongo.RecommandDAO;

import java.io.*;
public class MainClass {
	/*public static void main(String[] args){
		RecommandDAO dao = new RecommandDAO();

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
						File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SistProject3/desc.txt");
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
		File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SistProject3/desc.txt");
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
		
		s
		
		vo.setFeel(feel);
		vo.setCount(count);
		  
	}*/
	
	public static void main(String[] args) throws IOException{
        RecommandDAO dao = new RecommandDAO();
           /*Document doc = Jsoup.connect("http://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20160524").get();
           Elements movieNO = doc.select("tbody tr td.title div.tit5 a");
           int k = 61000;
           
           for(int j=0;j<movieNO.size();j++){
               try{
                    Element noelem = movieNO.get(j);
                    String no1 = noelem.attr("href");
                    
                    StringTokenizer st1 = new StringTokenizer(no1, "=");
                    st1.nextToken();
                    String no = st1.nextToken();
                    
                    Document doc1 = Jsoup.connect("http://movie.naver.com/movie/bi/mi/basic.nhn?code="+no).get();
                    Elements posterElem = doc1.select("div.wide_info_area div.poster a img");
                    String poster = posterElem.attr("src").trim();   
                    
                    
                    
                    Elements titleElem = doc1.select("div.wide_info_area div.mv_info h3.h_movie a");
                    String title = titleElem.text().trim();
                    StringTokenizer st2 = new StringTokenizer(title, "(");
                    title = st2.nextToken().trim();
                    
                    if(title.contains("상영중")){
                        title = title.replace("상영중", "").trim();
                    }
                    Elements directorElem = doc1.select("div.info_spec2 dl.step1 dd a");
                    String director = directorElem.first().text().trim();
                    
                    Elements actorElem = doc1.select("div.info_spec2 dl.step2 dd a");
                    String actorlist = actorElem.text().trim();
                    String actor="";
                    
                    StringTokenizer st3 = new StringTokenizer(actorlist, ")");
                
                    while(st3.hasMoreTokens()){
                        if (actorlist.contains("(")){
                            String aa = st3.nextToken();
                            actor = actor + aa.substring(0, aa.indexOf("(")) + "," ;
                        } else {
                            if (title.contains("서유기")){
                                StringTokenizer st6 = new StringTokenizer(actorlist, " ");
                                while(st6.hasMoreTokens()){
                                    String bb = st6.nextToken() + st6.nextToken();
                                     actor = actor + bb+ "," ;
                                }
                                 break;
                            } else {
                                StringTokenizer st6 = new StringTokenizer(actorlist, " ");
                                while(st6.hasMoreTokens()){
                                    String bb = st6.nextToken() + st6.nextToken();
                                     actor = actor + bb+ "," ;
                                }
                                break;
                            }
                        }
                    }
                    
                    actor = actor.substring(0, actor.lastIndexOf(","));
                    
                    Elements ratingElem = doc1.select("div.mv_info dl.info_spec dd p a");
                    int gradecheck = ratingElem.toString().indexOf("grade");
                    String rating = "";
                    if (gradecheck != 502 && gradecheck != 797 && gradecheck != 676){
                        rating = ratingElem.toString().substring(gradecheck, ratingElem.toString().lastIndexOf("가")+1);
                        rating = rating.toString().substring(rating.toString().indexOf(">")+1, rating.length());
                        if(rating.indexOf("grade") > 0){
                            rating = rating.toString().substring(0, rating.toString().lastIndexOf("<"));
                            
                            if (rating.indexOf("<") > 0){
                                rating = rating.toString().substring(0, rating.toString().lastIndexOf("<"));
                            }
                        }
                    } else {
                        rating = "전체 관람가";
                    }
                    
                    Elements gradeElem = doc1.select("div.main_score div.score div.star_score span.st_off span.st_on");
                    String strGrade = gradeElem.first().text().replace(" ", "");
                    
                    int c = 0;
                    for(int i = 0; i < strGrade.length(); i++){
                        char a = strGrade.charAt(i);
                        
                        if (a > 47 && a < 58){
                            c = i;
                            break;
                        }
                    }
                    strGrade = strGrade.substring(c, strGrade.length()).trim();
                    
                    if (strGrade.startsWith("관")){
                        gradeElem = doc1.select("div.star_score a#pointNetizenPersentBasic em");
                        strGrade = gradeElem.text().trim();
                        strGrade = strGrade.replace(" ", "");
                    }
                    
                    strGrade = strGrade.replace("점", "");
                    double grade = Double.parseDouble(strGrade);
                    
                    Elements timeElem = doc1.select("div.mv_info dl.info_spec dd p span");
                    String strTime = timeElem.text().trim().replace(" ", "");
                    
                    int start = 0;
                    for(int i = 0; i < strTime.length(); i++){
                        char a = strTime.charAt(i);
                        
                        if (a > 47 && a < 58){
                            start = i;
                            break;
                        }
                    }
                    String time = strTime.substring(start, strTime.indexOf("분")+1).trim();
                    
                    Elements synopsisElem = doc1.select("div.story_area p.con_tx");
                    String synopsis = synopsisElem.text();
                    synopsis = synopsis.replace("<br>", "");
                    synopsis = synopsis.replace("</br>", "");
                    
                    Elements genreElem = doc1.select("div.mv_info dl.info_spec dd p span a");
                    String genre = genreElem.first().text().trim();
                    
                    Elements PlaydateElem = doc1.select("div.mv_info dl.info_spec dd p span a");
                    String playdate = PlaydateElem.text().replace(" ", "");
                    
                    int b = 0;
                    for(int i = 0; i < playdate.length(); i++){
                        char a = playdate.charAt(i);
                        
                        if (a > 47 && a < 58){
                            b = i;
                            break;
                        }
                    }
                    playdate = playdate.substring(b, playdate.length()).trim();
                    if (playdate.length () < 10){
                        playdate = playdate + ".01";
                    }
                    playdate = playdate.replace(".", "-");
                    playdate = playdate.substring(0,10);
                    
                    MovieVO vo = new MovieVO();
                    
                    vo.setNo(k);
                    vo.setTitle(title);
                    vo.setPoster(poster);
                    vo.setDirector(director);
                    vo.setActor(actor);
                    vo.setRating(rating);
                    vo.setGrade(grade);
                    vo.setGradeCount(30000);
                    vo.setTime(time);
                    vo.setSynopsis(synopsis);
                    vo.setGenre(genre);
                    vo.setPlaydate(playdate);
                    
                    MovieManager m=new MovieManager();
                    File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SistProject3/desc.txt");
                    if(file.exists())
                        file.delete();

                    for(int n=1;n<=35;n++){
                        String json=m.naverMovie_review(vo.getTitle(), n);
                        m.parse(json);
                    }
                    
                    MovieDriver md = new MovieDriver();
                    md.movieMapReduce();
                    m.rGraph(vo);
                    

                    
                    dao.MovieInsert(vo);
                    k++;
                    
                    System.out.println(j + "완료");
                } catch(Exception ex){
                    ex.printStackTrace();
                }
           }*/
        
        MovieVO vo = new MovieVO();
        
        vo.setNo(62010);
        vo.setTitle("탐정 홍길동: 사라진 마을");
        vo.setPoster("http://image2.megabox.co.kr/mop/poster/2016/3E/F74E41-F0CE-4F17-9398-40BA7413BE28.medium.jpg");
        vo.setDirector("조성희");
        vo.setActor("이제훈, 김성균");
        vo.setRating("15 관람가");
        vo.setGrade(7.6);
        vo.setGradeCount(20460);
        vo.setTime("126분");
        vo.setSynopsis("나쁜 놈들이 판치는 세상, 새로운 히어로가 온다! 사건해결률 99%, 악당보다 더 악명 높은 탐정 홍길동에게는 20년간 찾지 못했던 단 한 사람이 있다. 그것은 바로 어머니를 죽인 원수 김병덕. 홍길동은 오랜 노력 끝에 드디어 그를 찾아내지만, 김병덕은 간발의 차로 누군가에게 납치되어 간 이후이고, 그의 집엔 두 손녀, 동이와 말순이만 덩그러니 남아 있다. 느닷없이 껌딱지처럼 들러 붙어 할아버지를 찾아달라는 두 자매를 데리고, 사라진 김병덕의 실마리를 쫓던 중, 홍길동은 대한민국을 집어 삼키려는 거대 조직 광은회의 실체를 마주하게 되는데.... 기다렸던 복수의 순간, 성가시게 판이 커져버렸다!");
        vo.setGenre("액션, 드라마");
        vo.setPlaydate("2016-05-04");
        
        MovieManager m=new MovieManager();
        File file=new File("/home/sist/bigdataStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SistProject3/desc.txt");
        if(file.exists())
            file.delete();

        for(int n=1;n<=35;n++){
            String json=m.naverMovie_review(vo.getTitle(), n);
            m.parse(json);
        }
        
        MovieDriver md = new MovieDriver();
        md.movieMapReduce();
        m.rGraph(vo);
        

        
        dao.MovieInsert(vo);
    }
}
