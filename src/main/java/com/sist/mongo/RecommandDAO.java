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
			 mc=new MongoClient("211.238.142.22", 27017);
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
		 
		 DBCursor cursor = dbc.find(where);
		 while(cursor.hasNext()){
			 BasicDBObject obj = (BasicDBObject)cursor.next();
			 RecommandVO vo = new RecommandVO();
			 vo.setNo(obj.getInt("no"));
			 vo.setTitle(obj.getString("title"));
			 vo.setActor(obj.getString("actor"));
			 vo.setDirector(obj.getString("director"));
			 vo.setRating(obj.getString("rating"));
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
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
		 return vo;
	 }
}









