package com.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.dao.GameDaoImp;
import com.game.dto.GameInfo;
import com.game.dto.GamePackage;

@Controller
public class DownloadController {
	
	@Autowired
	GameDaoImp gameDaoImp;
	
	@RequestMapping(name="upload",method=RequestMethod.GET) //mapping index page 
	public String getDownloadLink(@ModelAttribute(name="user") GamePackage gamePackage,Model model) {	//method to get download link
		System.out.println("Package Name:"+gamePackage.getPackageName());
		
		List<GameInfo> link=gameDaoImp.checkLink(gamePackage.getPackageName());	//calling dao to fetch data
		if(link!=null)
			{
			for (GameInfo gameInfo : link) {
				//passing data to view ie. jsp
				model.addAttribute("gameName",gameInfo.getGameName());
				model.addAttribute("link",gameInfo.getDownloadLink());
				model.addAttribute("packageName",gameInfo.getPackageName());
			}
			return "download";
			}
		else
		return "error";
	}

}
