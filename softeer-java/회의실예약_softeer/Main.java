package softeer.회의실예약_softeer;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, List<int[]>> roomMap = new HashMap<>();
        List<String> roomNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String roomName = br.readLine();
            roomNames.add(roomName);
            roomMap.put(roomName, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            String roomName = split[0];
            int startTime = Integer.parseInt(split[1]);
            int endTime = Integer.parseInt(split[2]);
            roomMap.get(roomName).add(new int[]{startTime, endTime});
        }

        Collections.sort(roomNames);

        for (int i = 0; i < roomNames.size(); i++) {
            String roomName = roomNames.get(i);
            bw.write("Room " + roomName + ":\n");

            List<int[]> reservations = roomMap.get(roomName);
            reservations.sort(Comparator.comparingInt(a -> a[0]));

            List<String> availableTimes = new ArrayList<>();
            int current = 9;

            for (int[] reservation : reservations) {
                int start = reservation[0];
                int end = reservation[1];

                if (current < start) {
                    availableTimes.add(formatTime(current) + "-" + formatTime(start));
                }
                current = Math.max(current, end);
            }

            if (current < 18) {
                availableTimes.add(formatTime(current) + "-18");
            }

            if (availableTimes.isEmpty()) {
                bw.write("Not available\n");
            } else {
                bw.write(availableTimes.size() + " available:\n");
                for (String time : availableTimes) {
                    bw.write(time + "\n");
                }
            }
            if (i != roomNames.size() - 1) {
                bw.write("-----\n");
            }
        }
        bw.flush();
    }

    private static String formatTime(int time) {
        return String.format("%02d", time);
    }
}
