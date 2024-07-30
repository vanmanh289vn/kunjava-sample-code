package vn.kunjava.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.kunjava.configuration.Translator;
import vn.kunjava.dto.request.SampleDTO;
import vn.kunjava.dto.request.UserRequestDTO;
import vn.kunjava.dto.response.ResponseData;
import vn.kunjava.dto.response.ResponseError;
import vn.kunjava.exception.ResourceNotFoundException;
import vn.kunjava.model.User;
import vn.kunjava.model.UserMapper;
import vn.kunjava.payload.response.UserDTO;
import vn.kunjava.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Validated
@Slf4j
//@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ResponseData<?> addUser(@Valid @RequestBody UserRequestDTO user){
        log.info("Request add user, {} {}", user.getFirstName(), user.getLastName());

        try {
            long userId = userService.saveUser(user);
            return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), userId);
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add user fail");
        }
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@Min (1) @PathVariable int userId, @Valid @RequestBody UserRequestDTO userDTO){
//        log.info("Request update userId={}" + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.upd.success"));
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request change status with userId = " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User change status success by ManhPV2!");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@PathVariable int userId){
        System.out.println("Delete user with userId = " + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete user success by ManhKun");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId){
        System.out.println("Request user detail by userID");
        return new ResponseData<>(HttpStatus.OK.value(), "Get user by Id", new UserRequestDTO("Manh", "Java", "123456", "vanmanh289vn"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("Request get all users");
        return new ResponseData<>(HttpStatus.OK.value(), "Get All user", List.of(new UserRequestDTO("Kun", "Pham", "123", "kun@gmail"),
                new UserRequestDTO("Manh", "Pham", "456", "manh@gmail")));
    }

    // Tham khao --> https://github.com/bezkoder/spring-boot-jpa-paging-sorting/blob/master/src/main/java/com/bezkoder/spring/data/jpa/pagingsorting/controller/TutorialController.java

    @GetMapping("/user/all")
    public ResponseEntity<Map<String, Object>> getAll(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "6") int size
    ) {
        try {
            if (page > 0) {
                page = page - 1;
            }
            List<User> lstUsers = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageUsers = userService.findAllByKeyword(paging, keyword);
            lstUsers = pageUsers.getContent();

            List<UserDTO> users = UserMapper.toUserDTOList(lstUsers);

            Map<String, Object> response = new HashMap<>();
            response.put("items", users);
            response.put("currentPage", pageUsers.getNumber() + 1);
            response.put("totalItems", pageUsers.getTotalElements());
            response.put("totalPage", pageUsers.getTotalPages());
            response.put("pageSize", pageUsers.getSize());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
