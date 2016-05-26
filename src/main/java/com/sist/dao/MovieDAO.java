package com.sist.dao;

import com.mongodb.BasicDBObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class MovieDAO {
	private MongoClient mc; // Connection
	private DB db; // ORCL(DataBase)
	private DBCollection dbc; // Table�� 
	public MovieDAO(){
		try{
			
			mc=new MongoClient(new ServerAddress("211.238.142.46",27017));
			
			db=mc.getDB("movie");// use mydb
			
			dbc=db.getCollection("mymovie");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
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
	
	public List<MovieVO> movieCheck(String genre,String feel){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try{
			BasicDBObject q = new BasicDBObject();
			q.put("genre", "/"+genre+"/");
			q.put("feel", "/"+feel+"/");
			DBCursor cursor = dbc.find(q).sort(new BasicDBObject("grade",-1)).skip(1).limit(10);
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject)cursor.next();
				   MovieVO vo=new MovieVO();
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
				   list.add(vo);
			}
		}catch(Exception ex){
			System.out.println("movieCheck() error"+ex.getMessage());
		}
		return list;
	}
}
