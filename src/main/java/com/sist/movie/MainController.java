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
		RecommandVO todayVO = rdao.todayRecommand(todayRecommand);
		model.addAttribute("todayVO",todayVO);
		model.addAttribute("boxOffice",boxList);
		return "movie/home";
	}

	@RequestMapping("searchTitle.do")
	public String searchTitle(String title,Model model){
		System.out.println("contorller"+title);
		List<RecommandVO> list = rdao.searchTitle(title);
		model.addAttribute("list",list);
		return "movie/list";
	}
	
	@RequestMapping("graph.do")
	public String graphPage(Model model){
		List<RecommandVO> list = rdao.recommandAllData();
		model.addAttribute("list", list);
		return "movie/graph";

	}
	@RequestMapping("detail.do")
	public String detail(int no,Model model){
		System.out.println(no);
		String[] color={"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215","#0D8ECF","#0D52D1"
				,"#2A0CD0","#8A0CCF","#CD0D74","#754DEB","#DDDDDD","#999999","#333333","#000000"};
		int colorCnt=0;
		RecommandVO vo = rdao.detailAllData(no);
		model.addAttribute("vo",vo);
		StringTokenizer stf = new StringTokenizer(vo.getFeel(), ",");
		StringTokenizer stc = new StringTokenizer(vo.getCount(), ",");
		String chart="[";
		while(stf.hasMoreTokens()){
			if(colorCnt>16){
				colorCnt=0;
			}
			chart+="{'감성':'"+stf.nextToken()+"','숫자':"+stc.nextToken()+",'color':'"+color[colorCnt]+"'},";
			colorCnt++;
		}
		chart = chart.substring(0,chart.lastIndexOf(','));
		chart+="],";
		model.addAttribute("chart",chart);
		System.out.println(chart);
		return "movie/detail";
	}
	
	@RequestMapping("movieCheck.do")
	public String movieCheck(Model model,String optionsRadios,String optionsRadios2){
		System.out.println("장르 : "+optionsRadios+"감성 : "+optionsRadios2);
		List<RecommandVO> list = rdao.movieCheck(optionsRadios, optionsRadios2);
		model.addAttribute("list", list);
		return "movie/list";
	}
}
