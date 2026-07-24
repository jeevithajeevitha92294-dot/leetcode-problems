class UndergroundSystem {

    // Stores passenger check-in information
    class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Stores route statistics
    class Route {
        int totalTime;
        int tripCount;

        Route() {
            totalTime = 0;
            tripCount = 0;
        }
    }

    private HashMap<Integer, CheckIn> checkInMap;
    private HashMap<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn passenger = checkInMap.get(id);

        String route = passenger.stationName + "->" + stationName;

        Route data = routeMap.getOrDefault(route, new Route());

        data.totalTime += (t - passenger.time);
        data.tripCount++;

        routeMap.put(route, data);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Route data = routeMap.get(route);

        return (double) data.totalTime / data.tripCount;
    }
}
