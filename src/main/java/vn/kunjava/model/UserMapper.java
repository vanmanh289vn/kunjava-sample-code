package vn.kunjava.model;

import vn.kunjava.payload.response.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        if(user == null) {
            return null;
        }
        return new UserDTO(user.getId().toString(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }
}
