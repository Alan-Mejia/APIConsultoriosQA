

package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import static java.util.Collections.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static javafx.beans.binding.Bindings.when;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = UserController.class, useDefaultFilters = false)
//@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup(){

    }

    @Test
    public void shouldFetchAll()throws Exception{
        List<User> listaUsuarios = new ArrayList<>();
        User usuario1 = new User();
        usuario1.setPassword("sample");
        usuario1.setUsername("sample");
        usuario1.setEmail("sample");
        usuario1.setLastName("sample");
        usuario1.setRole(1);
        usuario1.setName("sample");
        usuario1.setSurname("sample");

        Mockito.when(userService.getAll()).thenReturn(CompletableFuture.completedFuture(listaUsuarios));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/api/v1/users/dto/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
    String expected =
                            "{"+
                                "\"name\":\"sample\"," +
                                "\"username\":\"sample\"," +
                                "\"lastName\":\"sample\"," +
                                "\"email\":\"sample\"," +
                                "\"password\":\"sample\"" +
                            "}";
//
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
////


    }

    @Test
    public void createNewUser(){
        User userDTO = new User();
        userDTO.setName("sample2");
        userDTO.setUsername("sample");
        userDTO.setLastName("sample");
        userDTO.setEmail("sample");
        userDTO.setPassword("sample");

//        Mockito.when()
    }


    @Test
    public void getOneUser() throws Exception{
        Long id = 1L;
//        CompletableFuture<User> getUser= CompletableFuture.supplyAsync((id)->userService.getById(id));
        Date fecha1 = new Date();
        fecha1.getDate();
        User user = new User();
        user.setId(id);
        user.setStatus(1);
        user.setCreationTime(fecha1);
        user.setModificationTime(fecha1);
        user.setUserModifier("sample");
        user.setUserCreator("sample");
        user.setName("sample");
        user.setLastName("sample");
        user.setSurname("sample");
        user.setEmail("sample");
        user.setRole(1);
        user.setUsername("sample");
        user.setPassword("sample");

//
//        "id": 29,
//                "status": 1,
//                "creationTime": "2008-05-31T20:06:50.000+00:00",
//                "modificationTime": "2008-05-31T20:06:50.000+00:00",
//                "userModifier": "creator",
//                "userCreator": "manager",
//                "name": "Sebas",
//                "lastName": "Jrt",
//                "surname": "Sample",
//                "email": "bto@gmail.com",
//                "role": 1,
//                "username": "root",
//                "password": "$2a$10$JfxrNiw3kQfToNRNRV3fe.asDfam7B/ZWAmxGh.cZG.QFto38um7O"


        CompletableFuture<User> usr1 = userService.getById(id);
    Mockito.when(userService.getById(Mockito.anyLong())).thenReturn(usr1);

            mockMvc.perform(get("http://localhost:8080/api/v1/users/1").accept(MediaType.APPLICATION_JSON))
                    //.andExpect(jsonPath("$.id", Matchers.is(1)))
                    .andExpect(status().isOk());





    }


//    public CompletableFuture<T> getById(ID id) {
//        System.out.println( Thread.currentThread().getName());
//        return CompletableFuture.completedFuture(genericRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "Id", id)));
//    }
    @Test
    public void shouldGetOnlyOne()throws Exception{

        CompletableFuture<User> usr1 = userService.getById(29L);
        Mockito.when(userService.getById(29L)).thenReturn(usr1).thenAnswer(ResponseEntity::ok);
        mockMvc.perform(get("http://localhost:8080/api/v1/users/29")).andExpect(status().isOk());

    }

    @Test
    public void allUserTest() throws Exception{
        Date fecha1 = new Date();
        User user = new User();
        user.setId(1L);
        user.setStatus(1);
        user.setCreationTime(fecha1);
        user.setModificationTime(fecha1);
        user.setUserModifier("sample");
        user.setUserCreator("sample");
        user.setName("sample");
        user.setLastName("sample");
        user.setSurname("sample");
        user.setEmail("sample");
        user.setRole(1);
        user.setUsername("sample");
        user.setPassword("sample");
        List<User> all = new ArrayList<>();
        all.add(user);
        Mockito.when(userService.getAll()).thenReturn(CompletableFuture.completedFuture(all));

        String expected = "";
                this.mockMvc.perform(get("http://localhost:8080/api/v1/users/dto/"))
                        .andDo(print())
                        .andExpect(content().string(expected))
                        .andExpect(status().isOk());

    }


}