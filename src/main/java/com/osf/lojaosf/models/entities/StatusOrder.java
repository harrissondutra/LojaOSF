package com.osf.lojaosf.models.entities;

public enum StatusOrder {
    Awaiting_Shipment(1, "Awaiting_Shipment"),
    In_Transit(2, "Transit"),
    Delivered(3, "Delivered"),
    Canceled(4, "Canceled");


    private final int id;
    private final String description;

    StatusOrder(int id, String description) {
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
