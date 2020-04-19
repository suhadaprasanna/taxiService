/**
 * 
 */
package gdc.taxi.common.form.validation;

import org.springframework.stereotype.Component;

import gdc.taxi.common.form.Form;
import gdc.utility.dataservice.DataTransfer;
import gdc.utility.validations.Validation;

/**
 * @author suhada
 *
 */
@Component
public interface FormValidation {

	public boolean validate (Form form,DataTransfer dataTrans);
	
	public Validation validation = new Validation(); 
	
}
