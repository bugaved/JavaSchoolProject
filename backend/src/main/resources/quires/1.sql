SELECT a.route_id
 FROM (SELECT *
      FROM wayponts
      WHERE station_id = :A) AS a
  , (SELECT *
     FROM waypoints
     WHERE station_id = :B) AS b
     INNER JOIN routes r on a.route_id = r.id
WHERE a.arrival_time < :date AND b.arrival_time > :date AND (a.route_id = b.route_id)