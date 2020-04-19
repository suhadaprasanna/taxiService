/**
 * 
 */
package gdc.taxi.datamanager.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gdc.taxi.datamanager.dao.UserRepository;
import gdc.taxi.datamanager.pojo.User;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
@Repository("userAccess")
@Transactional
public class UserAccess {

	private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public DataTransfer save(DataTransfer dataTrans) {
		try {
			User user = (User)dataTrans.getInput("pojo_user");
			user = this.userRepository.save(user);
			if(user == null) {
				dataTrans.setStatus(Status.FAIL);
				dataTrans.addInput(Key.FAIL, "user save failed");
			}else {
				if(user.getId()>0){
					dataTrans.setStatus(Status.SUCCESS);
					dataTrans.addInput(Key.FAIL, "user save success");
				}else {
					dataTrans.setStatus(Status.FAIL);
					dataTrans.addInput(Key.FAIL, "user save failed");
					dataTrans.addOutput("pojo_user", user);
				}
			}
		}catch(Exception e) {
			logger.warn("------>>save failed : "+e);
			dataTrans.setStatus(Status.ERROR);
			dataTrans.addInput(Key.ERROR, "something went wrong");
		}
		return dataTrans;
	}
	
	public DataTransfer update(DataTransfer dataTrans) {
		try {
			User user = (User)dataTrans.getInput("pojo_user");
			user = this.userRepository.save(user);
			dataTrans.setStatus(Status.SUCCESS);
			dataTrans.addInput(Key.FAIL, "user update success");
		}catch(Exception e) {
			logger.warn("------>>save failed : "+e);
			dataTrans.setStatus(Status.ERROR);
			dataTrans.addInput(Key.ERROR, "something went wrong");
		}
		return dataTrans;
	}

	public boolean isExist(long id) {
		return this.userRepository.existsById(id);
	}
}
