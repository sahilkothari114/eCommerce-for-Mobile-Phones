package com.flipmart.persistence;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries(
        {
            @NamedQuery(
                    name = "findAdminByEmail",
                    query = "from Admin a where a.email= :email"
            )
        }
)
@Entity
@Table(name = "admin")
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name="admin_SEQ", allocationSize=1)
	@Column(name = "admin_id")
	private long adminId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pincode")
	private Pincode pincode;

	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "display_picture")
	private String displayPicture;
        
        @Column(name = "active")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String geteMail() {
		return email;
	}

	public void seteMail(String eMail) {
		this.email = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pincode getPincode() {
		return pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getDisplayPicture() {
		return displayPicture;
	}

	public void setDisplayPicture(String displayPicture) {
		this.displayPicture = displayPicture;
	}

	public long getAdminId() {
		return adminId;
	}

    @Override
    public String toString() {
        return "Admin{" + "adminId=" + adminId + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", pincode=" + pincode + ", streetAddress=" + streetAddress + ", contactNo=" + contactNo + ", displayPicture=" + displayPicture + ", active=" + active + '}';
    }

}
