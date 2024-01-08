package com.own.api.service.Implementation;

import com.own.api.dto.Entry.UserEntryDTO;
import com.own.api.dto.Modify.UserModifyDTO;
import com.own.api.dto.Out.UserOutDTO;
import com.own.api.model.User;
import com.own.api.repository.imp.UserRepository;
import com.own.api.service.IUserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserOutDTO> list() {
        List<UserOutDTO> users = userRepository.findAll().stream()
                .map(c -> modelMapper.map(c, UserOutDTO.class)).toList();

        LOGGER.info("list of all users: {}", users);
        return users;
    }

    @Override
    public UserOutDTO register(UserEntryDTO product) {
        User userSaved = userRepository.save(dtoInToEntity(product));
        UserOutDTO userOutDTO = modelMapper.map(userSaved, UserOutDTO.class);
        LOGGER.info("Category Saved: {}", userSaved);
        return userOutDTO;
    }

    @Override
    public UserOutDTO searchForId(Long id) {
        User userSearched = userRepository.findById(id).orElse(null);
        UserOutDTO userOutDTO = null;
        if(userSearched != null){
            userOutDTO = modelMapper.map(userSearched, UserOutDTO.class);
            LOGGER.info("User: {}", userOutDTO);
        }
        else
            LOGGER.error("id not valid for user");
        return userOutDTO;
    }

    @Override
    public void delete(Long id) {
        if (searchForId(id) != null) {
            userRepository.deleteById(id);
            LOGGER.warn("eliminated user with id: {}", id);
        }
        else {
            LOGGER.error("user not found {}", id);
        }
    }

    @Override
    public UserOutDTO update(UserModifyDTO user) {
        User userReceived = modelMapper.map(user, User.class);
        User userToUpdate = userRepository.findById(user.getId()).orElse(null);
        UserOutDTO userOutDTO = null;

        if (userToUpdate != null) {

            userToUpdate = userReceived;
            userRepository.save(userToUpdate);

            userOutDTO = modelMapper.map(userToUpdate, UserOutDTO.class);

            LOGGER.warn("user updated: {}", userOutDTO);

        } else {
            LOGGER.error("user not registered");

        }
        return userOutDTO;
    }

    private User dtoInToEntity(UserEntryDTO userEntryDTO) {
        return modelMapper.map(userEntryDTO, User.class);
    }
}
