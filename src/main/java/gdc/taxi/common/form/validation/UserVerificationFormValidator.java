/**
 * 
 */
package gdc.taxi.common.form.validation;

import gdc.taxi.common.form.Form;
import gdc.taxi.common.form.UserVerificationForm;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
public class UserVerificationFormValidator implements FormValidation{

	/* (non-Javadoc)
	 * @see gdc.taxi.common.form.validation.FormValidation#validate(gdc.taxi.common.form.Form, gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public boolean validate(Form form, DataTransfer dataTrans) {
		UserVerificationForm _form = (UserVerificationForm)form;
		boolean status = true;
		if(_form.getUser_id()<=0) {
			status=false;
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING_LIST, "please add user");
		}
		if(_form.getOtp_code()==null||_form.getOtp_code().equals("")) {
			status=false;
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING_LIST, "please enter otp code");
		}
		return status;
	}

}
