/**
 * 
 */
package gdc.taxi.controllers.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author suhada
 *
 */
@Component
public class ResponseGeneratorFactoryUtil {

	public enum ResponseKey{
		USER_ADD
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ResponseGeneratorFactoryUtil.class);
	
	public Class getResponseClass(ResponseKey key) {
		Class type = null;
		switch (key) {
		case USER_ADD:
			type = ResponseForUserAdd.class;
			break;
		default:
			type = null;
			break;
		}
		return type;
	}
}
