package com.game.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.game.dao.GameDaoImp;
import com.game.dto.GameInfo;
import com.game.dto.GamePackage;

@Controller
public class DownloadController {

	@Autowired
	GameDaoImp gameDaoImp;

	/*@RequestMapping(name = "upload", method = RequestMethod.GET) // mapping
																	// index
																	// page
	public String getDownloadLink(@ModelAttribute(name = "upload") GamePackage gamePackage, Model model) { // method
																											// to
																											// get
																											// download
																											// link
		System.out.println("Package Name:" + gamePackage.getPackageName());

		List<GameInfo> link = gameDaoImp.checkLink(gamePackage.getPackageName()); // calling
																					// dao
																					// to
																					// fetch
																					// data
		if (link != null) {
			for (GameInfo gameInfo : link) {
				// passing data to view ie. jsp
				model.addAttribute("gameName", gameInfo.getGameName());
				model.addAttribute("link", gameInfo.getDownloadLink());
				model.addAttribute("packageName", gameInfo.getPackageName());
			}
			return "download";
		} else
			return "error";
	}
*/
	@RequestMapping(value="uploadFile",method=RequestMethod.POST)
	public @ResponseBody String uploadFile( @RequestParam("file") MultipartFile file, Model model) {
		String name="asdfgh";
		if (!file.isEmpty()) {
			try {
				//Getting data
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File("/home/bridgelabz6/Pictures" + File.separator + "uploads");
				
				System.out.println(dir);
				if (!dir.exists())
					dir.mkdirs();
				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name.concat(".csv"));
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				stream.flush();

				//Reading uploaded file
				BufferedReader br=new BufferedReader(new FileReader(serverFile));
				String line=br.readLine();
				while(line!=null)
				{
				System.out.println(line);
				line=br.readLine();
				}
				br.close();
				
				//logger.info("Server File Location=" + serverFile.getAbsolutePath());
				model.addAttribute("msg","You successfully uploaded file");
				return "uploadFile";
			} catch (Exception e) {
				return "error";
			}
		} else {
			return "error";
		}
	}

}
