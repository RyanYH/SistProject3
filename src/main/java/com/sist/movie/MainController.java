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
				
				if (play.contains("-")){
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
