package org.example.type;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SpotType {
    PeopleZone(0),
    ADZone(1),
    NewZone(2),
    Salezone(3),
    SpeccialZone(4),
    OneWayZone(5);

    private Integer type;

}