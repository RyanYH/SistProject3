package com.sist.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.data.MovieDataManager;
import com.sist.mongo.RecommandDAO;
import com.sist.mongo.RecommandVO;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.data.*;

@Controller
public class MainController {
	@Autowired
	private MovieDataManager mdm;
	@Autowired
	private MovieDAO dao;
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
		List<RecommandVO> list = rdao.recommandAllData();
		model.addAttribute("list", list);
		return "movie/graph";
	}
	
	@RequestMapping("movieCheck.do")
	public String movieCheck(Model model,HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		String genre = request.getParameter("optionsRadios");
		String feel = request.getParameter("optionsRadios2");
		System.out.println("장르 : "+genre+"감성 : "+feel);
		List<MovieVO> list = dao.movieCheck(genre, feel);
		model.addAttribute("list", list);
		return "movie/list";
	}
}
