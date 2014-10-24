package com.authrocket.model.core;

import com.authrocket.model.shared.State;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

/** 
 * @see <a href="https://authrocket.com/docs/api/orgs">AuthRocket API -- Orgs</a>
 */
public class Organization {
    
    @SerializedName( "id" )
    private String id;
    @SerializedName( "realm_id" )
    private String realmId;
    @SerializedName( "name" )
    private String name;
    @SerializedName( "state" )
    private State state;
    @SerializedName( "reference" )
    private String reference;
    @SerializedName( "object" )
    private String objectType;
    @SerializedName( "created_at" )
    private DateTime createdAt;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
