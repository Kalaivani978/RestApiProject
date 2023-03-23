package com.example.demo.model;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * This class will act as a table in the database. 
 * @Table is used to assign the table name
 * @DynamicUpdate is used to update that particular value.
 * @Id is used to assign the primary key
 * @GeneratedValue is used to indicate the type of primary key.
 * @Column is used to assign the column name.
 * 
 */
@Entity
@Table(name="Swiggy")
@DynamicUpdate
public class SwiggyModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int restaurantId;
	
	@Column(name="restaurantName",nullable=false)
	private String restaurantName;
	private String ownerName;
	private String foodType;
	private float rating;
	private String location;
	
	public SwiggyModel() {
		
	}
	/*
	 * Getter and Setter method.
	 */
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public SwiggyModel(int hotelId, String restaurantName, String ownerName, String foodType, float rating,
			String location) {
		this.restaurantId = hotelId;
		this.restaurantName = restaurantName;
		this.ownerName = ownerName;
		this.foodType = foodType;
		this.rating = rating;
		this.location = location;
	}
	
	
}



	