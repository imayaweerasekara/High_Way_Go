package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.UserDTO;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

}
