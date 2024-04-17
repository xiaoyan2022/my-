package com.model;

public class User {
	private int uid;
	private String username;
	private String password;
	private String nickname;

	private int role;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password,String nickname,int role) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.role = role;
	}

	public User(int uid, String username, String password, String nickname,int role) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.role = role;
	}

    public User(int uid, String nickname) {
		this.uid = uid;
		this.nickname = nickname;
    }

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
