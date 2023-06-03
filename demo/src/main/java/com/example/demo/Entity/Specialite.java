package com.example.demo.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	@ManyToMany(mappedBy = "specialite", cascade = CascadeType.ALL)
    private List<Restaurant> restaurant;
	
	public Specialite() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	

	
}
