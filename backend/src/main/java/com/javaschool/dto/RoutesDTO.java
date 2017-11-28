package com.javaschool.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@SqlResultSetMapping(
        name = "routesResult",
        entities = {
                @EntityResult(
                        entityClass = RoutesDTO.class,
                        fields = {
                                @FieldResult(name = "code", column = "code"),
                                @FieldResult(name = "stationFrom", column = "s_name_first"),
                                @FieldResult(name = "stationTo", column = "s_name_last")
                        }
                )
        }
)
/**
 * This is Data Transport object that returns information for requred route
 */
public class RoutesDTO implements Serializable {

    @Id
    private String code;
    private String stationFrom;
    private String stationTo;

}
