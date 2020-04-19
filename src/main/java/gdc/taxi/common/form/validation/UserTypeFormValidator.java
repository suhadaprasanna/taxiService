/**
 * 
 */
package gdc.taxi.common.form.validation;

import gdc.taxi.common.form.Form;
import gdc.taxi.common.form.UserTypeForm;
import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.dataservice.Status;

/**
 * @author suhada
 *
 */
public class UserTypeFormValidator implements FormValidation{

	/* (non-Javadoc)
	 * @see gdc.taxi.common.form.validation.FormValidation#validate(gdc.taxi.common.form.Form, gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public boolean validate(Form form, DataTransfer dataTrans) {
		UserTypeForm _form = (UserTypeForm)form;
		boolean status = true;
		if(_form.getType()==null||_form.getType().equals("")) {
			status = false;
			dataTrans.setStatus(Status.WARNING);
			dataTrans.addOutput(Key.WARNING, "enter user type");
		}
		return status;
	}

}
