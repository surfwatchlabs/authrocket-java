package com.authrocket.model.core;

import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import org.joda.time.DateTime;

/**
 * @see <a href="https://authrocket.com/docs/api/memberships">AuthRocket API -- Memberships</a>
 */
public class Membership {

    @SerializedName( "id" )
    private String id;
    @SerializedName( "org_id" )
    private String orgId;
    @SerializedName( "user_id" )
    private String userId;
    @SerializedName( "permissions" )
    private Collection<String> permissions;
    @SerializedName( "expires_at" )
    private DateTime expiresAt;
    @SerializedName( "user" )
    private User user;
    @SerializedName( "org" )
    private Organization organization;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }

    public DateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(DateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}
