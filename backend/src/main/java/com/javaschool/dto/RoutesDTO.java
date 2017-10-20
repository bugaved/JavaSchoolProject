package com.javaschool.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bugav on 20.10.2017.
 */
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
public class RoutesDTO implements Serializable {

    @Id
    private String code;
    private String stationFrom;
    private String stationTo;

}