package vn.hoidanit.laptopshop.services;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String handldeHello() {
        return "hello";
    } // file jsp


    public User handleCreateUser(User user) {
        User newUser = this.userRepository.save(user);
        return newUser;
    }
}
