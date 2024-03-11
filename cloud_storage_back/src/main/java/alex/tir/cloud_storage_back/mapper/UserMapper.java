package alex.tir.cloud_storage_back.mapper;

import alex.tir.cloud_storage_back.dto.UserInfo;
import alex.tir.cloud_storage_back.entity.Role;
import alex.tir.cloud_storage_back.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "dateCreated", target = "dateRegistered")
    UserInfo mapUser(User user);

    List<UserInfo> mapUsers(Iterable<User> users);

    default String roleToString(Role role) {
        return role.getName();
    }

}