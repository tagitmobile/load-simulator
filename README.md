# Load Simulator


## How to Start the Load Simulator

### Ubuntu

```
sudo apt install openjdk-21-jre-headless -y
java --version
wget https://github.com/tagitmobile/load-simulator/releases/download/v0.0.3/load-simulator-0.0.3.jar
java -jar load-simulator-0.0.3.jar
```

That's it!

## Benchmarking the Load Simulator

### Smoke Test 

To test the simulate, use the following commands:

- `curl localhost:8080/load/simple`
- `curl localhost:8080/load/random`
- `curl localhost:8080/load/fibonacci`

You should see the following lines printed in the server.

```
2024-12-19T14:36:46.900Z  INFO 1544 --- [LoadSimulator] [mcat-handler-10] c.t.c.l.web.LoadTestController           : Computation done. Sum = 1999999000000. Time elapsed = 9 ms. on VirtualThread[#42,tomcat-handler-10]/runnable@ForkJoinPool-1-worker-1

2024-12-19T14:37:22.744Z  INFO 1544 --- [LoadSimulator] [mcat-handler-16] c.t.c.l.web.LoadTestController           : Computation done. Sum of Random Numbers = 429836190657872. Time elapsed = 59 ms. on VirtualThread[#49,tomcat-handler-16]/runnable@ForkJoinPool-1-worker-2

2024-12-19T14:37:57.602Z  INFO 1544 --- [LoadSimulator] [mcat-handler-18] c.t.c.l.web.LoadTestController           : Computation done. Fib(35) = 9227465. Time elapsed = 40 ms. on VirtualThread[#51,tomcat-handler-18]/runnable@ForkJoinPool-1-worker-3
```

### Benchmark

#### Install Apache HTTP Server Benchmarking Tool

https://httpd.apache.org/docs/2.4/programs/ab.html

```
sudo apt install apache2-utils -y
```

#### Run locally

```
ab -n 10 -c 2 http://localhost:8080/load/simple
```

#### Run remotely

##### Simple

```
ab -n 10000 -c 8 http://ec2-18-136-200-73.ap-southeast-1.compute.amazonaws.com:8080/load/simple
```

##### Random

```
ab -n 1000 -c 8 http://ec2-18-136-200-73.ap-southeast-1.compute.amazonaws.com:8080/load/random
```

Increase the number of requests `-n` and the concurrency `-c` accordingly to perform the load test.
