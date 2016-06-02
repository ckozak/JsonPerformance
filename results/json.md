# Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Deserialize

[info] Deserialize.argonaut             thrpt   20   322561.247 ± 6764.425  ops/s
[info] Deserialize.circeJackson         thrpt   20   375647.712 ± 6731.312  ops/s
[info] Deserialize.circeJawn            thrpt   20   378268.104 ± 2986.006  ops/s
[info] Deserialize.jackson              thrpt   20  1188780.038 ± 6738.448  ops/s
[info] Deserialize.json4sJackson        thrpt   20   347621.372 ± 7632.166  ops/s
[info] Deserialize.liftweb              thrpt   20   381440.600 ± 2713.976  ops/s
[info] Deserialize.playJson             thrpt   20   272712.248 ± 3055.930  ops/s
[info] Deserialize.sprayJson            thrpt   20   599718.807 ± 3803.949  ops/s
[info] DeserializeApp.argonaut          thrpt   20    19705.626 ±  238.288  ops/s
[info] DeserializeApp.circeJackson      thrpt   20    27695.502 ±  205.456  ops/s
[info] DeserializeApp.circeJawn         thrpt   20    24646.291 ±  203.646  ops/s
[info] DeserializeApp.jackson           thrpt   20    84930.568 ±  629.530  ops/s
[info] DeserializeApp.json4sJackson     thrpt   20    23804.283 ±  362.193  ops/s
[info] DeserializeApp.liftweb           thrpt   20    30180.067 ±  134.579  ops/s
[info] DeserializeApp.playJson          thrpt   20    20934.733 ±  137.375  ops/s
[info] DeserializeApp.sprayJson         thrpt   20    36530.713 ±  646.342  ops/s
[info] DeserializeDevice.argonaut       thrpt   20   207323.573 ± 2687.346  ops/s
[info] DeserializeDevice.circeJackson   thrpt   20   270261.253 ± 3358.282  ops/s
[info] DeserializeDevice.circeJawn      thrpt   20   248392.539 ± 2941.236  ops/s
[info] DeserializeDevice.jackson        thrpt   20   507990.898 ± 7415.431  ops/s
[info] DeserializeDevice.json4sJackson  thrpt   20   225010.249 ± 1974.200  ops/s
[info] DeserializeDevice.liftweb        thrpt   20   263717.004 ± 3020.279  ops/s
[info] DeserializeDevice.playJson       thrpt   20   238459.744 ± 4440.187  ops/s
[info] DeserializeDevice.sprayJson      thrpt   20   361890.670 ± 5030.537  ops/s
[info] DeserializeDevice.upickle        thrpt   20   246992.662 ± 1580.255  ops/s

>  jmh:run -i 20 -wi 20 -f1 -t8 com.github.ckozak.Deserialize

```

## Serialization

```
> jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.Serialize[
info] # Run complete. Total time: 00:16:16
[info]
[info] Benchmark                       Mode  Cnt        Score       Error  Units
[info] Serialize.jackson              thrpt   20  1127561.227 ±  7262.808  ops/s
[info] Serialize.upickle              thrpt   20   527485.300 ±  7889.961  ops/s
[info] Serialize.json4sJackson        thrpt   20   457589.113 ±  5850.839  ops/s
[info] Serialize.sprayJson            thrpt   20   376080.384 ± 11351.917  ops/s
[info] Serialize.circeJackson         thrpt   20   357022.960 ± 13515.697  ops/s
[info] Serialize.liftweb              thrpt   20   352495.692 ±  3483.146  ops/s
[info] Serialize.circeJawn            thrpt   20   323917.917 ±  2185.486  ops/s
[info] Serialize.argonautJson         thrpt   20   283318.640 ±  2252.421  ops/s
[info] Serialize.playJson             thrpt   20   182042.058 ±  3196.891  ops/s

[info] SerializeApp.jackson           thrpt   20   260878.327 ±  4247.803  ops/s
[info] SerializeApp.upickle           thrpt   20    53936.732 ±   764.829  ops/s
[info] SerializeApp.liftweb           thrpt   20    50187.644 ±   348.116  ops/s
[info] SerializeApp.json4sJackson     thrpt   20    44996.147 ±  1686.160  ops/s
[info] SerializeApp.circeJackson      thrpt   20    38785.168 ±   364.971  ops/s
[info] SerializeApp.circeJawn         thrpt   20    34853.978 ±   580.764  ops/s

[info] SerializeDevice.jackson        thrpt   20  1783592.014 ± 48540.040  ops/s
[info] SerializeDevice.sprayJson      thrpt   20   761208.608 ± 12226.061  ops/s
[info] SerializeDevice.upickle        thrpt   20   562548.230 ± 14826.756  ops/s
[info] SerializeDevice.circeJawn      thrpt   20   427433.642 ±  3232.449  ops/s
[info] SerializeDevice.circeJackson   thrpt   20   422010.675 ±  6114.524  ops/s
[info] SerializeDevice.liftweb        thrpt   20   401173.599 ±  2777.652  ops/s
[info] SerializeDevice.json4sJackson  thrpt   20   398185.663 ±  7921.566  ops/s
[info] SerializeDevice.argonautJson   thrpt   20   390696.470 ±  9784.074  ops/s
[info] SerializeDevice.playJson       thrpt   20   362313.182 ±  5820.417  ops/s



> jmh:run -i 20 -wi 20 -f1 -t8 com.github.ckozak.Serialize
[info] # Run complete. Total time: 00:16:22
[info]
[info] Benchmark                       Mode  Cnt        Score       Error  Units
[info] Serialize.jackson              thrpt   20  2313672.886 ± 34008.457  ops/s
[info] Serialize.upickle              thrpt   20  1258802.475 ± 22649.163  ops/s
[info] Serialize.circeJackson         thrpt   20  1173836.191 ± 19230.891  ops/s
[info] Serialize.sprayJson            thrpt   20  1135224.990 ± 20701.147  ops/s
[info] Serialize.circeJawn            thrpt   20  1041653.390 ± 17528.737  ops/s
[info] Serialize.liftweb              thrpt   20  1033033.553 ± 14096.358  ops/s
[info] Serialize.argonautJson         thrpt   20   909828.660 ± 16710.429  ops/s
[info] Serialize.json4sJackson        thrpt   20   862211.502 ± 16455.270  ops/s
[info] Serialize.playJson             thrpt   20   717749.058 ± 11808.268  ops/s

[info] SerializeApp.jackson           thrpt   20   823813.128 ± 10929.540  ops/s
[info] SerializeApp.upickle           thrpt   20   183218.909 ±  2564.926  ops/s
[info] SerializeApp.liftweb           thrpt   20   167575.279 ±  2490.064  ops/s
[info] SerializeApp.json4sJackson     thrpt   20   164605.114 ±  5563.360  ops/s
[info] SerializeApp.circeJackson      thrpt   20   148801.493 ±  2112.702  ops/s
[info] SerializeApp.circeJawn         thrpt   20   122382.766 ±  1504.017  ops/s

[info] SerializeDevice.jackson        thrpt   20  4995047.188 ± 54489.443  ops/s
[info] SerializeDevice.sprayJson      thrpt   20  2507520.856 ± 47995.159  ops/s
[info] SerializeDevice.upickle        thrpt   20  1935579.396 ± 21463.865  ops/s
[info] SerializeDevice.playJson       thrpt   20  1376696.149 ± 22962.168  ops/s
[info] SerializeDevice.circeJackson   thrpt   20  1277762.649 ± 32172.304  ops/s
[info] SerializeDevice.circeJawn      thrpt   20  1257608.943 ± 30341.427  ops/s
[info] SerializeDevice.liftweb        thrpt   20  1243331.095 ± 17612.459  ops/s
[info] SerializeDevice.json4sJackson  thrpt   20  1242596.088 ± 31652.300  ops/s
[info] SerializeDevice.argonautJson   thrpt   20  1182351.440 ± 31860.573  ops/s



> jmh:run -i 20 -wi 20 -f1 -t16 com.github.ckozak.Serialize
[info] # Run complete. Total time: 00:17:08
[info]
[info] Benchmark                       Mode  Cnt        Score        Error  Units
[info] Serialize.jackson              thrpt   20  2382851.684 ±  41703.613  ops/s
[info] Serialize.upickle              thrpt   20  1533575.409 ±  43492.224  ops/s
[info] Serialize.sprayJson            thrpt   20  1263564.050 ±  21324.107  ops/s
[info] Serialize.liftweb              thrpt   20  1012052.844 ±   9498.308  ops/s
[info] Serialize.circeJawn            thrpt   20   997487.449 ±  19624.290  ops/s
[info] Serialize.circeJackson         thrpt   20   979071.473 ±  29747.554  ops/s
[info] Serialize.json4sJackson        thrpt   20   874399.626 ±  15059.024  ops/s
[info] Serialize.argonautJson         thrpt   20   824706.647 ±  12159.839  ops/s
[info] Serialize.playJson             thrpt   20   654870.090 ±  13980.800  ops/s

[info] SerializeApp.jackson           thrpt   20   854417.021 ±  11695.326  ops/s
[info] SerializeApp.upickle           thrpt   20   176973.000 ±   6025.012  ops/s
[info] SerializeApp.liftweb           thrpt   20   169060.046 ±   3054.330  ops/s
[info] SerializeApp.json4sJackson     thrpt   20   168596.929 ±   2847.828  ops/s
[info] SerializeApp.circeJawn         thrpt   20   145846.399 ±   1662.886  ops/s
[info] SerializeApp.circeJackson      thrpt   20   129382.646 ±   1851.561  ops/s

[info] SerializeDevice.jackson        thrpt   20  4730408.905 ± 146992.076  ops/s
[info] SerializeDevice.sprayJson      thrpt   20  2401696.146 ±  43598.858  ops/s
[info] SerializeDevice.upickle        thrpt   20  1749413.093 ±  21328.940  ops/s
[info] SerializeDevice.liftweb        thrpt   20  1357824.988 ±  38196.959  ops/s
[info] SerializeDevice.circeJackson   thrpt   20  1296922.854 ±  33801.647  ops/s
[info] SerializeDevice.playJson       thrpt   20  1294121.948 ±  21405.578  ops/s
[info] SerializeDevice.circeJawn      thrpt   20  1227399.375 ±  14729.041  ops/s
[info] SerializeDevice.json4sJackson  thrpt   20  1199460.290 ±  15140.666  ops/s
[info] SerializeDevice.argonautJson   thrpt   20  1188454.313 ±  25825.434  ops/s
[success] Total time: 1030 s, completed May 20, 2016 10:24:49 PM
```
