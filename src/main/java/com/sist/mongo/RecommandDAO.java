package com.sist.mongo;

import org.springframework.stereotype.Repository;
import com.mongodb.*;
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
				 
				 vo.setNo(obj.getInt("no"));
				 vo.setTitle(obj.getString("title"));
				 vo.setActor(obj.getString("actor"));
				 vo.setCount(obj.getString("count"));
				 vo.setDirector(obj.getString("director"));
				 vo.setFeel(obj.getString("feel"));
				 vo.setGenre(obj.getString("genre"));
				 vo.setGrade(obj.getDouble("grade"));
				 vo.setPlaydate(obj.getString("playdate"));
				 vo.setPoster(obj.getString("poster"));
				 vo.setRating(obj.getString("rating"));
				 vo.setSynopsis(obj.getString("synopsis"));
				 vo.setTime(obj.getString("time"));
				 vo.setGradeCount(obj.getInt("gradecount"));
				 
				 list.add(vo);
			 }
			 cursor.close();
		 }catch(Exception ex){
			 System.out.println(ex.getMessage());
		 }
		 return list;
	 }
	 
	 public List<RecommandVO> recommandTop10Data() {
		 List<RecommandVO> list = new ArrayList<RecommandVO>();
		 try{
			 BasicDBObject orderBy=new BasicDBObject();
			 orderBy.clear();
			 orderBy.put("grade", -1);
			 
			 DBCursor cursor=dbc.find().sort(orderBy);
			 
			 while(cursor.hasNext()){
				 BasicDBObject obj=(BasicDBObject)cursor.next();
				 RecommandVO vo=new RecommandVO();
				 
				 vo.setNo(obj.getInt("no"));
				 vo.setTitle(obj.getString("title"));
				 vo.setActor(obj.getString("actor"));
				 vo.setCount(obj.getString("count"));
				 vo.setDirector(obj.getString("director"));
				 vo.setFeel(obj.getString("feel"));
				 vo.setGenre(obj.getString("genre"));
				 vo.setGrade(obj.getDouble("grade"));
				 vo.setPlaydate(obj.getString("playdate"));
				 vo.setPoster(obj.getString("poster"));
				 vo.setRating(obj.getString("rating"));
				 vo.setSynopsis(obj.getString("synopsis"));
				 vo.setTime(obj.getString("time"));
				 vo.setGradeCount(obj.getInt("gradecount"));
				 
				 list.add(vo);
			 }
			 cursor.close();
		 }catch(Exception ex){
			 System.out.println(ex.getMessage());
		 }
		 return list;
	 }
}









