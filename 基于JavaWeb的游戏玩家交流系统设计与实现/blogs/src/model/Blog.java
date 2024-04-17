package model;

import java.util.Date;

public class Blog {
	
	private int id;
	private int uid;
	private String title;
	private String content;
	private String type;
	private Date create_time;
	private Date update_time;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Blog(int id, int uid, String title, String content, String type, Date create_time,
			Date update_time,String name) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.type = type;
		this.create_time = create_time;
		this.update_time = update_time;
		this.name = name;
	}
	
	
	public Blog(int uid, String title, String content, String type, Date create_time, Date update_time) {
		super();
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.type = type;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
	public Blog(int id, String title, String content, String type, Date update_time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.type = type;
		this.update_time = update_time;
	}
	public Blog() {
		super();
	}
	
	

}
