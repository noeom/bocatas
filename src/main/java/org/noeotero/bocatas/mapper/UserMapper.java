package org.noeotero.bocatas.mapper;

import org.mapstruct.Mapper;
import org.noeotero.bocatas.dto.UserDTO;
import org.noeotero.bocatas.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
}
