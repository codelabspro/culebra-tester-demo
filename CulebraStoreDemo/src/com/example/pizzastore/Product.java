package com.example.pizzastore;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Product implements Serializable{

		@SerializedName("class")
		private String className;
		@SerializedName("id")
		private int id;
		@SerializedName("name")
	    private String name;
		@SerializedName("description")
	    private String description;
		@SerializedName("price")
	    private int price;
		@SerializedName("status")
	    private String status;
		@SerializedName("tags")
	    private List<String> tags;
	    
	    public Product(String name, String description, int price, String status) {
	    	this.name = name;
	    	this.description = description;
	    	this.price = price;
	    	this.status = status;
	    	
	    }

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<String> getTagList() {
			return tags;
		}

		public void setTagList(List<String> tagList) {
			this.tags = tagList;
		}
	   
	    
}
