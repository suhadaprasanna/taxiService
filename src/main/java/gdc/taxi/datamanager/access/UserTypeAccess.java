/**
 * 
 */
package gdc.taxi.datamanager.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.taxi.datamanager.dao.UserTypeRepository;
import gdc.taxi.datamanager.pojo.UserType;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
@Repository("userTypeAccess")
@Transactional
public class UserTypeAccess {
	
	private static final Logger logger = LoggerFactory.getLogger(UserTypeAccess.class);

	@Autowired
	private UserTypeRepository userTypeRepository;
	
	public DataTransfer save(DataTransfer dataTrans) {
		logger.debug("------>>start save<<------");
		UserType userType= (UserType)dataTrans.getInput("pojo_user_type");
		try {
		this.userTypeRepository.save(userType);
		if(userType.getId()>0) {
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
