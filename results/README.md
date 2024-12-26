# Running the Benchmark

## Set the SERVER

```
SERVER=ec2-47-129-226-202.ap-southeast-1.compute.amazonaws.com:8080
```

## Run `ab` Benchmark

```
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple
ab -n 10000 -c 8 $SERVER/load/simple


ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random
ab -n 1000 -c 8 $SERVER/load/random


ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom
ab -n 1000 -c 8 $SERVER/load/securerandom


ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light
ab -n 1000 -c 8 $SERVER/simulate/light


ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
ab -n 1000 -c 8 $SERVER/simulate/heavy
```

