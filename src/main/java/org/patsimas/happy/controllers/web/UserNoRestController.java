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
public class UserNoRestController {

	private static final Logger LOGGER = Logger.getLogger(UserNoRestController.class.getName());
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getUserPhoto/{userId}")
	public void getUserPhoto(HttpServletResponse response, @PathVariable("userId") Long userId) throws Exception {

		LOGGER.info("Get photo process begins... ");
		
        response.setContentType("image/jpeg");

        Blob ph = userService.getPictureByUserId(userId);
        System.out.println(ph);//org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap@6be47fc7
        System.out.println("-------teerss----------------");
        //ph.length();
        // in songcontests: com.mysql.cj.jdbc.Blob@61faa95e
        /*byte[] bytes = ph.getBytes(1, (int) ph.length());
        
        InputStream inputStream = new ByteArrayInputStream(bytes);
        
        IOUtils.copy(inputStream, response.getOutputStream());*/
        	
	}
	
	@RequestMapping(value = "/saveUserPhoto/{userId}")
	public String saveUserPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable("userId") Long userId) {
		
		LOGGER.info("Save photo process begins... ");
		
		userService.saveUserPhotoByUserId(userId, photo);
		
		return "redirect:/index.html";
	}

}
