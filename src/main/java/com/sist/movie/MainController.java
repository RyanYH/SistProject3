package com.sist.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("home.do")
	public String moiveHome(){
		return "movie/home";
	}
}
