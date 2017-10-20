package com.javaschool.services;

import com.javaschool.dao.WayPointDao;
import com.javaschool.entity.Waypoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bugav on 20.10.2017.
 */
@Service
public class WaypointService {

    @Autowired
    private WayPointDao waypointDao;

    public void persistWaypoint(Waypoint waypoint) {
        waypointDao.create(waypoint);
    }
}