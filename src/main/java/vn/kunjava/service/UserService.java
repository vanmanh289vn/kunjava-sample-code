package vn.kunjava.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.kunjava.dto.request.UserRequestDTO;
import vn.kunjava.dto.response.UserDetailResponse;
import vn.kunjava.model.User;
import vn.kunjava.util.UserStatus;

import java.util.List;

public interface UserService {

    int addUser(UserRequestDTO requestDTO);

    long saveUser(UserRequestDTO request);

    void updateUser(long userId, UserRequestDTO request);

    void changeStatus(long userId, UserStatus status);

    void deleteUser(long userId);

    UserDetailResponse getUser(long userId);

    List<UserDetailResponse> getAllUsers(int pageNo, int pageSize);

    Page<User> findAllByKeyword(Pageable pageable, String keyword);
}
