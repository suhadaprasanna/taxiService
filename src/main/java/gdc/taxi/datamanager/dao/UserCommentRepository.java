/**
 * 
 */
package gdc.taxi.datamanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gdc.taxi.datamanager.pojo.UserComment;

/**
 * @author suhada
 *
 */
@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Long>{

}
