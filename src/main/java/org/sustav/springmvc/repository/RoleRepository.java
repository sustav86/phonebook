package org.sustav.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sustav.springmvc.entity.Role;

/**
 * @author Anton Sustavov
 * @since 2020/02/20
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
