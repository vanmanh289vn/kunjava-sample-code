package vn.kunjava.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import vn.kunjava.model.Address;
import vn.kunjava.util.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static vn.kunjava.util.Gender.*;

public class UserRequestDTO implements Serializable {

    private String username;

    private String password;

    @NotBlank(message = "firstName must be not blank")
    private String firstName;

    @NotNull(message = "lastName must be not null")
    private String lastName;

//    @Pattern(regexp = "^\\d{10}$", message = "Phone invalid format..")
//    @PhoneNumber
    private String phone;

    @Email(message = "Email invalid format ")
    private String email;

//    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;

//    @GenderSubset(anyOf = {MALE, FEMALE, OTHER})
//    @GenderSubset(anyOf = {MALE, FEMALE})
    private Gender gender;

//    @NotNull(message = "type must be not null")
//    @EnumValue(name = "type", enumClass = UserType.class)
    private String type;

//    @NotEmpty
    private Set<AddressDTO> addressesDto = new HashSet<>();

//    @NotEmpty
    private List<String> permission;

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public @EnumValue(name = "type", enumClass = UserType.class) String getType() {
        return type;
    }

    public Gender getGender() {
        return gender;
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "firstName must be not blank") String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "lastName must be not null") String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email invalid format ") String email) {
        this.email = email;
    }

    public void setStatus(@EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE") UserStatus status) {
        this.status = status;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setType(@EnumValue(name = "type", enumClass = UserType.class) String type) {
        this.type = type;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public Set<AddressDTO> getAddressesDto() {
        return addressesDto;
    }

    public void setAddressesDto(Set<AddressDTO> addressesDto) {
        this.addressesDto = addressesDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
