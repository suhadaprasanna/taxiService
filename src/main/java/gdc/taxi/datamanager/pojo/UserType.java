/**
 * 
 */
package gdc.taxi.datamanager.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author suhada
 *
 */
@Entity
@Table(name = "user_type", catalog = "gdc_taxi")
public class UserType {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(name = "type", nullable = false, length = 45)
	private String type;
	@Column(name = "status", nullable = false, length = 5)
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userType", cascade = CascadeType.ALL)
	private Set<User> users = new HashSet<User>();
	
	public UserType() {}
	public UserType(int id) {
		this.id = id;
	}
	
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
