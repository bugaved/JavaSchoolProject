package com.tsystems.utils;

import com.javaschool.entity.Route;
import com.javaschool.entity.Train;
import com.javaschool.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bugav on 27.11.2017.
 */
@Component
public class PriceComponent {

    private static final double HIGH_SPEED_TRAIN_KOEF = 1.52;

    @Autowired
    private RouteService routeService;


    public int countPrice(String routeCode, int distance) {

        Route route = routeService.findRouteByCode(routeCode);
        Train train = route.getTrains().get(0);

        int result = (1200 + distance);

        if (train.isHighspeed()) {
            result = (int) (result * HIGH_SPEED_TRAIN_KOEF);
            return result;
        }
        return result;
    }

}
