package com.surfwatchlabs.authrocket.service;

import com.authrocket.model.core.Organization;
import com.authrocket.model.response.OrganizationResponse;
import com.google.gson.Gson;
import com.surfwatchlabs.authrocket.client.AuthRocketRESTClient;
import com.surfwatchlabs.authrocket.util.AuthRocketGsonBuilder;
import java.util.Collection;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>OrganizationClientImpl.java</code> is a simple client that can handle GET operations for
 * AuthRocket orgs.
 * 
 * TODO : handle more than GET
 * 
 * @see <a href="https://authrocket.com/docs/api/orgs">AuthRocket API -- Orgs</a>
 */
public class OrganizationClientImpl {

    private AuthRocketRESTClient authRocketClient;
    private final Gson gson;    
    
    private static final String RESOURCE_PATH = "orgs";
    
    private static final Logger LOG = LoggerFactory.getLogger(OrganizationClientImpl.class);

    public OrganizationClientImpl() {
        gson = AuthRocketGsonBuilder.getBuilder();
    }
    
    public Collection<Organization> getOrganizations() {
        LOG.debug( "Getting all organizations" );
        
        // TODO : we could set a whole bunch of query params here if we cared to
        String responseJson = authRocketClient.getResponseJson( RESOURCE_PATH, null );
        
        // null on error in client
        if( responseJson == null )
            return Collections.EMPTY_LIST;
        
        
        OrganizationResponse response = gson.fromJson( responseJson, OrganizationResponse.class );
        LOG.debug( "Returning all organizations - numOrganizations={}", response.getResponseCollection().size() );
        return response.getResponseCollection();
    }
    
    public Organization getOrganizationById( String organizationId ) {
        LOG.debug( "Getting organization by id - organizationId={}", organizationId );

        // TODO : we could set a whole bunch of query params here if we cared to
        String responseJson = authRocketClient.getResponseJson( RESOURCE_PATH + "/" + organizationId, null );
        
        // null on error in client
        if( responseJson == null )
            return null;
        
        
        Organization organization = gson.fromJson( responseJson, Organization.class );
        LOG.debug( "Returning organization by id - organizationId={}", organizationId );
        return organization;
    }
    
    
    public AuthRocketRESTClient getAuthRocketClient() {
        return authRocketClient;
    }

    public void setAuthRocketClient(AuthRocketRESTClient arClient) {
        this.authRocketClient = arClient;
    }

}
