/**
 * 
 */
package gdc.taxi.controllers;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdc.service.caching.dao.ReservationCacheRepoImpl;
import gdc.utility.pojo.reservation.Reservation;

/**
 * @author suhada
 *
 */
@RestController
@RequestMapping(value= {"/taxi/test"})
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	ReservationCacheRepoImpl resCache;
	
	@GetMapping(value= {"/cache/add/{id}"})
	public Object test1(@PathVariable("id") int id) {
		logger.debug("cache add");
		Reservation res = new Reservation();
		res.setId(id);
		res.setDescription("taxi save");
		res.setCreateDate(new Date());
		res.setTraceId(new Date().getTime());
		resCache.save(res);
		return res;
	}
	
	@GetMapping(value= {"/cache/update/{traceId}"})
	public Object test3(@PathVariable("traceId") long traceId) {
		logger.debug("cache update");
		Reservation res = resCache.findByKey(traceId+"");
		res.setDescription("taxi update");
		resCache.save(res);
		return res;
	}
	
	@GetMapping(value= {"/cache/get/{traceId}"})
	public Object test4(@PathVariable("traceId") long traceId) {
		logger.debug("cache get id");
		Reservation res = resCache.findByKey(traceId+"");
		return res;
	}
	
	@GetMapping(value= {"/cache/getall"})
	public Object test5() {
		logger.debug("cache getall");
		 Map res = resCache.findAll();
		 return res;
	}
	
	@GetMapping(value= {"/cache/delete/{traceId}"})
	public Object test6(@PathVariable("traceId") long traceId) {
		logger.debug("cache delete");
		resCache.delete(traceId+"");
		return traceId;
	}
}
