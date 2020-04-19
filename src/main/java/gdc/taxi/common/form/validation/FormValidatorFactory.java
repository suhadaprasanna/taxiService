/**
 * 
 */
package gdc.taxi.common.form.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import gdc.taxi.common.form.validation.FormValidationUtil.FormKey;
import gdc.utility.spring.ApplicationContextUtils;



/**
 * @author suhada
 *
 */
@Component
public class FormValidatorFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(FormValidatorFactory.class);
	

	public FormValidation getFormValidator(FormKey key) {
		ApplicationContext ctx = ApplicationContextUtils.getApplicationContext();
		Class _class = null;
		_class = FormValidationUtil.getFormClass(key);
		logger.debug("Key : "+key+" class : "+_class+" applicationContext : "+ctx);
		if(_class !=null) {
			return (FormValidation) ctx.getBean(_class);
		}else {
			return null;
		}
	}
}
