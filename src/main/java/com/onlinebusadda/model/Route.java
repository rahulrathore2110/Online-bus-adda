package com.onlinebusadda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Routeid;
	private String Routefrom;
	private String Routeto;
	private Integer distence;

	public Route() {
		super();
	}
	public Route(Integer routeid, String routefrom, String routeto, Integer distence) {
		super();
		Routeid = routeid;
		Routefrom = routefrom;
		Routeto = routeto;
		this.distence = distence;
	}
	public Integer getRouteid() {
		return Routeid;
	}
	public void setRouteid(Integer routeid) {
		Routeid = routeid;
	}
	public String getRoutefrom() {
		return Routefrom;
	}
	public void setRoutefrom(String routefrom) {
		Routefrom = routefrom;
	}
	public String getRouteto() {
		return Routeto;
	}
	public void setRouteto(String routeto) {
		Routeto = routeto;
	}
	public Integer getDistence() {
		return distence;
	}
	public void setDistence(Integer distence) {
		this.distence = distence;
	}
	@Override
	public String toString() {
		return "Route [Routeid=" + Routeid + ", Routefrom=" + Routefrom + ", Routeto=" + Routeto + ", distence="
				+ distence + "]";
	}
	
	
	

}
