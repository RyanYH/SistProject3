package com.sist.mongo;

import org.springframework.stereotype.Repository;
import com.mongodb.*;
import com.sist.dao.MovieVO;

import java.util.*;

@Repository
public class RecommandDAO {
	 private MongoClient mc;
	 private DB db;
	 private DBCollection dbc;
	 
	 public RecommandDAO(){
		 try{
			 mc=new MongoClient("211.238.142.46", 27017);
			 db=mc.getDB("movie");
			 dbc=db.getCollection("mymovie");
		 }catch(Exception ex){
			 System.out.println(ex.getMessage());
		 }
	 }
	 
	 public List<RecommandVO> recommandAllData() {
		 List<RecommandVO> list = new ArrayList<RecommandVO>();
		 try{
			 DBCursor cursor=dbc.find();
			 while(cursor.hasNext()){
				 BasicDBObject obj=(BasicDBObject)cursor.next();
				 RecommandVO vo=new RecommandVO();

				 list.add(vo);
			 }
			 cursor.close();
		 }catch(Exception ex){
			 System.out.println(ex.getMessage());
		 }
		 return list;
	 }
	 public List<RecommandVO> searchTitle(String title){
		 List<RecommandVO> list = new ArrayList<RecommandVO>();
		 try{
		 BasicDBObject where = new BasicDBObject();
		 where.put("title",  java.util.regex.Pattern.compile(title));
		 
		 DBCursor cursor = dbc.find(where).sort(new BasicDBObject("gradecount",-1).append("grade", -1)).skip(1).limit(20);;
		 while(cursor.hasNext()){
			 BasicDBObject obj = (BasicDBObject)cursor.next();
			 RecommandVO vo = new RecommandVO();
			 vo.setNo(obj.getInt("no"));
			 vo.setTitle(obj.getString("title"));
			 vo.setActor(obj.getString("actor"));
			 vo.setDirector(obj.getString("director"));
			 vo.setRating(obj.getString("rating"));
			 vo.setGrade(obj.getDouble("grade"));
			 vo.setSynopsis(obj.getString("synopsis"));
			 vo.setPoster(obj.getString("poster"));
			 
			 list.add(vo);
		 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
		 return list;
	 }
	 public RecommandVO detailAllData(int no){
		 RecommandVO vo = new RecommandVO();
		 try{
			 BasicDBObject where = new BasicDBObject();
			 where.put("no", no);
			 BasicDBObject res = (BasicDBObject)dbc.findOne(where);
			 vo.setNo(res.getInt("no"));
			 vo.setTitle(res.getString("title"));
			 vo.setRating(res.getString("rating"));
			 vo.setPoster(res.getString("poster"));
			 vo.setDirector(res.getString("director"));
			 vo.setActor(res.getString("actor"));
			 vo.setTime(res.getString("time"));
			 vo.setSynopsis(res.getString("synopsis"));
			 vo.setPlaydate(res.getString("playdate"));
			 vo.setGenre(res.getString("genre"));
			 vo.setGrade(res.getDouble("grade"));
			 vo.setFeel(res.getString("feel"));
			 vo.setCount(res.getString("count"));
			 vo.setGradeCount(res.getInt("gradecount"));
			 
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
		 return vo;
	 }
	 public void MovieInsert(MovieVO vo){
			int no=0;
			int group_id=0;
			DBCursor cursor=dbc.find();
			while(cursor.hasNext()){
				BasicDBObject data=(BasicDBObject)cursor.next();
				int n=data.getInt("no");
				if(no<n)
					no=n;
			}
			cursor.close();
			BasicDBObject query=new BasicDBObject();
			query.put("no", vo.getNo());
			query.put("title", vo.getTitle());
			query.put("rating", vo.getRating());
			query.put("poster", vo.getPoster());
			query.put("director", vo.getDirector());
			query.put("actor", vo.getActor());
			query.put("time", vo.getTime());
			query.put("synopsis", vo.getSynopsis());
			query.put("playdate", vo.getPlaydate());
			query.put("genre", vo.getGenre());
			query.put("grade", vo.getGrade());
			query.put("feel", vo.getFeel());
			query.put("count", vo.getCount());
			query.put("gradecount", vo.getGradeCount());
			dbc.insert(query);
			
		}
		
		public List<RecommandVO> movieCheck(String genre,String feel){
			List<RecommandVO> list = new ArrayList<RecommandVO>();
			try{
				BasicDBObject q = new BasicDBObject();
				BasicDBObject qq = new BasicDBObject();
				q.put("genre", java.util.regex.Pattern.compile(genre));
				q.put("feel", java.util.regex.Pattern.compile(feel));
				DBCursor cursor = dbc.find(q).sort(new BasicDBObject("gradecount",-1).append("grade", -1)).skip(1).limit(20);
				while(cursor.hasNext()){
					BasicDBObject obj = (BasicDBObject)cursor.next();
				   RecommandVO vo=new  RecommandVO();
				   vo.setNo(obj.getInt("no"));
				   vo.setTitle(obj.getString("title"));
				   vo.setRating(obj.getString("rating"));
				   vo.setPoster(obj.getString("poster"));
				   vo.setDirector(obj.getString("director"));
				   vo.setActor(obj.getString("actor"));
				   vo.setTime(obj.getString("time"));
				   vo.setSynopsis(obj.getString("synopsis"));
				   vo.setPlaydate(obj.getString("playdate"));
				   vo.setGenre(obj.getString("genre"));
				   vo.setGrade(obj.getDouble("grade"));
				   vo.setFeel(obj.getString("feel"));
				   vo.setCount(obj.getString("count"));
				   vo.setGradeCount(obj.getInt("gradecount"));
				   list.add(vo);
				   System.out.println("no : "+obj.getInt("no"));
				}
			}catch(Exception ex){
				System.out.println("movieCheck() error : "+ex.getMessage());
			}
			return list;
		}
}









