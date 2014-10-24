package com.authrocket.model.response;

import com.authrocket.model.core.Organization;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;

/** 
 * @see <a href="https://authrocket.com/docs/api/orgs">AuthRocket API -- Orgs</a>
 */
public class OrganizationResponse {

    @SerializedName( "more_results" )
    private boolean moreResults;
    @SerializedName( "collection" )
    private Collection<Organization> responseCollection;

    public boolean isMoreResults() {
        return moreResults;
    }

    public void setMoreResults(boolean moreResults) {
        this.moreResults = moreResults;
    }

    public Collection<Organization> getResponseCollection() {
        return responseCollection;
    }

    public void setResponseCollection(Collection<Organization> responseCollection) {
        this.responseCollection = responseCollection;
    }

}
