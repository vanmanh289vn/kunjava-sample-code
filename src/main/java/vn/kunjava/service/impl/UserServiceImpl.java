package vn.kunjava.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.kunjava.dto.request.AddressDTO;
import vn.kunjava.dto.request.UserRequestDTO;
import vn.kunjava.dto.response.UserDetailResponse;
import vn.kunjava.exception.ResourceNotFoundException;
import vn.kunjava.model.User;
import vn.kunjava.repository.UserRepository;
import vn.kunjava.service.UserService;
import vn.kunjava.util.UserStatus;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        System.out.println("==============> Thuc hien xu ly create data");
        if (!"Kun".equals(requestDTO.getFirstName())) {
            throw new ResourceNotFoundException("Khong ton tai gia tri firstname nay ...");
        }

        return 0;
    }

    @Override
    public long saveUser(UserRequestDTO request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername("MTP");
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(new Date());
        user.setGender("Male");
        user.setPhone("0969067228");
        user.setActive(1);
        user.setType("developer");
        user.setCreatedBy("ManhPV2");
        user.setUpdatedBy("ManhPV2");

        userRepository.save(user);
        log.info("User have saved!");

        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDTO request) {

    }

    @Override
    public void changeStatus(long userId, UserStatus status) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        return null;
    }

    @Override
    public List<UserDetailResponse> getAllUsers(int pageNo, int pageSize) {
        return List.of();
    }

    @Override
    public Page<User> findAllByKeyword(Pageable pageable, String keyword) {

        return userRepository.findAllByKeyword(pageable, keyword);
    }


//    private Set<Adress> convertToAddress(Set<AddressDTO> addresses) {
//
//    }

}
