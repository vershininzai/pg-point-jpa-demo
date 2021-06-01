package com.example.pgpointjpademo;

import com.example.pgpointjpademo.custom_type.Point;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "test_table")
public class TestObject {

    @Id
    private UUID id;

    @Type(type = "com.example.pgpointjpademo.custom_type.PointType")
    @Column(name = "coord")
    private Point coord;

    public UUID getId() {
        return id;
    }

    public Point getCoord() {
        return coord;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCoord(Point coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "id=" + id +
                ", coord=" + coord +
                '}';
    }
}
