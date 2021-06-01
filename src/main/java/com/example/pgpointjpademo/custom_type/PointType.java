package com.example.pgpointjpademo.custom_type;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class PointType extends AbstractSingleColumnStandardBasicType<Point> {

    public static final PointType INSTANCE = new PointType();

    public PointType() {
        super(VarcharTypeDescriptor.INSTANCE, PointJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "point";
    }
}