package com.own.api.service.Implementation;

import com.own.api.dto.Entry.UserEntryDTO;
import com.own.api.dto.Modify.UserModifyDTO;
import com.own.api.dto.Out.UserOutDTO;
import com.own.api.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    @Override
    public List<UserOutDTO> list() {
        return null;
    }

    @Override
    public UserOutDTO register(UserEntryDTO product) {
        return null;
    }

    @Override
    public UserOutDTO searchForId(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserOutDTO update(UserModifyDTO product) {
        return null;
    }
}
