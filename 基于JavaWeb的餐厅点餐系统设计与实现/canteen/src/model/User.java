package model;

public class User {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String address;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(int id, String username, String password, String nickname, String address, String tel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.address = address;
		this.tel = tel;
	}
	public User() {
		super();
	}
	public User(String username, String password, String nickname) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}
	public User(int id, String nickname, String address, String tel) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.address = address;
		this.tel = tel;
	}
	public User(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

}
