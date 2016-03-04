```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize
[info] Running org.openjdk.jmh.Main -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize
[info] # JMH 1.11.3 (released 49 days ago)
[info] # VM version: JDK 1.8.0_65, VM 25.65-b01
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 20 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: com.github.ckozak.Deserialize.circeJackson
[info]
[info] # Run progress: 0.00% complete, ETA 00:02:00
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 99349.674 ops/s
[info] # Warmup Iteration   2: 228239.221 ops/s
...skipped
[info] # Warmup Iteration  20: 292636.053 ops/s
[info] Iteration   1: 290776.619 ops/s
...skipped
[info] Iteration  20: 288890.010 ops/s
[info]
[info]
[info] Result "circeJackson":
[info]   289445.587 ±(99.9%) 1886.762 ops/s [Average]
[info]   (min, avg, max) = (283341.491, 289445.587, 291906.416), stdev = 2172.798
[info]   CI (99.9%): [287558.825, 291332.350] (assumes normal distribution)
[info]
[info]
[info] # JMH 1.11.3 (released 49 days ago)
[info] # VM version: JDK 1.8.0_65, VM 25.65-b01
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 20 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: com.github.ckozak.Deserialize.circeJawn
[info]
[info] # Run progress: 33.33% complete, ETA 00:01:21
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 123440.701 ops/s
...skipped
[info] # Warmup Iteration  20: 265102.921 ops/s
[info] Iteration   1: 264359.967 ops/s
...skipped
[info] Iteration  20: 262901.101 ops/s
[info]
[info]
[info] Result "circeJawn":
[info]   264740.482 ±(99.9%) 4632.429 ops/s [Average]
[info]   (min, avg, max) = (243120.566, 264740.482, 268116.250), stdev = 5334.712
[info]   CI (99.9%): [260108.053, 269372.911] (assumes normal distribution)
[info]
[info]
[info] # JMH 1.11.3 (released 49 days ago)
[info] # VM version: JDK 1.8.0_65, VM 25.65-b01
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 20 iterations, 1 s each
[info] # Measurement: 20 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: com.github.ckozak.Deserialize.jackson
[info]
[info] # Run progress: 66.67% complete, ETA 00:00:40
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 825569.844 ops/s
[info] # Warmup Iteration   2: 951503.322 ops/s
...skipped
[info] # Warmup Iteration  20: 1035787.864 ops/s
[info] Iteration   1: 1050863.202 ops/s
[info] Iteration   2: 1042832.079 ops/s
...skipped
[info] Iteration  20: 1050044.408 ops/s
[info]
[info]
[info] Result "jackson":
[info]   1046189.483 ±(99.9%) 4956.994 ops/s [Average]
[info]   (min, avg, max) = (1036793.267, 1046189.483, 1060259.636), stdev = 5708.482
[info]   CI (99.9%): [1041232.488, 1051146.477] (assumes normal distribution)
[info]
[info]
[info] # Run complete. Total time: 00:02:02
[info]
[info] Benchmark                  Mode  Cnt        Score      Error  Units
[info] Deserialize.circeJackson  thrpt   20   289445.587 ± 1886.762  ops/s
[info] Deserialize.circeJawn     thrpt   20   264740.482 ± 4632.429  ops/s
[info] Deserialize.jackson       thrpt   20  1046189.483 ± 4956.994  ops/s
[success] Total time: 129 s, completed Mar 3, 2016 9:01:59 PM
```