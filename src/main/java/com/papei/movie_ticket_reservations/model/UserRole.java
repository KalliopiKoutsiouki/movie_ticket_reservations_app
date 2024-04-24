package com.papei.movie_ticket_reservations.model;

public enum UserRole {

    ROLE_USER ("ROLE_USER"),
    ROLE_ADMIN ("ROLE_ADMIN"),
    ROLE_SUPERADMIN ("ROLE_SUPERADMIN"),
    ROLE_CHECKER ("ROLE_CHECKER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
