package model;

import java.sql.Date;

public class Cart {
	private int id;
	private int bid;
	private int uid;
	private int num;
	private Date time;
	private String name;
	private String imgUrl;
	private float price;
	private String nickname;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Cart(int id, int bid, int uid, int num, Date time) {
		super();
		this.id = id;
		this.bid = bid;
		this.uid = uid;
		this.num = num;
		this.time = time;
	}
	public Cart(int bid, int uid, int num, Date time) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.num = num;
		this.time = time;
	}
	public Cart() {
		super();
	}
	public Cart(int id, int bid, int uid, int num, Date time, String name, String imgUrl, float price) {
		super();
		this.id = id;
		this.bid = bid;
		this.uid = uid;
		this.num = num;
		this.time = time;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
	}
	public Cart(int id, int bid, int uid, int num, Date time, String name, String imgUrl, float price,
			String nickname) {
		super();
		this.id = id;
		this.bid = bid;
		this.uid = uid;
		this.num = num;
		this.time = time;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.nickname = nickname;
	}
	

}
