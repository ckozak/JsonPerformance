# Small Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize
[info] # Run complete. Total time: 00:04:05
[info]
[info] Benchmark                   Mode  Cnt        Score       Error  Units
[info] Deserialize.circeJackson   thrpt   20   293584.802 ±  9416.542  ops/s
[info] Deserialize.circeJawn      thrpt   20   269890.021 ±  3179.824  ops/s
[info] Deserialize.jackson        thrpt   20  1060605.209 ± 20595.068  ops/s
[info] Deserialize.json4sJackson  thrpt   20   322096.669 ±  8665.876  ops/s
[info] Deserialize.json4sNative   thrpt   20   252133.401 ±  8214.953  ops/s
[info] Deserialize.sprayJson      thrpt   20   426984.500 ±  7061.695  ops/s
[success] Total time: 247 s, completed Mar 4, 2016 12:48:33 PM
```

## Serialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Serialize
[info] Benchmark                 Mode  Cnt        Score       Error  Units
[info] Serialize.circeJackson   thrpt   20   436707.147 ± 11491.560  ops/s
[info] Serialize.circeJawn      thrpt   20   363362.878 ± 14312.677  ops/s
[info] Serialize.jackson        thrpt   20  1540314.364 ± 49723.474  ops/s
[info] Serialize.json4sJackson  thrpt   20  2028533.833 ± 47269.747  ops/s
[info] Serialize.json4sNative   thrpt   20   339146.081 ±  7255.529  ops/s
[info] Serialize.sprayJson      thrpt   20  1514108.955 ± 14711.501  ops/s
[success] Total time: 246 s, completed Mar 4, 2016 1:07:10 PM
```
