/**
 * 
 */
package gdc.taxi.controllers.response;

import java.util.HashMap;


import gdc.utility.dataservice.DataTransfer;

/**
 * @author suhada
 *
 */
public interface ResponseGenerator {

	public HashMap<String, Object> generate(DataTransfer dataTrans,HashMap<String,Object> res);
	
	public HashMap<String, Object> defaultBehaviour(DataTransfer dataTrans,HashMap<String,Object> res);
	
	public HashMap<String,Object> getResponse(DataTransfer dataTrans);
}
