package com.osf.lojaosf.models.entities;

public enum Status {
	Active(1, "Active"), Inactive(2, "Inactive");

	private int id;
	private String description;

	Status(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Status{" + "id=" + id + ", description='" + description + '\'' + '}';
	}
}
