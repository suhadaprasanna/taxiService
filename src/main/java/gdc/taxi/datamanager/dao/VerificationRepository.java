/**
 * 
 */
package gdc.taxi.datamanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdc.taxi.datamanager.pojo.Verification;

/**
 * @author suhada
 *
 */
@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {

}
