package com.sist.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.data.MovieDataManager;
import com.sist.mongo.RecommandDAO;
import com.sist.mongo.RecommandVO;
import java.util.*;
import com.sist.data.*;

@Controller
public class MainController {
	@Autowired
	private MovieDataManager mdm;
	
	@Autowired
	private RecommandDAO rdao;
	
	@RequestMapping("home.do")
	public String moiveHome(Model model){
		List<MovieDTO> boxList = mdm.movieAllData();
		List<String> recList = mdm.recommandMovie();
		int todayRec = (int)(Math.random()*recList.size());
		String todayRecommand = null;
		for(int i=0;i<recList.size();i++){
			if(i==todayRec){
				todayRecommand=recList.get(i);
			}
			
		}
		model.addAttribute("todayRec",todayRecommand);
		model.addAttribute("boxOffice",boxList);
		return "movie/home";
	}
	
	@RequestMapping("graph.do")
	public String graphPage(Model model){
		String[] genre = {"스릴러","드라마","사극","코미디","미스터리","로맨스","다큐멘터리","범죄","액션","공포","SF","가족"};
		
		List<RecommandVO> list = rdao.recommandTop10Data();
		
		String data = "[";
		
		for(int i = 0; i < list.size(); i++){
			RecommandVO vo = list.get(i);
			int gcount = vo.getGradeCount();
			
			if (gcount > 250000){
				data = data + "['"+vo.getTitle()+"',"+vo.getGrade()+"],";
			}

		}
		data = data.substring(0, data.lastIndexOf(","));
		data = data + "]";
		
		List<RecommandVO> alist = rdao.recommandAllData();
		int[] acount = new int[genre.length];
		
		for(RecommandVO vo : alist){
			String gen = vo.getGenre();
			
			if (gen.contains(",")){
				String a = gen.substring(0, gen.indexOf(","));
				String b = gen.substring(gen.indexOf(",")+1, gen.length());
				
				for (int i = 0; i < genre.length; i++){
					if (a.equals(genre[i])){
						acount[i] = acount[i] + 1;
					}
				}
				
				for (int i = 0; i < genre.length; i++){
					if (b.equals(genre[i])){
						acount[i] = acount[i] + 1;
					}
				}
			} else {
				for (int i = 0; i < genre.length; i++){
					if (gen.equals(genre[i])){
						acount[i] = acount[i] + 1;
					}
				}
			}
		}
		
       String data2 = "[";
		
		for(int i = 0; i < genre.length; i++){
			data2 = data2 + "{country:'"+genre[i]+"',litres:"+acount[i]+"},";
		}
		data2 = data2.substring(0, data2.lastIndexOf(","));
		data2 = data2 + "]";
		
		String data3 = "[";
		for(RecommandVO vo : alist){
			String play = vo.getPlaydate();
			if (play != ""){
				if (play.contains(" ")){
					play = play.substring(play.indexOf(" "), play.length()).trim();
					play = play.substring(0,4);
				}
				
				if (Integer.parseInt(play) > 1970){
					data3 = data3 + "["+play+","+vo.getGrade()+"],";
				}
			}
		}
		data3 = data3.substring(0, data3.lastIndexOf(","));
		data3 = data3 + "]";

		
		model.addAttribute("data1", data);
		model.addAttribute("data2", data2);
		model.addAttribute("data3", data3);
		return "movie/graph";
	}
}
