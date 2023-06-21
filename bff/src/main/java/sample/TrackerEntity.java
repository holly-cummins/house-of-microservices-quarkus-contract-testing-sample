package sample;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TrackerEntity extends PanacheEntity {

    long timeOfCall;
}