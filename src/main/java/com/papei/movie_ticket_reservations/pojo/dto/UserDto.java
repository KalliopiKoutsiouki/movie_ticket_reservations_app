package com.papei.movie_ticket_reservations.pojo.dto;

public class UserDto {

    // FROM GOOGLE ACCESS_TOKEN
//    private String sub;
//    private String name;
//    private String given_name;
//    private String family_name;
//    private String picture;
//    private String email;
//    private boolean email_verified;
//    private String locale;


    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String mobilePhone;

    private MovieDto chosenMovie;

    private Short hasKids;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public MovieDto getChosenMovie() {
        return chosenMovie;
    }

    public void setChosenMovie(MovieDto chosenMovie) {
        this.chosenMovie = chosenMovie;
    }

    public Short getHasKids() {
        return hasKids;
    }

    public void setHasKids(Short hasKids) {
        this.hasKids = hasKids;
    }

    //
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public boolean isEmail_verified() {
//        return email_verified;
//    }
//
//    public void setEmail_verified(boolean email_verified) {
//        this.email_verified = email_verified;
//    }
//
//    public String getLocale() {
//        return locale;
//    }
//
//    public void setLocale(String locale) {
//        this.locale = locale;
//    }
//
//    public String getSub() {
//        return sub;
//    }
//
//    public void setSub(String sub) {
//        this.sub = sub;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGiven_name() {
//        return given_name;
//    }
//
//    public void setGiven_name(String given_name) {
//        this.given_name = given_name;
//    }
//
//    public String getFamily_name() {
//        return family_name;
//    }
//
//    public void setFamily_name(String family_name) {
//        this.family_name = family_name;
//    }
}

