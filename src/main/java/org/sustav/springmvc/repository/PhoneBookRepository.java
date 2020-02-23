package org.sustav.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sustav.springmvc.entity.user.User;

/**
 * @author Anton Sustavov
 * @since 2020/02/12
 */
@Repository
public interface PhoneBookRepository extends JpaRepository<User, Long> {
//    @Override
//    List<User> findAll();
}
