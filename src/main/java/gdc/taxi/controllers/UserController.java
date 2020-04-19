/**
 * 
 */
package gdc.taxi.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdc.taxi.common.form.UserCommentForm;
import gdc.taxi.common.form.UserContactForm;
import gdc.taxi.common.form.UserForm;
import gdc.taxi.common.form.UserTypeForm;
import gdc.taxi.common.form.UserVerificationForm;
import gdc.taxi.service.UserService;
import gdc.utility.dataservice.DataTransfer;

/**
 * @author suhada
 *
 */
@RestController
@RequestMapping(value = { "/taxi/user" })
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/add")
	public Object addNewUser(@ModelAttribute("userForm") UserForm form,HttpServletRequest req) {
		logger.debug("------>>start addNewUser<<------");
		DataTransfer dataTrans = new DataTransfer();
		dataTrans.addInput("userForm", form);
		dataTrans.addInput("reqParam", req.getParameterMap());
		dataTrans = this.userService.addNewUser(dataTrans);
		logger.debug("------>>end addNewUser<<------");
		return null;
	}
	
	@PostMapping(value="/comment/add")
	public Object addNewComment(@ModelAttribute("userCommentForm")UserCommentForm form,HttpServletRequest req) {
		logger.debug("------>>start addNewComment<<------");
		DataTransfer dataTrans = new DataTransfer();
		dataTrans.addInput("userCommentForm", form);
		dataTrans.addInput("reqParam", req.getParameterMap());
		dataTrans = this.userService.addNewComment(dataTrans);
		logger.debug("------>>end addNewComment<<------");
		return null;
	}
	
	@PostMapping(value="/type/add")
	public Object addNewUserType(@ModelAttribute("userCommentForm")UserTypeForm form,HttpServletRequest req) {
		logger.debug("------>>start addNewUserType<<------");
		DataTransfer dataTrans = new DataTransfer();
		dataTrans.addInput("userTypeForm", form);
		dataTrans.addInput("reqParam", req.getParameterMap());
		dataTrans = this.userService.addNewComment(dataTrans);
		logger.debug("------>>end addNewUserType<<------");
		return null;
	}
	
	@PostMapping(value="/verification/add")
	public Object userVarification(@ModelAttribute("userVerificationForm")UserVerificationForm form,HttpServletRequest req) {
		logger.debug("------>>start addNewUserType<<------");
		DataTransfer dataTrans = new DataTransfer();
		dataTrans.addInput("userVerificationForm", form);
		dataTrans.addInput("reqParam", req.getParameterMap());
		dataTrans = this.userService.addVerification(dataTrans);
		logger.debug("------>>end addNewUserType<<------");
		return null;
	}
	
	@PostMapping(value="/contact/add")
	public Object userContact(@ModelAttribute("userContactForm")UserContactForm form,HttpServletRequest req) {
		logger.debug("------>>start addNewUserType<<------");
		DataTransfer dataTrans = new DataTransfer();
		dataTrans.addInput("userContactForm", form);
		dataTrans.addInput("reqParam", req.getParameterMap());
		dataTrans = this.userService.addUserContact(dataTrans);
		logger.debug("------>>end addNewUserType<<------");
		return null;
	}
}
