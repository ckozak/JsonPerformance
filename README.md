# Small Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize
[info] # Run complete. Total time: 00:04:46
[info]
[info] Benchmark                   Mode  Cnt       Score       Error  Units
[info] Deserialize.argonaut       thrpt   20  312771.240 ± 10857.879  ops/s
[info] Deserialize.circeJackson   thrpt   20  280691.766 ±  6436.045  ops/s
[info] Deserialize.circeJawn      thrpt   20  290433.103 ± 11085.824  ops/s
[info] Deserialize.jackson        thrpt   20  939221.283 ± 31839.331  ops/s
[info] Deserialize.json4sJackson  thrpt   20  344521.266 ±  7877.949  ops/s
[info] Deserialize.json4sNative   thrpt   20  318550.156 ±  5005.312  ops/s
[info] Deserialize.sprayJson      thrpt   20  390375.674 ±  8316.547  ops/s
[success] Total time: 287 s, completed Mar 4, 2016 2:20:20 PM
```

## Serialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Serialize
[info] # Run complete. Total time: 00:04:45
[info]
[info] Benchmark                 Mode  Cnt        Score       Error  Units
[info] Serialize.argonaut       thrpt   20   321210.896 ± 10926.567  ops/s
[info] Serialize.circeJackson   thrpt   20   342238.032 ± 15188.653  ops/s
[info] Serialize.circeJawn      thrpt   20   331295.903 ± 10299.507  ops/s
[info] Serialize.jackson        thrpt   20  1479139.389 ± 52437.687  ops/s
[info] Serialize.json4sJackson  thrpt   20   439554.353 ± 12789.326  ops/s
[info] Serialize.json4sNative   thrpt   20   300999.804 ±  8148.935  ops/s
[info] Serialize.sprayJson      thrpt   20   656806.482 ± 10432.395  ops/s
[success] Total time: 289 s, completed Mar 4, 2016 2:13:53 PM
```
