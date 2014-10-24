package com.authrocket.model.core;

import com.authrocket.model.shared.State;
import com.google.gson.annotations.SerializedName;

/**
 * @see <a href="https://authrocket.com/docs/api/realms">AuthRocket API -- Realms</a>
 */
public class Realm {

    @SerializedName( "id" )
    private String id;
    @SerializedName( "name" )
    private String name;
    @SerializedName( "state" )
    private State state;
    @SerializedName( "reference" )
    private String reference;
    @SerializedName( "username_validation_human" )
    private String usernameValidationHuman;     // TODO : could/should be an enum
    @SerializedName( "require_unique_emails" )
    private Boolean requireUniqueEmails;
    @SerializedName( "api_key_prefix" )
    private String apiKeyPrefix;
    @SerializedName( "api_key_policy" )
    private String apiKeyPolicy;                // TODO : could/should be an enum

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUsernameValidationHuman() {
        return usernameValidationHuman;
    }

    public void setUsernameValidationHuman(String usernameValidationHuman) {
        this.usernameValidationHuman = usernameValidationHuman;
    }

    public Boolean getRequireUniqueEmails() {
        return requireUniqueEmails;
    }

    public void setRequireUniqueEmails(Boolean requireUniqueEmails) {
        this.requireUniqueEmails = requireUniqueEmails;
    }

    public String getApiKeyPrefix() {
        return apiKeyPrefix;
    }

    public void setApiKeyPrefix(String apiKeyPrefix) {
        this.apiKeyPrefix = apiKeyPrefix;
    }

    public String getApiKeyPolicy() {
        return apiKeyPolicy;
    }

    public void setApiKeyPolicy(String apiKeyPolicy) {
        this.apiKeyPolicy = apiKeyPolicy;
    }

}
