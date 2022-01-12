package com.example.apiConsultoriosPractica.modelsDTO;

import com.example.apiConsultoriosPractica.models.User;
import org.modelmapper.ModelMapper;

public class GenericMapperDTO {

    private final ModelMapper modelMapper = new ModelMapper();

    private static GenericMapperDTO genericMapperDTO;

    private GenericMapperDTO(){}

    public static GenericMapperDTO singleInstance(){
        if(genericMapperDTO == null){
            genericMapperDTO = new GenericMapperDTO();
        }
        return genericMapperDTO;
    }

    public UserDTO mapToSimpleUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }


}
