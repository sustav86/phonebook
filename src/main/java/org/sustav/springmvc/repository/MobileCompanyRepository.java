package org.sustav.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sustav.springmvc.entity.PhoneCompany;

/**
 * @author Anton Sustavov
 * @since 2020/02/27
 */
@Repository
public interface MobileCompanyRepository extends JpaRepository<PhoneCompany, Long> {
}
