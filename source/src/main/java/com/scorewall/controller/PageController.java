package com.scorewall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/page")
public class PageController {
	
	/**
	 * 设置通用页面访问控制器，页面访问 /page/{pageName}，跳转到views下的pageName.jsp
	 * 
	 * @param pageName
	 * @return
	 */
	@RequestMapping("/{pageName}")
	public String toPage(@PathVariable("pageName")String pageName){
		return pageName;
	}
	
	
	
	
}
