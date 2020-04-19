/**
 * 
 */
package gdc.taxi.common.form.validation;

import gdc.taxi.common.form.Form;
import gdc.taxi.common.form.UserCommentForm;
import gdc.taxi.common.form.UserTypeForm;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
public class UserCommentFormValidator implements FormValidation{

	/* (non-Javadoc)
	 * @see gdc.taxi.common.form.validation.FormValidation#validate(gdc.taxi.common.form.Form, gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public boolean validate(Form form, DataTransfer dataTrans) {
		UserCommentForm _form = (UserCommentForm)form;
		boolean status = true;
		if(_form.getComment()==null||_form.getComment().equals("")) {
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
