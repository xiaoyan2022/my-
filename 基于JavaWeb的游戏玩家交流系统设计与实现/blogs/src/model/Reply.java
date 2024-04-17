package model;

import java.util.Date;

public class Reply {
	
	private int id;
	private int uid;
	private int bid;
	private String content;
	private Date create_time;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public int getBid() {
		return bid;
	}



	public void setBid(int bid) {
		this.bid = bid;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getCreate_time() {
		return create_time;
	}



	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}



	
	public Reply() {
		super();
	}



	public Reply(int id, int uid, int bid, String content, Date create_time) {
		super();
		this.id = id;
		this.uid = uid;
		this.bid = bid;
		this.content = content;
		this.create_time = create_time;
	}

	

}
