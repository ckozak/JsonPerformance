# Small Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize
[info] # Run complete. Total time: 00:05:27
[info]
[info] Benchmark                   Mode  Cnt        Score       Error  Units
[info] Deserialize.argonaut       thrpt   20   306173.271 ±  6740.448  ops/s
[info] Deserialize.circeJackson   thrpt   20   266859.347 ±  8053.033  ops/s
[info] Deserialize.circeJawn      thrpt   20   257510.955 ±  3433.131  ops/s
[info] Deserialize.jackson        thrpt   20  1006975.456 ± 21085.283  ops/s
[info] Deserialize.json4sJackson  thrpt   20   345123.863 ±  3276.832  ops/s
[info] Deserialize.liftweb        thrpt   20   330420.094 ±  3676.476  ops/s
[info] Deserialize.playJson       thrpt   20   277163.585 ±  3504.662  ops/s
[info] Deserialize.sprayJson      thrpt   20   434971.127 ± 23959.247  ops/s
[success] Total time: 331 s, completed Mar 4, 2016 5:36:48 PM
```

## Serialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Serialize
[info] # Run complete. Total time: 00:05:25
[info]
[info] Benchmark                 Mode  Cnt        Score       Error  Units
[info] Serialize.argonautJson   thrpt   20   307396.685 ±  3732.778  ops/s
[info] Serialize.circeJackson   thrpt   20   339158.332 ±  3876.054  ops/s
[info] Serialize.circeJawn      thrpt   20   352781.205 ±  9430.501  ops/s
[info] Serialize.jackson        thrpt   20  1501204.013 ± 29504.360  ops/s
[info] Serialize.json4sJackson  thrpt   20   427123.035 ±  7935.249  ops/s
[info] Serialize.liftweb        thrpt   20   402390.125 ±  3612.323  ops/s
[info] Serialize.playJson       thrpt   20   210975.406 ±  4420.848  ops/s
[info] Serialize.sprayJson      thrpt   20   565037.251 ±  8730.665  ops/s
[success] Total time: 326 s, completed Mar 4, 2016 5:43:34 PM
```
