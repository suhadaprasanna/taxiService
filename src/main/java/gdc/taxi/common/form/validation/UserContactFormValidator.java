/**
 * 
 */
package gdc.taxi.common.form.validation;

import gdc.taxi.common.form.Form;
import gdc.taxi.common.form.UserCommentForm;
import gdc.taxi.common.form.UserContactForm;
import gdc.taxi.common.form.UserTypeForm;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
public class UserContactFormValidator implements FormValidation{

	/* (non-Javadoc)
	 * @see gdc.taxi.common.form.validation.FormValidation#validate(gdc.taxi.common.form.Form, gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public boolean validate(Form form, DataTransfer dataTrans) {
		UserContactForm _form = (UserContactForm)form;
		boolean status = true;
		if(_form.getContact()==null||_form.getContact().equals("")) {
			status = false;
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING, "enter user comment");
		}
		if(_form.getUser_id()<=0) {
			status = false;
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING, "enter user");
		}
		return status;
	}

}
