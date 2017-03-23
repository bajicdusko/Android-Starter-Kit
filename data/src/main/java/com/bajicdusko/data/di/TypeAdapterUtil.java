package com.bajicdusko.data.di;

import com.bajicdusko.data.exception.DateParsingException;
import com.bajicdusko.data.util.DateTimeUtil;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.joda.time.DateTime;

import java.io.IOException;

/**
 * Created by Bajic Dusko (www.bajicdusko.com) on 28/02/17.
 */

public class TypeAdapterUtil {

    public static TypeAdapter<Boolean> getBooleanAdapter() {
        return new TypeAdapter<Boolean>() {
            @Override
            public void write(JsonWriter out, Boolean value) throws IOException {
                if (out == null) {
                    out.nullValue();
                } else {
                    out.value(value);
                }
            }

            @Override
            public Boolean read(JsonReader in) throws IOException {
                JsonToken token = in.peek();
                switch (token) {
                    case BOOLEAN:
                        return in.nextBoolean();
                    case NULL:
                        in.nextNull();
                        return null;
                    case NUMBER:
                        return in.nextInt() != 0;
                    case STRING:
                        return Boolean.parseBoolean(in.nextString());
                    default:
                        throw new IllegalStateException("Expected BOOLEAN or NUMBER but was " + token);
                }
            }
        };
    }

    public static TypeAdapter<DateTime> getDateTimeAdapter() {
        return new TypeAdapter<DateTime>() {
            @Override
            public void write(JsonWriter out, DateTime value) throws IOException {
                if (out == null) {
                    out.nullValue();
                } else {
                    out.value(DateTimeUtil.toString(value));
                }
            }

            @Override
            public DateTime read(JsonReader in) throws IOException {
                long dateValue = DateTime.now().getMillis();
                if (in.peek() == JsonToken.NUMBER) {
                    try {
                        return DateTimeUtil.toDateTimeFromMillis(dateValue = (in.nextLong() * 1000));
                    } catch (Exception e) {
                        throw new DateParsingException(dateValue, e);
                    }
                }

                throw new DateParsingException(dateValue, null);
            }
        };
    }
}
