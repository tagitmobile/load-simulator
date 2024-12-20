package com.tagit.commons.loadsimulator.web;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.apachecommons.CommonsLog;

@RestController
@CommonsLog
public class SimulatorTestController {    
    

    @GetMapping("/simulate/light")
    public String simulateLightLoad() throws Exception {
    	long start = System.currentTimeMillis();
        // 1. Simulate parsing JSON input (e.g., a request payload)
        String json = """
        {
          "users": [
            { "id": 1, "name": "Alice" },
            { "id": 2, "name": "Bob" },
            { "id": 3, "name": "Charlie" },
            { "id": 4, "name": "Delta" },
            { "id": 5, "name": "Eve" },
            { "id": 6, "name": "Fire" },
            { "id": 7, "name": "Greta" },
            { "id": 8, "name": "Helga" },
            { "id": 9, "name": "Ian" },
            { "id": 10, "name": "John" },
            { "id": 11, "name": "Kyle" },
            { "id": 12, "name": "Lila" },
            { "id": 13, "name": "Mona" },
            { "id": 14, "name": "Nancy" },
            { "id": 15, "name": "Oscar" },
            { "id": 16, "name": "Petra" },
            { "id": 17, "name": "Queen" },
            { "id": 18, "name": "Rosetta" },
            { "id": 19, "name": "Sierra" },
            { "id": 20, "name": "Tyler" },
            { "id": 21, "name": "Ulrich" },
            { "id": 22, "name": "Violet" },
            { "id": 23, "name": "Wilcon" },
            { "id": 24, "name": "Xena" },
            { "id": 25, "name": "Yennefer" },
            { "id": 26, "name": "Zelda" }
          ]
        }
        """;

        Gson gson = new Gson();
        Data data = gson.fromJson(json, Data.class);
        String json2 = gson.toJson(data);
        json2.hashCode();
        log.info("[simulateLoad] JSON parsing done in " + (System.currentTimeMillis() - start) + " ms. on " + Thread.currentThread().toString());

        // 4. Optional: simulate I/O latency by sleeping a bit
        long start2 = System.currentTimeMillis();
        Thread.sleep(250); // Uncomment if desired
        log.info("[simulateLoad] I/O simulation 1 done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());
        
        // 3. Optional: simulate some memory usage by creating a large object
        //    (e.g., a large string) and doing a small amount of work with it.
        start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(RandomStringUtils.insecure().next(10));
        }
        String largeString = sb.toString();
        log.info("[simulateLoad] String manipulation done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());

        // Return a simple response
    	long end = System.currentTimeMillis();
    	long elapsed = end - start;
        log.info("Processed " + data.users.length + " users. " +
                "Large string length: " + largeString.length() + ". Time elapsed = " + elapsed + " ms. on " + Thread.currentThread().toString());
        return "Processed " + data.users.length + " users. " +
                "Large string length: " + largeString.length();
    }
	
    @GetMapping("/simulate/heavy")
    public String simulateHeavyLoad() throws Exception {
    	long start = System.currentTimeMillis();
        // 1. Simulate parsing JSON input (e.g., a request payload)
        String json = """
        {
          "users": [
            { "id": 1, "name": "Alice" },
            { "id": 2, "name": "Bob" },
            { "id": 3, "name": "Charlie" },
            { "id": 4, "name": "Delta" },
            { "id": 5, "name": "Eve" },
            { "id": 6, "name": "Fire" },
            { "id": 7, "name": "Greta" },
            { "id": 8, "name": "Helga" },
            { "id": 9, "name": "Ian" },
            { "id": 10, "name": "John" },
            { "id": 11, "name": "Kyle" },
            { "id": 12, "name": "Lila" },
            { "id": 13, "name": "Mona" },
            { "id": 14, "name": "Nancy" },
            { "id": 15, "name": "Oscar" },
            { "id": 16, "name": "Petra" },
            { "id": 17, "name": "Queen" },
            { "id": 18, "name": "Rosetta" },
            { "id": 19, "name": "Sierra" },
            { "id": 20, "name": "Tyler" },
            { "id": 21, "name": "Ulrich" },
            { "id": 22, "name": "Violet" },
            { "id": 23, "name": "Wilcon" },
            { "id": 24, "name": "Xena" },
            { "id": 25, "name": "Yennefer" },
            { "id": 26, "name": "Zelda" }
          ]
        }
        """;

        Gson gson = new Gson();
        Data data = gson.fromJson(json, Data.class);
        String json2 = gson.toJson(data);
        json2.hashCode();
        log.info("[simulateLoad] JSON parsing done in " + (System.currentTimeMillis() - start) + " ms. on " + Thread.currentThread().toString());

        // 2. Simulate CPU work: sort a large array
        long start2 = System.currentTimeMillis();
        int size = 20000;
        double[] largeArray = new double[size];
        BigDecimal result = BigDecimal.ONE;
        for (int i = 0; i < size; i++) {
            largeArray[i] = RandomUtils.secure().randomDouble(0, 10);
            result = result.multiply(BigDecimal.valueOf(largeArray[i]));
            result = result.divide(BigDecimal.valueOf(largeArray[i]));
            result = result.add(BigDecimal.valueOf(largeArray[i]));
        }
        Arrays.sort(largeArray);
        log.info("[simulateLoad] Number crunching done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());

        // 4. Optional: simulate I/O latency by sleeping a bit
        start2 = System.currentTimeMillis();
        Thread.sleep(250); // Uncomment if desired
        log.info("[simulateLoad] I/O simulation 1 done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());
        
        // 3. Optional: simulate some memory usage by creating a large object
        //    (e.g., a large string) and doing a small amount of work with it.
        start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            sb.append(RandomStringUtils.insecure().next(10));
        }
        String largeString = sb.toString();
        log.info("[simulateLoad] String manipulation done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());

        // 4. Optional: simulate I/O latency by sleeping a bit
        start2 = System.currentTimeMillis();
        Thread.sleep(250); // Uncomment if desired
        log.info("[simulateLoad] I/O simulation 2 done in " + (System.currentTimeMillis() - start2) + " ms. on " + Thread.currentThread().toString());

        // Return a simple response
    	long end = System.currentTimeMillis();
    	long elapsed = end - start;
        log.info("Processed " + data.users.length + " users. " +
        		"BigDecimal calculated: " + result + " " +
                "Array sorted. " +
                "Large string length: " + largeString.length() + ". Time elapsed = " + elapsed + " ms. on " + Thread.currentThread().toString());
        return "Processed " + data.users.length + " users. " +
        		"BigDecimal calculated: " + result + " " +
                "Array sorted. " +
                "Large string length: " + largeString.length();
    }
    
    // Simple DTO to represent parsed JSON
    public static class Data {
        public User[] users;
    }

    public static class User {
        public int id;
        public String name;
    }
}