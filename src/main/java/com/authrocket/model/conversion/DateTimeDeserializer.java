package com.authrocket.model.conversion;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeDeserializer implements JsonDeserializer<DateTime> {

    private static final Logger LOG = LoggerFactory.getLogger(DateTimeDeserializer.class);
    
    /**
     * AuthRocket returns two formats to represent their datetimes, a 10 digit epoch and another that looks 
     * like a Ruby Time.now.to_f, though it could also be a C time_t.  Either way, Joda expects an epoch 
     * datetime as a 13 digit long, as such we'll first need to identify which incoming format we're to handle 
     * and then modify them to meet the needs of Joda.
     * 
     * If the incoming value is a 10 digit epoch we will pad the miliseconds with 3 0's.  
     * <pre>Ex 1407782920 to 1407782920000</pre>
     * 
     * If the incoming value is a 10 digit epoch with 3 digits for millisecond precision, we will remove the decimal
     * and pretend it was a 13 digit long the whole time ¯\_(ツ)_/¯
     * <pre>Ex: 1407782920.449 to 1407782920449</pre>
     * 
     * @param json
     * @param typeOfT
     * @param context
     * @return a date time object
     * @throws JsonParseException 
     */
    @Override
    public DateTime deserialize( JsonElement json, Type typeOfT, JsonDeserializationContext context)  throws JsonParseException {

        if( json.isJsonNull() ) {
            LOG.error( "Cannot deserialize null json object." );
            return null;
        }
        
        // could throw a ClassCastException, running loosey goosey for now
        String s = json.getAsString();
        if( s == null ) {
            LOG.error( "Cannot deserialize null string." );
            return null;
        }
        
        // 10 digit epoch with 3 decimals for milliseconds
        if( s.contains( "." ) ) {
            // time is epoch w/decimal, so just smush input, I ain't scrrd
            // ex: 1407782920.449 to 1407782920449
            return new DateTime( Long.valueOf( json.getAsString().replace( ".", "" ) ), DateTimeZone.UTC );
        }
        
        // 10 digit (eh)long
        return new DateTime( json.getAsLong() * 1000, DateTimeZone.UTC );
    }
    
}
