package org.patsimas.happy;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.patsimas.happy.domain.Role;
import org.patsimas.happy.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {HappyApplication.class})
public class UserControllerTest {

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation  =
            new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;
    
    private static final Long userToFindOrUpdate = 4L;

    private static final Long userToDelete = 4L;

    private MockMvc mockMvc;


    @Before
    public void setUp(){
        this.mockMvc =
                MockMvcBuilders.webAppContextSetup(this.context)
                        .apply(documentationConfiguration(this.jUnitRestDocumentation ))
                        .alwaysDo(document("{class-name}/{method-name}",
                                preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                        .build();
    }
    
//    @Test
//    public void createNewUser() throws Exception {
//
//    	UserDto user = new UserDto();
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.post("/user")
//                        .content(asJsonString(user)).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists());
//
//    }

    @Test
    public void updateUser() throws Exception {
    	
    	List<Role> roles = new ArrayList<>();
    	
    	roles.add(Role.ADMIN);
    	roles.add(Role.EMPLOYEE);
    	
    	UserDto userDto = new UserDto(userToFindOrUpdate, "andyqwwe", "aaappp", "andymvchgfi@gmail.com", null, new Date(), null, 
    			"Andy", "Pats", roles);

        this.mockMvc.perform(
                MockMvcRequestBuilders.put("/user")
                        .content(asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists());

    }

    @Test
    public void findAllUsers() throws Exception {
        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        System.out.println(this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void findUserById() throws Exception {
        this.mockMvc.perform(get("/user/{userId}",userToFindOrUpdate))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(userToFindOrUpdate));
    }
    
    @Test
    public void findImageByUserId() throws Exception {
        this.mockMvc.perform(get("/image/{userId}",userToFindOrUpdate))
                .andExpect(status().isOk())
                .andExpect(content().contentType("image/*"));
    }
    
    @Test
    public void exportDynamicListDetails() throws Exception {
        this.mockMvc.perform(get("/export"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv; charset=utf-8"));

        System.out.println(this.mockMvc.perform(get("/export"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/csv; charset=utf-8")).andReturn().getResponse().getContentAsString());
    }

    @Test
    public void deleteUser() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/deleteUser/{userId}", userToDelete))
                .andExpect(status().isOk());

    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
