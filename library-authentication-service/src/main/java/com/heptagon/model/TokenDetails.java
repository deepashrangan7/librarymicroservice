package com.heptagon.model;

public class TokenDetails {

	public TokenDetails(Long id, String name, String token) {
		super();
		this.authorId = id;
		this.name = name;
		this.token = token;
	}

	private Long authorId;
	private String name;
	private String token;

	

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "TokenDetails [id=" + authorId + ", name=" + name + ", token=" + token + "]";
	}

}
