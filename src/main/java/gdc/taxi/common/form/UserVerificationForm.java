/**
 * 
 */
package gdc.taxi.common.form;

/**
 * @author suhada
 *
 */
public class UserVerificationForm extends Form{

	private int id;
	private long user_id;
	private String otp_code;
	private String status;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
