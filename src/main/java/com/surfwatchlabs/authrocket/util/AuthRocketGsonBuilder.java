package com.surfwatchlabs.authrocket.util;

import com.authrocket.model.conversion.DateTimeDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

/**
 * <code>AuthRocketGsonBuilder.java</code> is an AuthRocket-specific class that will
 * provide Gson instance(s) that can handle the json format in responses from AuthRocket.
 */
public class AuthRocketGsonBuilder {

    public static final Gson getBuilder() {
        GsonBuilder gb = new GsonBuilder();
        gb.setFieldNamingPolicy( FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES );
        // handle Joda DateTime object
        gb.registerTypeAdapter( DateTime.class, new DateTimeDeserializer() );
        return gb.create();
    }
}
