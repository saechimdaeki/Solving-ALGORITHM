select round(sqrt(pow(min(lat_n)-max(lat_n), 2) + pow(min(long_w)-max(long_w), 2)), 4) from station;
