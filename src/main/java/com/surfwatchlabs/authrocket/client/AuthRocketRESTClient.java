package com.surfwatchlabs.authrocket.client;

import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * <code>AuthRocketRESTClient.java</code> is a pretty basic REST client that handles
 * interactions with the AuthRocket REST API.  It supports only the most basic use cases,
 * and TODOs and other notes are strewn throughout the source to denote other potential
 * functionality.
 */
public class AuthRocketRESTClient implements InitializingBean, DisposableBean {

    // required
    private String authrocketAccountId;
    private String authrocketApiKey;
    
    // optional, set only if using a single realm
    private String authrocketDefaultRealmId = null;
    // default v1 API, can override for hosted login
    private String host = "https://api-e1.authrocket.com/v1/";
    
    
    private MultivaluedMap<String, Object> headers;
    private Client restClient;
    
    // from https://authrocket.com/docs/api
    private static final String AR_ACCOUNT_ID_HEADER = "X-Authrocket-Account";
    private static final String AR_API_KEY_HEADER = "X-Authrocket-Api-Key";
    private static final String AR_REALM_ID_HEADER = "X-Authrocket-Realm";

    private static final Logger LOG = LoggerFactory.getLogger(AuthRocketRESTClient.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if( authrocketAccountId == null || authrocketApiKey == null )
            throw new IllegalArgumentException( "Required parameters not set.  Spring should be setting "
                    + "authrocketAccountId, authrocketApiKey parameters." );
        
        
        headers = new MultivaluedHashMap<>();
        headers.add( AR_ACCOUNT_ID_HEADER, authrocketAccountId );
        headers.add( AR_API_KEY_HEADER, authrocketApiKey );
        if( authrocketDefaultRealmId != null )
            headers.add( AR_REALM_ID_HEADER, authrocketDefaultRealmId );
        headers.add( HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON );
//        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON );
        
        
        // Create generic REST client
        restClient = ClientBuilder.newClient(); 
        // see https://jersey.java.net/documentation/latest/user-guide.html , 
        //  "5.3.2.  Creating and configuring a Client instance"
        // if SSL, etc are needed (via filters) for client
        
        LOG.info( "AuthRocket REST client initialized - {}:{}, {}:******, {}:{}, {}:{}", AR_ACCOUNT_ID_HEADER, authrocketAccountId,
                AR_API_KEY_HEADER, AR_REALM_ID_HEADER, authrocketDefaultRealmId, HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON );
    }

    @Override
    public void destroy() throws Exception {
        LOG.info( "Cleaning up AuthRocket REST client." );
        restClient.close();
    }
    
    public String getResponseJson( String resourcePath, Map<String,String> queryParams ) {
    
        WebTarget resourceTarget = buildWebTarget( resourcePath, queryParams );
        
        LOG.debug( "Issuing GET rest to AuthRocket - uri={}", resourceTarget.getUri().toString() );
        Response response = resourceTarget
                .request( MediaType.APPLICATION_JSON )
                .headers( headers )
                .get( Response.class );
        
        // check for unsuccessful responses
        Response.StatusType statusType = response.getStatusInfo();
        if( !statusType.getFamily().equals( Response.Status.Family.SUCCESSFUL ) ) {
            LOG.error( "Unsuccessful response from AuthRocket server - status={}, statusMsg={}, uri={}", 
                    statusType.getStatusCode(), statusType.getReasonPhrase(), resourceTarget.getUri().toString() );
            return null;
        }
        
        String responseBody = response.readEntity( String.class );
        if( responseBody == null || responseBody.trim().isEmpty() ) {
            LOG.error( "Body of response is empty, cannot continue - status={}, statusMsg={}, uri={}",
                    statusType.getStatusCode(), statusType.getReasonPhrase(), resourceTarget.getUri().toString() );
            return null;
        }
        
        // cuz
        response.close();
        
        LOG.debug( "Returning response body : {}", responseBody );
        return responseBody;
    }
    
    private WebTarget buildWebTarget( String resourcePath, Map<String,String> queryParams ) {
        LOG.debug( "Building new web target - host={}, resourcePath={}", host, resourcePath );
        
        WebTarget target = restClient.target( host );  
        WebTarget resourceTarget = target.path( resourcePath );
        
        if( queryParams != null ) {
            for( Map.Entry<String, String> entry : queryParams.entrySet() ) {
                LOG.debug( "Appending query params to url - key={}, value={}", entry.getKey(), entry.getValue() );
                resourceTarget = resourceTarget.queryParam( entry.getKey(), entry.getValue() );
            }
        }
        
        return resourceTarget;
    }

    // TODO : could make a props object
    public String getAuthrocketAccountId() {
        return authrocketAccountId;
    }

    public void setAuthrocketAccountId(String authrocketAccountId) {
        this.authrocketAccountId = authrocketAccountId;
    }

    public String getAuthrocketApiKey() {
        return authrocketApiKey;
    }

    public void setAuthrocketApiKey(String authrocketApiKey) {
        this.authrocketApiKey = authrocketApiKey;
    }

    public String getAuthrocketDefaultRealmId() {
        return authrocketDefaultRealmId;
    }

    public void setAuthrocketDefaultRealmId(String authrocketDefaultRealmId) {
        this.authrocketDefaultRealmId = authrocketDefaultRealmId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
}
