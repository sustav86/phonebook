package org.sustav.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sustav.springmvc.entity.Role;
import org.sustav.springmvc.entity.User;
import org.sustav.springmvc.repository.RoleRepository;
import org.sustav.springmvc.repository.UserRepository;

import javax.persistence.EntityExistsException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Anton Sustavov
 * @since 2020/02/20
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public User saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            throw new EntityExistsException("User exist");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public User findUserByName(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Page<User> allUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public boolean saveAll(List<User> users) {
        users.forEach(user -> {
            user.setRoles(Collections.singleton(new Role("ROLE_RESGISTERED_USER")));
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        });
        userRepository.saveAll(users);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

}
