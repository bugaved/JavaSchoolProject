SELECT a.train_id
FROM (SELECT *
      FROM schedules
      WHERE station_name = 'A') AS a
  , (SELECT *
     FROM schedules
     WHERE station_name = 'B') AS b
WHERE a.arrival_time < ? AND b.arrival_time > ? AND (a.train_id = b.train_id)