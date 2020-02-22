package org.sustav.springmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.sustav.springmvc.entity.User;

import java.util.List;

/**
 * @author Anton Sustavov
 * @since 2020/02/12
 */
@Repository
public interface PhoneBookRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();
}
