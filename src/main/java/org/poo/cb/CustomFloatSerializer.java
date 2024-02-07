package org.poo.cb;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.DecimalFormat;

public class CustomFloatSerializer extends StdSerializer<Float> {
    protected CustomFloatSerializer() {
        super(Float.class);
    }
    @Override
    public void serialize(Float value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(new DecimalFormat("0.00").format(value));
    }
}
