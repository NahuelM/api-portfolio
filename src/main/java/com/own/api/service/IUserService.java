package com.own.api.service;



import com.own.api.dto.Entry.UserEntryDTO;
import com.own.api.dto.Modify.UserModifyDTO;
import com.own.api.dto.Out.UserOutDTO;

import java.util.List;

public interface IUserService {

    List<UserOutDTO> list();

    UserOutDTO register(UserEntryDTO product);

    UserOutDTO searchForId(Long id);

    void delete(Long id);

    UserOutDTO update(UserModifyDTO product);
}
