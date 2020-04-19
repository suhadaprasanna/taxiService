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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author suhada
 *
 */
@Entity
@Table(name = "user", catalog = "gdc_taxi")
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	@Column(name = "person", nullable = false, length = 100)
	private long personId;
	@Transient
	private Person person;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type", nullable = false)
	private UserType userType;
	@Column(name = "status", length = 5)
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserContact> userContacts = new HashSet<UserContact>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserComment> userComments = new HashSet<UserComment>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserLogin> userLogins = new HashSet<UserLogin>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Verification> verifications = new HashSet<Verification>();
	
	public User() {}
	public User(long id) {
		this.id=id;
	}
	
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
	 * @return the personId
	 */
	public long getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	/**
	 * @return the userContacts
	 */
	public Set<UserContact> getUserContacts() {
		return userContacts;
	}
	/**
	 * @param userContacts the userContacts to set
	 */
	public void setUserContacts(Set<UserContact> userContacts) {
		this.userContacts = userContacts;
	}
	/**
	 * @return the userComments
	 */
	public Set<UserComment> getUserComments() {
		return userComments;
	}
	/**
	 * @param userComments the userComments to set
	 */
	public void setUserComments(Set<UserComment> userComments) {
		this.userComments = userComments;
	}
	/**
	 * @return the userLogins
	 */
	public Set<UserLogin> getUserLogins() {
		return userLogins;
	}
	/**
	 * @param userLogins the userLogins to set
	 */
	public void setUserLogins(Set<UserLogin> userLogins) {
		this.userLogins = userLogins;
	}
	/**
	 * @return the verifications
	 */
	public Set<Verification> getVerifications() {
		return verifications;
	}
	/**
	 * @param verifications the verifications to set
	 */
	public void setVerifications(Set<Verification> verifications) {
		this.verifications = verifications;
	}
	
	
}
