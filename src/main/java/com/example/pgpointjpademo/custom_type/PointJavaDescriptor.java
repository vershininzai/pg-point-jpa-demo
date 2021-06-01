package com.example.pgpointjpademo.custom_type;

import org.hibernate.HibernateException;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;

public class PointJavaDescriptor extends AbstractTypeDescriptor<Point> {

    public static final PointJavaDescriptor INSTANCE = new PointJavaDescriptor();

    public PointJavaDescriptor() {
        super(Point.class, ImmutableMutabilityPlan.INSTANCE);
    }

    /**
     * @param s string example (11.11,33.44)
     * @return
     */
    @Override
    public Point fromString(String s) {
        if (s == null) {
            return null;
        }
        String[] values = s.replace("(", "").replace(")", "").split(",");
        if (values.length != 2) {
            throw new HibernateException("Unknown unwrap conversion requested: " + s + " to Point");
        }
        return new Point(Float.parseFloat(values[0]), Float.parseFloat(values[1]));
    }

    @Override
    public <X> X unwrap(Point value, Class<X> type, WrapperOptions options) {
        if (value == null)
            return null;

        if (String.class.isAssignableFrom(type))
            return (X) String.format("(%s, %s)", value.getLon(), value.getLat());

        throw unknownUnwrap(type);
    }

    @Override
    public <X> Point wrap(X value, WrapperOptions options) {
        if (value == null)
            return null;

        if (value instanceof String)
            return fromString((String) value);

        throw unknownWrap(value.getClass());
    }

}
