package com.skilldistillery.beardjpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Stroking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String location;
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date dateStroked;
	
	// end of fields
	
	public Stroking() {
	}

	public Stroking(int id, String name, String location, Date dateStroked) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.dateStroked = dateStroked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateStroked() {
		return dateStroked;
	}

	public void setDateStroked(Date dateStroked) {
		this.dateStroked = dateStroked;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Beard [id=" + id + ", name=" + name + ", location=" + location + ", dateStroked=" + dateStroked + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateStroked == null) ? 0 : dateStroked.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stroking other = (Stroking) obj;
		if (dateStroked == null) {
			if (other.dateStroked != null)
				return false;
		} else if (!dateStroked.equals(other.dateStroked))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
