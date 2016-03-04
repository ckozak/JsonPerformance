```
>  jmh:run -i 30 -wi 30 -f1 -t1 com.github.ckozak.Deserialize
[info] Compiling 2 Scala sources to /Users/constantine.kozak/Development/chartboost/JsonBenchmark/target/scala-2.11/classes...
Processing 26 classes from /Users/constantine.kozak/Development/chartboost/JsonBenchmark/target/scala-2.11/classes with "reflection" generator
Writing out Java source to /Users/constantine.kozak/Development/chartboost/JsonBenchmark/target/scala-2.11/src_managed/jmh and resources to /Users/constantine.kozak/Development/chartboost/JsonBenchmark/target/scala-2.11/resource_managed/jmh
[info] Compiling 6 Java sources to /Users/constantine.kozak/Development/chartboost/JsonBenchmark/target/scala-2.11/jmh-classes...
[info] Running org.openjdk.jmh.Main -i 30 -wi 30 -f1 -t1 com.github.ckozak.Deserialize
[info] # JMH 1.11.3 (released 49 days ago)
[info] # VM version: JDK 1.8.0_65, VM 25.65-b01
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 30 iterations, 1 s each
[info] # Measurement: 30 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: com.github.ckozak.Deserialize.circe
[info]
[info] # Run progress: 0.00% complete, ETA 00:02:00
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 0.155 ops/s
...skipped
[info] # Warmup Iteration  30: 0.203 ops/s
[info] Iteration   1: 0.186 ops/s
[...skipped
[info] Iteration  30: 0.204 ops/s
[info]
[info]
[info] Result "circe":
[info]   0.201 ±(99.9%) 0.005 ops/s [Average]
[info]   (min, avg, max) = (0.183, 0.201, 0.214), stdev = 0.008
[info]   CI (99.9%): [0.195, 0.206] (assumes normal distribution)
[info]
[info]
[info] # JMH 1.11.3 (released 49 days ago)
[info] # VM version: JDK 1.8.0_65, VM 25.65-b01
[info] # VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/bin/java
[info] # VM options: <none>
[info] # Warmup: 30 iterations, 1 s each
[info] # Measurement: 30 iterations, 1 s each
[info] # Timeout: 10 min per iteration
[info] # Threads: 1 thread, will synchronize iterations
[info] # Benchmark mode: Throughput, ops/time
[info] # Benchmark: com.github.ckozak.Deserialize.jackson
[info]
[info] # Run progress: 50.00% complete, ETA 00:05:13
[info] # Fork: 1 of 1
[info] # Warmup Iteration   1: 0.394 ops/s
...skipped
[info] # Warmup Iteration  30: 0.679 ops/s
[info] Iteration   1: 0.605 ops/s
...skipped
[info] Iteration  30: 0.691 ops/s
[info]
[info]
[info] Result "jackson":
[info]   0.599 ±(99.9%) 0.053 ops/s [Average]
[info]   (min, avg, max) = (0.402, 0.599, 0.698), stdev = 0.079
[info]   CI (99.9%): [0.546, 0.653] (assumes normal distribution)
[info]
[info]
[info] # Run complete. Total time: 00:07:05
[info]
[info] Benchmark             Mode  Cnt  Score   Error  Units
[info] Deserialize.circe    thrpt   30  0.201 ± 0.005  ops/s
[info] Deserialize.jackson  thrpt   30  0.599 ± 0.053  ops/s
[success] Total time: 431 s, completed Mar 3, 2016 8:47:05 PM
```