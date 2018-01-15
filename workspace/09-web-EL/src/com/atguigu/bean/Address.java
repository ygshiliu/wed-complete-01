package com.atguigu.bean;
/**
 * 
 * @author Miss 王 
 * @version 创建时间：2017年2月17日 上午10:20:13
 */
public class Address {
	
	private String city;
	private String town;
	private String street;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Address(String city, String town, String street) {
		super();
		this.city = city;
		this.town = town;
		this.street = street;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", town=" + town + ", street="
				+ street + "]";
	}
	
}
