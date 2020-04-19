/**
 * 
 */
package gdc.taxi.datamanager.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author suhada
 *
 */
@Entity
@Table(name = "verification", catalog = "gdc_taxi")
public class Verification {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", nullable = false)
	private User user;
	@Column(name = "otp_code", nullable = false, length = 45)
	private String otp_code;
	@Column(name = "status", nullable = false, length = 5)
	private String status;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the otp_code
	 */
	public String getOtp_code() {
		return otp_code;
	}
	/**
	 * @param otp_code the otp_code to set
	 */
	public void setOtp_code(String otp_code) {
		this.otp_code = otp_code;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
