package gdc.taxi.datamanager.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "person", catalog = "gdc_person")
public class Person implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 2830130455676527236L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	@Column(name = "middle_name", length = 100)
	private String middleName;
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	@Column(name = "sur_name", length = 100)
	private String surName;
	@Column(name = "nic", length = 20)
	private String nic;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day", length = 10)
	private Date birth_day;
	@Temporal(TemporalType.DATE)
	@Column(name = "sys_add_date", length = 10)
	private Date sys_add_date;
	@Column(name = "gender", length = 10)
	private String gender;
	@Column(name = "living_status", length = 5)
	private String living_status;
	@Column(name = "nationality", length = 50)
	private String nationality;
	@Column(name = "status", length = 5)
	private String status;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	private Set<PersonEmail> personEmails = new HashSet<PersonEmail>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	private Set<PersonContact> personContacts = new HashSet<PersonContact>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	private Set<PersonAddress> personAddress = new HashSet<PersonAddress>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the birth_day
	 */
	public Date getBirth_day() {
		return birth_day;
	}

	/**
	 * @param birth_day the birth_day to set
	 */
	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the sys_add_date
	 */
	public Date getSys_add_date() {
		return sys_add_date;
	}

	/**
	 * @param sys_add_date the sys_add_date to set
	 */
	public void setSys_add_date(Date sys_add_date) {
		this.sys_add_date = sys_add_date;
	}

	/**
	 * @return the living_status
	 */
	public String getLiving_status() {
		return living_status;
	}

	/**
	 * @param living_status the living_status to set
	 */
	public void setLiving_status(String living_status) {
		this.living_status = living_status;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the personEmails
	 */
	public Set<PersonEmail> getPersonEmails() {
		return personEmails;
	}

	/**
	 * @param personEmails the personEmails to set
	 */
	public void setPersonEmails(Set<PersonEmail> personEmails) {
		this.personEmails = personEmails;
	}

	/**
	 * @return the personContacts
	 */
	public Set<PersonContact> getPersonContacts() {
		return personContacts;
	}

	/**
	 * @param personContacts the personContacts to set
	 */
	public void setPersonContacts(Set<PersonContact> personContacts) {
		this.personContacts = personContacts;
	}

	/**
	 * @return the personAddress
	 */
	public Set<PersonAddress> getPersonAddress() {
		return personAddress;
	}

	/**
	 * @param personAddress the personAddress to set
	 */
	public void setPersonAddress(Set<PersonAddress> personAddress) {
		this.personAddress = personAddress;
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
