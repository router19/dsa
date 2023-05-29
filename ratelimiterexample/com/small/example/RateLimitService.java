package com.small.example;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

public class RateLimitService {
    
	private static final long MILLIS_IN_SECOND = TimeUnit.SECONDS.toMillis(1); //1000
    private static final long MILLIS_IN_MIUTE = TimeUnit.MINUTES.toMillis(1); //60000
    private static final long MILLIS_IN_HOUR = TimeUnit.HOURS.toMillis(1);//3600000
    private static final long MILLIS_IN_DAY = TimeUnit.DAYS.toMillis(1);//86400000
    
    private static final int RATE_LIMIT_PER_MIN = 3;
    
    private static final int RATE_LIMIT_PER_HOUR = 10;
    
    private static Map<Long, ConcurrentSkipListMap<Long, Integer>> limitMap = new HashMap<>();
    private static Map<Long, Integer> requestCounterHourly = new HashMap<>();
    
    public static void main(String[] args) {
        
        RateLimitService rls = new RateLimitService();
        rls.test();
    }
    
    private void test() {
        
        System.out.printf("=============================");
        System.out.printf(String.format("Max reqs in minute: %d | Max reqs in hour: %d", RATE_LIMIT_PER_MIN, RATE_LIMIT_PER_HOUR));
        System.out.printf("=============================");
        
        Long userId = 1L;
        refreshMinuteSlots(userId, System.currentTimeMillis());
        
        long reqT = System.currentTimeMillis();
        int sleepTime = 10000;
        
        for (int i=0; i<6; i++) {
            reqT = System.currentTimeMillis();
            boolean isAllowed = isAllowed(reqT, 1L);
            System.out.printf(String.format("Req at %d allowed? %s (totalRequestsInHour: %d) ", reqT, isAllowed, requestCounterHourly.get(userId)));
            
            sleepTime *= 2; // exponential
            sleep(sleepTime);
        }
        
        System.out.printf("=============================");
        printTimes(limitMap.get(userId));
        System.out.printf("=============================");
        
    }
    
    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    private boolean isAllowed(Long reqT, Long userId) {
        
        ConcurrentSkipListMap<Long, Integer> times = limitMap.get(userId);
        
        Long truncatedMin = truncate(reqT, ChronoUnit.MINUTES); // truncate to the beginning of minute
        
        if (times != null) {
            Long truncatedHour = truncate(reqT, ChronoUnit.HOURS); // truncate to the beginning of hour
            Long truncatedDay = truncate(reqT, ChronoUnit.DAYS); // truncate to the beginning of the day
            
            if ((truncatedMin - truncatedDay >= MILLIS_IN_DAY)
                    || (truncatedMin - truncatedHour >= MILLIS_IN_HOUR)) {
                
                refreshMinuteSlots(userId, reqT);
                requestCounterHourly.put(userId, 0);
            }
            
        } else {
            refreshMinuteSlots(userId, reqT);
            
        }
        
        times = limitMap.get(userId);
        
        // Reject if greater than rate limit threshold
        if ((times.get(truncatedMin) >= RATE_LIMIT_PER_MIN) || (requestCounterHourly.getOrDefault(userId, 0) >= RATE_LIMIT_PER_HOUR)) {
            return false;
        }
        
        System.out.printf(String.format("Putting reqT %d in the bucket %d", reqT, truncatedMin));
        times.put(truncatedMin, times.get(truncatedMin) + 1);
        limitMap.put(userId, times);
        requestCounterHourly.put(userId, requestCounterHourly.getOrDefault(userId, 0) + 1);
        
        return true;
    }
    
    
    /*
     * Truncates the timestamp to the closest time unit.
     * 
     */
    private Long truncate(Long time, ChronoUnit unit) {
    	Instant instant = Instant.ofEpochMilli(time);
    	Instant returnValue = instant.truncatedTo(unit);
    	return returnValue.toEpochMilli();
    }
    
    /* Add new set of minute slots.
     * 
     * @param userId
     * @param reqT
     */
    private void refreshMinuteSlots(Long userId, Long reqT) {
        Long minofDay = truncate(reqT, ChronoUnit.HOURS); // start min of the hour
        
        ConcurrentSkipListMap<Long, Integer> times = new ConcurrentSkipListMap<>();
        
        for (int i=0; i<=59; i++) { // add rounded minutes in an hour to the map
            times.put(minofDay, 0);
            minofDay += MILLIS_IN_MIUTE;
        }
        
        limitMap.put(userId, times);
    }
    
    /*
     * Prints the current requests numbers from the map.
     */
    private void printTimes(ConcurrentSkipListMap<Long, Integer> times) {
        
        System.out.printf("Current state of the times for user...");
        for (Long time : times.keySet()) {
            System.out.printf(time + " : " + times.get(time));
        }
    }
}