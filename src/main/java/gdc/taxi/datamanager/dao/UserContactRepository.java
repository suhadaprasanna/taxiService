/**
 * 
 */
package gdc.taxi.datamanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdc.taxi.datamanager.pojo.UserContact;

/**
 * @author suhada
 *
 */
@Repository
public interface UserContactRepository extends JpaRepository<UserContact, Long>{

}
