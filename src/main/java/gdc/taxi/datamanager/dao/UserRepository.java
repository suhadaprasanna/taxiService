/**
 * 
 */
package gdc.taxi.datamanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.taxi.datamanager.pojo.User;

/**
 * @author suhada
 *
 */
@Repository("UserRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

}
