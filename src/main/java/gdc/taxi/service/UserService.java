/**
 * 
 */
package gdc.taxi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gdc.taxi.common.form.UserCommentForm;
import gdc.taxi.common.form.UserContactForm;
import gdc.taxi.common.form.UserForm;
import gdc.taxi.common.form.UserTypeForm;
import gdc.taxi.common.form.UserVerificationForm;
import gdc.taxi.common.form.validation.FormValidationUtil.FormKey;
import gdc.taxi.datamanager.access.UserAccess;
import gdc.taxi.datamanager.access.UserCommentAccess;
import gdc.taxi.datamanager.access.UserContactAccess;
import gdc.taxi.datamanager.access.UserTypeAccess;
import gdc.taxi.datamanager.pojo.User;
import gdc.taxi.datamanager.pojo.UserComment;
import gdc.taxi.datamanager.pojo.UserContact;
import gdc.taxi.datamanager.pojo.UserType;
import gdc.taxi.datamanager.pojo.Verification;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.validations.Validation;

/**
 * @author suhada
 *
 */
@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Validation validation;
	
	@Autowired
	private UserAccess userAccess;
	
	@Autowired
	private UserCommentAccess userCommentAccess;
	
	@Autowired
	private UserTypeAccess userTypeAccess;
	
	@Autowired
	private UserContactAccess userContactAccess;
	
	public DataTransfer addNewUser(DataTransfer dataTrans) {
		logger.debug("------>>start addNewUser<<------");
		UserForm form = (UserForm)dataTrans.getInput("userForm");
		if(!form.validate(FormKey.USERFORM, dataTrans)) {
			return dataTrans;
		}
		User user = new User();
		this.setUserData(form,user);
		dataTrans.addInput("pojo_user",user);
		dataTrans = this.userAccess.save(dataTrans);
		logger.debug("------>>end addNewUser<<------");
		return dataTrans;
	}

	public DataTransfer addNewComment(DataTransfer dataTrans) {
		logger.debug("------>>start addNewComment<<------");
		UserCommentForm form = (UserCommentForm)dataTrans.getInput("userCommentForm");
		if(!form.validate(FormKey.USERCOMMENTFORM, dataTrans)) {
			return dataTrans;
		}
		UserComment userComment = new UserComment();
		this.setUserCommentData(form,userComment);
		dataTrans.addInput("pojo_user_comment",userComment);
		dataTrans = this.userCommentAccess.save(dataTrans);
		logger.debug("------>>end addNewComment<<------");
		return dataTrans;
	}
	
	public DataTransfer addNewUserType(DataTransfer dataTrans) {
		logger.debug("------>>start addNewUserType<<------");
		UserTypeForm form = (UserTypeForm)dataTrans.getInput("userTypeForm");
		if(!form.validate(FormKey.USERTYPEFORM, dataTrans)) {
			return dataTrans;
		}
		UserType userType = new UserType();
		this.setUserTypeData(form,userType);
		dataTrans.addInput("pojo_user_type",userType);
		dataTrans = this.userTypeAccess.save(dataTrans);
		logger.debug("------>>end addNewUserType<<------");
		return dataTrans;
	}
	
	public DataTransfer addVerification(DataTransfer dataTrans) {
		logger.debug("------>>start addVerification<<------");
		UserVerificationForm form = (UserVerificationForm)dataTrans.getInput("userVerificationForm");
		if(!form.validate(FormKey.USERVERIFICATIONFORM, dataTrans)) {
			return dataTrans;
		}
		Verification verification = new Verification();
		this.setVerificationData(form,verification);
		dataTrans.addInput("pojo_verification",verification);
		dataTrans = this.userTypeAccess.save(dataTrans);
		logger.debug("------>>end addVerification<<------");
		return null;
	}
	
	
	public DataTransfer addUserContact(DataTransfer dataTrans) {
		logger.debug("------>>start addUserContact<<------");
		UserContactForm form = (UserContactForm)dataTrans.getInput("userContactForm");
		if(!form.validate(FormKey.USERCONTACTFORM, dataTrans)) {
			return dataTrans;
		}
		UserContact userContact = new UserContact();
		this.setContactData(form,userContact);
		dataTrans.addInput("pojo_user_contact",userContact);
		dataTrans = this.userTypeAccess.save(dataTrans);
		logger.debug("------>>end addUserContact<<------");
		return dataTrans;
	}
	
	private void setUserData(UserForm form, User user) {
		logger.debug("------>>start setUserData<<------");
		user.setId(form.getId());
		if(user.getPersonId()<=0 || user.getPersonId()!= form.getPerson_id()) {
			user.setPersonId(form.getPerson_id());
		}
		if(user.getUserType()==null || user.getUserType().getId()!=form.getUser_type()) {
			user.setUserType(new UserType(form.getUser_type()));
		}
		if(user.getStatus()==null|| user.getStatus().equals("")|| !user.getStatus().equalsIgnoreCase(form.getStatus())) {
			user.setStatus(form.getStatus());
		}
		logger.debug("------>>end setUserData<<------");
	}
	
	private void setUserCommentData(UserCommentForm form, UserComment userComment) {
		logger.debug("------>>start setUserCommentData<<------");
		userComment.setId(form.getId());
		if(userComment.getComment()==null||userComment.getComment().equals("")) {
			userComment.setComment(form.getComment());
		}
		if(userComment.getUser()==null||userComment.getUser().getId()!=form.getUser_id()) {
			userComment.setUser(new User(form.getUser_id()));
		}
		logger.debug("------>>end setUserCommentData<<------");
	}

	private void setUserTypeData(UserTypeForm form, UserType userType) {
		logger.debug("------>>start setUserTypeData<<------");
		userType.setId(form.getId());
		if(userType.getType()==null||userType.getType().equals("")||!userType.getType().equals(form.getType())) {
			userType.setType(form.getType());
		}
		if(userType.getStatus()==null||userType.getStatus().equals("")||!userType.getStatus().equals(form.getStatus())) {
			userType.setStatus(form.getStatus());
		}
		logger.debug("------>>end setUserTypeData<<------");
		
	}

	private void setVerificationData(UserVerificationForm form, Verification verification) {
		logger.debug("------>>start setVerificationData<<------");
		verification.setId(form.getId());
		if(verification.getUser()==null||verification.getUser().getId()!=form.getUser_id()) {
			verification.setUser(new User(form.getUser_id()));
		}
		verification.setOtp_code(form.getOtp_code());
		if(verification.getStatus()==null||verification.getStatus().equals("")||!verification.getStatus().equals(form.getStatus())) {
			verification.setStatus(form.getStatus());
		}
		if(verification.getUser()==null) {
			verification.setUser(new User(form.getUser_id()));
		}
		logger.debug("------>>end setVerificationData<<------");
	}

	private void setContactData(UserContactForm form, UserContact userContact) {
		logger.debug("------>>start setContactData<<------");
		userContact.setId(form.getId());
		if(userContact.getContact()==null||userContact.getContact().equals("")||!userContact.getContact().equals(form.getContact())) {
			userContact.setContact(form.getContact());
		}
		if(userContact.getStatus()==null||userContact.getStatus().equals("")||!userContact.getStatus().equals(form.getStatus())) {
			userContact.setStatus(form.getStatus());
		}
		if(userContact.getUser()==null) {
			userContact.setUser(new User(form.getUser_id()));
		}
		logger.debug("------>>end setContactData<<------");
	}
	
}
