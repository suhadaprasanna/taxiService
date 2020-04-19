/**
 * 
 */
package gdc.taxi.common.form;

/**
 * @author suhada
 *
 */
public class UserForm extends Form {

	private long id;
	private long person_id;
	private int user_type;
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
	 * @return the person_id
	 */
	public long getPerson_id() {
		return person_id;
	}
	/**
	 * @param person_id the person_id to set
	 */
	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}
	/**
	 * @return the user_type
	 */
	public int getUser_type() {
		return user_type;
	}
	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(int user_type) {
		this.user_type = user_type;
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
