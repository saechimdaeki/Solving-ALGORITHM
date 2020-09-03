select round(abs(min(lat_n)-max(lat_n)) + abs(min(long_w)-max(long_w)), 4) from station;
