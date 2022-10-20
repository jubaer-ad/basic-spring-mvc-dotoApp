package com.entityHub;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dotoId;
	private String dotoTitle;
	private String dotoContent;
	private Date dotoDate;

	public Doto() {
		super();
	}

	public Doto(String dotoTitle, String dotoContent, Date dotoDate) {
		super();
		this.dotoTitle = dotoTitle;
		this.dotoContent = dotoContent;
		this.dotoDate = dotoDate;
	}

	public String getDotoTitle() {
		return dotoTitle;
	}

	public void setDotoTitle(String dotoTitle) {
		this.dotoTitle = dotoTitle;
	}

	public String getDotoContent() {
		return dotoContent;
	}

	public void setDotoContent(String dotoContent) {
		this.dotoContent = dotoContent;
	}

	public Date getDotoDate() {
		return dotoDate;
	}

	public void setDotoDate(Date dotoDate) {
		this.dotoDate = dotoDate;
	}

	@Override
	public String toString() {
		return "[dotoTitle=" + dotoTitle + ", dotoContent=" + dotoContent + ", dotoDate=" + dotoDate + "]";
	}

}
