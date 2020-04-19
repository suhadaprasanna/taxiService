/**
 * 
 */
package gdc.taxi.controllers;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = { "/taxi/reservation" })
public class ReservationController {

	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	ReservationCacheRepoImpl resCache;
	
	@GetMapping(value="/booking/new/{id}")
	public Object newBooking(@PathVariable("id") int id,HttpServletRequest req) {
		logger.debug("------>>start addNewUser<<------");
		Reservation res = new Reservation();
		res.setId(id);
		res.setCreateDate(new Date());
		res.setDescription("add");
		this.resCache.save(res);
		logger.debug("------>>end addNewUser<<------");
		return res;
	}
	
	@GetMapping(value="/booking/update/{id}")
	public Object updateBooking(@PathVariable("id") int id,HttpServletRequest req) {
		logger.debug("------>>start addNewUser<<------");
		Reservation res = new Reservation();
		res.setCreateDate(new Date());
		res.setDescription("update");
		this.resCache.save(res);
		logger.debug("------>>end addNewUser<<------");
		return res;
	}
	
	@GetMapping(value="/booking/getall")
	public Object getAllBooking(HttpServletRequest req) {
		logger.debug("------>>start addNewUser<<------");
		Map res = this.resCache.findAll();
		logger.debug("------>>end addNewUser<<------");
		return res;
	}
	
	@GetMapping(value="/booking/get/{id}")
	public Object getBookingById(@PathVariable("id") int id,HttpServletRequest req) {
		logger.debug("------>>start addNewUser<<------");
		Object res = this.resCache.findByKey(id+"");
		logger.debug("------>>end addNewUser<<------");
		return res;
	}
}
