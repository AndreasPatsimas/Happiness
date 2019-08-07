package org.patsimas.happy.controllers.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.patsimas.happy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

	private static final Logger LOGGER = Logger.getLogger(ImageController.class.getName());
	
	@Autowired
	UserService userService;
			
	
	@RequestMapping(value = "/saveUserPhoto/{userId}")
	public String saveUserPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable("userId") Long userId) {
		
		LOGGER.info("Save photo process begins... ");
		
		userService.saveUserPhotoByUserId(userId, photo);
		
		return "redirect:/index.html";
	}

}
