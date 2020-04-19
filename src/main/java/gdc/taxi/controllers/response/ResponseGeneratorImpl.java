/**
 * 
 */
package gdc.taxi.controllers.response;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gdc.utility.common.Key;
import gdc.utility.dataservice.DataTransfer;

/**
 * @author suhada
 *
 */
public abstract class ResponseGeneratorImpl implements ResponseGenerator{
	
	private static final Logger logger = LoggerFactory.getLogger(ResponseGeneratorImpl.class);
	
	/* (non-Javadoc)
	 * @see gdc.person.service.ResponseGeneration#defaultBehaviour(gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public HashMap<String, Object> defaultBehaviour(DataTransfer dataTrans,HashMap<String,Object> res) {
		try {
			res.put("status", dataTrans.getStatus());
			
			HashMap<String,Object> outputs = (HashMap)res.get(Key.OUTPUTS);
			if(outputs==null)
				outputs = new HashMap<String,Object>();
			outputs.put(Key.WARNING_LIST, dataTrans.getOutput(Key.WARNING_LIST));
			
			outputs.put(Key.ERROR_LIST, dataTrans.getOutput(Key.ERROR_LIST));
			
			outputs.put(Key.MESSAGE_LIST, dataTrans.getOutput(Key.MESSAGE_LIST));
			res.put(Key.OUTPUTS, outputs);
		}catch (Exception e) {
			logger.error("Error in response default behaviour : "+e);
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see gdc.person.service.ResponseGeneration#getResponse(gdc.utility.dataservice.DataTransfer)
	 */
	@Override
	public HashMap<String, Object> getResponse(DataTransfer dataTrans) {
		logger.debug("------>>Start getResponse<<------");
		HashMap<String,Object> res = new HashMap<String,Object>();
		
		logger.debug("------>>Start response generate<<------");
		generate(dataTrans,res);
		logger.debug("------>>End response generate<<------");
		
		logger.debug("------>>Start response default behaviour mapping<<------");
		defaultBehaviour(dataTrans,res);
		logger.debug("------>>End response default behaviour mapping<<------");
		
		logger.debug("------>>End getResponse<<------");
		return res;
	}
}
