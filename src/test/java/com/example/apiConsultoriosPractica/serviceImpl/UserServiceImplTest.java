//package com.example.apiConsultoriosPractica.serviceImpl;
//
//import com.example.apiConsultoriosPractica.modelsDTO.UserDTO;
//import com.example.apiConsultoriosPractica.repository.UserRepository;
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserServiceImpl userServiceImpl;
//
//
//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//
//        /*CompletableFuture resultado = new CompletableFuture();
//        resultado = CompletableFuture<List<UserDTO>>;
//        //when(userServiceImpl.getAll()).thenReturn()*/
//    }
//
//    @Test
//    public void testGetAll(){
//        /*List<UserDTO> usersDTO = new ArrayList<>();
//        usersDTO.add(user1);
//        usersDTO.add(user2);
//        usersDTO.add(user3);
//        usersDTO.add(user4);*/
//        UserDTO userdto = new UserDTO();
//        userdto.setName("Alan");
//        userdto.setEmail("sample");
//        userdto.setPassword("sample");
//        userdto.setUsername("sample");
//        userdto.setLastName("sample");
//
//
////        when(userRepository.findAll()).thenReturn(CompletableFuture.completedFuture(List<UserDTO>));
//
//
//
//        CompletableFuture<List<UserDTO>> result = userServiceImpl.getAllDTO();
//        /*assertEquals(4, anyList().size());
//        assertThat(result).has*/
//        //result.thenAccept(user4 -> usersDTO.add((UserDTO) user4));
//        Thread.currentThread().start();
//        //assertEquals(4,userServiceImpl.getAllDTO().equals(result));
////        return CompletableFuture.completedFuture(assertThat(com))
//    }
//
//
//
//
//
//
//}