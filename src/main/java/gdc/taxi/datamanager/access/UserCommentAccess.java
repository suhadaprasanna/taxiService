/**
 * 
 */
package gdc.taxi.datamanager.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.taxi.datamanager.dao.UserCommentRepository;
import gdc.taxi.datamanager.pojo.UserComment;
import gdc.taxi.service.UserService;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
@Repository("userCommentAccess")
@Transactional
public class UserCommentAccess {

	private static final Logger logger = LoggerFactory.getLogger(UserCommentAccess.class);
	
	@Autowired
	private UserCommentRepository userCommentRepository;
	
	public DataTransfer save(DataTransfer dataTrans) {
		logger.debug("------>>start save<<------");
		UserComment userComment= (UserComment)dataTrans.getInput("pojo_user_comment");
		try {
		this.userCommentRepository.save(userComment);
		if(userComment.getId()>0) {
			dataTrans.setStatus(Status.SUCCESS);
			dataTrans.addOutput(Key.MESSAGE, "save success");
		}else {
			dataTrans.setStatus(Status.FAIL);
			dataTrans.addOutput(Key.MESSAGE, "save failed");
		}
		}catch (Exception e) {
			dataTrans.setStatus(Status.ERROR);
			dataTrans.addOutput(Key.ERROR, "something went wrong");
		}
		logger.debug("------>>end save<<------");
		return dataTrans;
	}
}
