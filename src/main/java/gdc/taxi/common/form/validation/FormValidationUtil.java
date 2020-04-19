
/**
 * 
 */
package gdc.taxi.common.form.validation;

/**
 * @author suhada
 *
 */

public class FormValidationUtil {
	
	public enum FormKey {
		USERFORM,USERCOMMENTFORM,USERTYPEFORM,USERVERIFICATIONFORM,USERCONTACTFORM
	}
	
	public static Class getFormClass(FormKey key) {
		if(key == FormKey.USERFORM) {
			return UserFormValidator.class;
		}else if(key == FormKey.USERCOMMENTFORM) {
			return UserCommentFormValidator.class;
		}else if(key == FormKey.USERTYPEFORM) {
			return UserTypeFormValidator.class;
		}else if(key == FormKey.USERVERIFICATIONFORM) {
			return UserVerificationFormValidator.class;
		}else if(key == FormKey.USERCONTACTFORM) {
			return UserContactFormValidator.class;
		}else {
			return null;
		}
	}
}
