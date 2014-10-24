package com.authrocket.model.response;

import com.authrocket.model.core.Membership;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;

/**
 * @see <a href="https://authrocket.com/docs/api/memberships">AuthRocket API -- Memberships</a>
 */
public class MembershipResponse {

    @SerializedName( "more_results" )
    private boolean moreResults;
    @SerializedName( "collection" )
    private Collection<Membership> responseCollection;

    public boolean isMoreResults() {
        return moreResults;
    }

    public void setMoreResults(boolean moreResults) {
        this.moreResults = moreResults;
    }

    public Collection<Membership> getResponseCollection() {
        return responseCollection;
    }

    public void setResponseCollection(Collection<Membership> responseCollection) {
        this.responseCollection = responseCollection;
    }

}
