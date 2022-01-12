package com.example.apiConsultoriosPractica.controller;

import com.example.apiConsultoriosPractica.ApiConsultoriosPracticaApplication;
import com.example.apiConsultoriosPractica.models.User;
import com.example.apiConsultoriosPractica.modelsDTO.UserDTO;
import com.example.apiConsultoriosPractica.service.UserService;
import com.sun.deploy.net.MessageHeader;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


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

        String expected = "{name: sample,username: sample,lastName: sample,email: sample,password: sample}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }



}