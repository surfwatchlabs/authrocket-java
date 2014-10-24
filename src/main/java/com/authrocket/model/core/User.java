package com.authrocket.model.core;

import com.authrocket.model.shared.State;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/** 
 * @see <a href="https://authrocket.com/docs/api/users">AuthRocket API -- Users</a>
 */
public class User {
    
    @SerializedName( "id" )
    private String id;
    @SerializedName( "state" )
    private State state;
    @SerializedName( "realm_id" )
    private String realmId;
    @SerializedName( "user_type" )
    private String userType;                // TODO : could/should be an enum
    @SerializedName( "last_login_at" )
    private DateTime lastLoginAt;
    @SerializedName( "created_at" )
    private DateTime createdAt;
    @SerializedName( "reference" )
    private String reference;
    @SerializedName( "token" )
    private String token;
    
    // human only
    @SerializedName( "first_name" )
    private String firstName;
    @SerializedName( "last_name" )
    private String lastName;
    @SerializedName( "password" )
    private String password;
    @SerializedName( "password_confirmation" )
    private String passwordConfirmation;
    
    // api only
    @SerializedName( "api_key" )
    private String apiKey;
    
    // human & api only (wat)
    @SerializedName( "username" )
    private String username;
    @SerializedName( "email" )
    private String email;
    @SerializedName( "name" )
    private String name;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public DateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(DateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
