package contact;

public class Contact {
    
	int contactId;
	String name;
	String mobile;
	String email;
	
	public Contact( int contactId , String name, String mobile, String email) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
	
}
