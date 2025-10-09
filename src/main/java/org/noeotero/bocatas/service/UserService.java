package org.noeotero.bocatas.service;

import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.mapper.BeanMapper;
import org.noeotero.bocatas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeanMapper mapper;

    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username).map(mapper::toDto).orElse(null);
    }
}
