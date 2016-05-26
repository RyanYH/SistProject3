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
}









