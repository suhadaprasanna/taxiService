/**
 * 
 */
package gdc.taxi.datamanager.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author suhada
 *
 */
@Repository("userContactAccess")
@Transactional
public class UserContactAccess {

	private static final Logger logger = LoggerFactory.getLogger(UserCommentAccess.class);
	
}
