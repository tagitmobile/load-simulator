package com.tagit.commons.loadsimulator.web;

import java.security.SecureRandom;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.apachecommons.CommonsLog;

@RestController
@CommonsLog
public class LoadTestController {
	
    @GetMapping("/load/simple")
    public String load1() {
    	long start = System.currentTimeMillis();
    	// Simulate some CPU load
        // For example, compute a large Fibonacci number or do a CPU-intensive loop.
        // Here, we'll do a simple CPU-bound operation: sum of a large array.
        int size = 2000000;
        long [] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }

        long sum = 0;
        for (long n : numbers) {
            sum += n;
        }

        // Return a string response after the computation
    	long end = System.currentTimeMillis();
    	long elapsed = end - start;
        log.info("Computation done. Sum = " + sum + ". Time elapsed = " + elapsed + " ms. on " + Thread.currentThread().toString());
        return "Computation done. Sum = " + sum;
    }
    
    @GetMapping("/load/random")
    public String load2() {
    	long start = System.currentTimeMillis();
        // Define a large size for the array
        int size = 400000;
        
        // Create and populate a large array of random integers
        int[] numbers = new int[size];
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        // Sum the elements to generate CPU usage
        long sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        // Sort the array to increase CPU usage further
        Arrays.sort(numbers);
    	long end = System.currentTimeMillis();
    	long elapsed = end - start;
        log.info("Computation done. Sum of Random Numbers = " + sum + ". Time elapsed = " + elapsed + " ms. on " + Thread.currentThread().toString());
        return "Computation done. Sum of Random Numbers = " + sum;
    }
    
    @GetMapping("/load/fibonacci")
    public String loadFibonacci() {
    	long start = System.currentTimeMillis();
        // Perform another CPU-heavy operation (e.g., compute Fibonacci)
        // Let's do a small but CPU-intensive Fibonacci calculation
        // This is a naive recursive Fibonacci for demonstration (CPU heavy)
        int fibNum = 35; // This is chosen to be somewhat expensive but not infinite
        long fibResult = fibonacci(fibNum);

    	long end = System.currentTimeMillis();
    	long elapsed = end - start;
        log.info("Computation done. Fib(" + fibNum + ") = " + fibResult + ". Time elapsed = " + elapsed + " ms. on " + Thread.currentThread().toString());
        return "Computation done. Fib(" + fibNum + ") = " + fibResult;
    }

    // Naive Fibonacci function (O(2^n) complexity)
    private long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}