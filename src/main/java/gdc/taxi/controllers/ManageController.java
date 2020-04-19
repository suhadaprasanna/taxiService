/**
 * 
 */
package gdc.taxi.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gdc.utility.dataservice.DataTransfer;

/**
 * @author suhada
 *
 */
@RestController
//@RequestMapping(value = { "/taxi/res" })
public class ManageController {

	@PostMapping(value="/register")
	public Object register(@ModelAttribute("registerForm")Object form) {
		DataTransfer dataTransfer = new DataTransfer();
		
		return dataTransfer;
	}
}
