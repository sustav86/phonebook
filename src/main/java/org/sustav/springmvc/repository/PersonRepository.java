package org.sustav.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sustav.springmvc.entity.person.Person;

/**
 * @author Anton Sustavov
 * @since 2020/02/23
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
