package com.surfwatchlabs.authrocket.service;

import com.authrocket.model.core.Membership;
import com.authrocket.model.response.MembershipResponse;
import com.google.gson.Gson;
import com.surfwatchlabs.authrocket.client.AuthRocketRESTClient;
import com.surfwatchlabs.authrocket.util.AuthRocketGsonBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>MembershipClientImpl.java</code> is a simple client that can handle GET operations for
 * AuthRocket memberships.
 * 
 * TODO : handle more than GET
 * 
 * @see <a href="https://authrocket.com/docs/api/memberships">AuthRocket API -- Memberships</a>
 */
public class MembershipClientImpl {

    private AuthRocketRESTClient authRocketClient;
    private final Gson gson;    
    
    private static final String ORG_ID_QUERY_PARAM = "org_id";
    private static final String USER_ID_QUERY_PARAM = "user_id";
    private static final String RESOURCE_PATH = "memberships";
    
    private static final Logger LOG = LoggerFactory.getLogger(MembershipClientImpl.class);

    public MembershipClientImpl() {
        gson = AuthRocketGsonBuilder.getBuilder();
    }
    
    public Membership getMembershipById( String membershipId ) {
        LOG.debug( "Getting membership by id - membershipId={}", membershipId );

        // TODO : we could set a whole bunch of query params here if we cared to
        String responseJson = authRocketClient.getResponseJson( RESOURCE_PATH + "/" + membershipId, null );
        
        // null on error in client
        if( responseJson == null )
            return null;
        
        
        Membership membership = gson.fromJson( responseJson, Membership.class );
        LOG.debug( "Returning membership by id - membershipId={}", membershipId );
        return membership;
    }
    
    public Collection<Membership> getMembershipsByOrgId( String organizationId ) {
        LOG.debug( "Getting all memberships by organization - organizationId={}", organizationId );
        
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put( ORG_ID_QUERY_PARAM, organizationId );
        // TODO : we could set a whole bunch of other params here if we cared to
                

        String responseJson = authRocketClient.getResponseJson( RESOURCE_PATH, queryParams );
        
        // null on error in client
        if( responseJson == null )
            return Collections.EMPTY_LIST;
        
        
        MembershipResponse membershipResponse = gson.fromJson( responseJson, MembershipResponse.class );
        LOG.debug( "Returning memberships for organization - organizationId={}, numMemberships={}", organizationId, 
                membershipResponse.getResponseCollection().size() );
        return membershipResponse.getResponseCollection();
    }
    
    public Collection<Membership> getMembershipsByUserId( String userId ) {
        LOG.debug( "Getting all memberships by user - userId={}", userId );
        
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put( USER_ID_QUERY_PARAM, userId );
        // TODO : we could set a whole bunch of other params here if we cared to
                

        String responseJson = authRocketClient.getResponseJson( RESOURCE_PATH, queryParams );
        
        // null on error in client
        if( responseJson == null )
            return Collections.EMPTY_LIST;
        
        
        MembershipResponse membershipResponse = gson.fromJson( responseJson, MembershipResponse.class );
        LOG.debug( "Returning memberships for user - userId={}, numMemberships={}", userId, 
                membershipResponse.getResponseCollection().size() );
        return membershipResponse.getResponseCollection();
    }

    public AuthRocketRESTClient getAuthRocketClient() {
        return authRocketClient;
    }

    public void setAuthRocketClient(AuthRocketRESTClient arClient) {
        this.authRocketClient = arClient;
    }

}
