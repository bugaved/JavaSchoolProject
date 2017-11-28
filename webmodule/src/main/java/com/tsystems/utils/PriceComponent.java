package com.tsystems.utils;

import com.javaschool.entity.Route;
import com.javaschool.entity.Train;
import com.javaschool.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class that calculates price of ticket
 */
@Component
public class PriceComponent {

    private static final double HIGH_SPEED_TRAIN_KOEF = 1.52;

    @Autowired
    private RouteService routeService;

    /**
     * Calculating ticket price
     *
     * @param routeCode - number of train
     * @param distance - distance between stations
     * @return int object, price of ticket
     */
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
