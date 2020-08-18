package com.heptagon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Author {

	public Author() {
	}

	public Author(String name, String password, String confirmPassword, String email, Integer age) {
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.age = age;
	}

	public Author(String name, String password, String email, Integer age) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;

	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be null")
	private String name;

	@Length(min = 4, max = 20, message = "password must be in length of 4 to 20")
	private String password;

	@Transient
	@Length(min = 4, max = 20, message = "password must be in length of 4 to 20")
	private String confirmPassword;

	@NotNull(message = "email should not be null")
	@NotBlank(message = "email should not be blank")
	private String email;

	private Integer age;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", age=" + age + "]";
	}

}
