/**
 * 
 */
package gdc.taxi.datamanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdc.taxi.datamanager.pojo.UserType;

/**
 * @author suhada
 *
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer>{

}
