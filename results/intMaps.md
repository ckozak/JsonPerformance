# Small Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.maps.IntMapVSHashMapVsTreeMapOne

[info] # Run complete. Total time: 00:06:39
[info]
[info] Benchmark                                       Mode  Cnt          Score         Error  Units
[info] IntMapVSHashMapVsTreeMapOne.hashMap1000Get     thrpt   20  141445563.429 ± 2662966.233  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000Get      thrpt   20   80770863.293 ± 1647555.574  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000Get     thrpt   20   51256427.490 ±  760141.517  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap100000Get   thrpt   20   85355774.472 ± 1016115.789  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap100000Get    thrpt   20   40626451.827 ±  953807.900  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap100000Get   thrpt   20   32760736.714 ±  508653.743  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap1000000Get  thrpt   20   79450624.132 ±  573876.162  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000000Get   thrpt   20   27482989.834 ±  467748.164  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000000Get  thrpt   20   24379859.324 ±  769448.554  ops/s
[success] Total time: 402 s, completed Jun 4, 2016 10:38:56 AM


>  jmh:run -i 20 -wi 20 -f1 -t16 com.github.ckozak.url.UrlValidator

[info] # Run complete. Total time: 00:06:54
[info]
[info] Benchmark                                       Mode  Cnt          Score          Error  Units
[info] IntMapVSHashMapVsTreeMapOne.hashMap1000Get     thrpt   20  442219705.255 ± 40499042.732  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000Get      thrpt   20  362117382.444 ±  5016002.247  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000Get     thrpt   20  162944730.362 ±  6286504.162  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap100000Get   thrpt   20  278657344.730 ±  5795747.983  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap100000Get    thrpt   20  178553988.505 ±  2146903.597  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap100000Get   thrpt   20  107217451.120 ±  1615097.862  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap1000000Get  thrpt   20  252115833.484 ±  4949437.168  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000000Get   thrpt   20  157491584.900 ±  3081346.611  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000000Get  thrpt   20   70528833.158 ±   863607.068  ops/s
[success] Total time: 415 s, completed Jun 4, 2016 10:46:31 AM



> jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.maps.IntMapVSHashMapVsTreeMapTen

[info] # Run complete. Total time: 00:06:54
[info]
[info] Benchmark                                       Mode  Cnt          Score          Error  Units
[info] IntMapVSHashMapVsTreeMapOne.hashMap1000Get     thrpt   20  442219705.255 ± 40499042.732  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000Get      thrpt   20  362117382.444 ±  5016002.247  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000Get     thrpt   20  162944730.362 ±  6286504.162  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap100000Get   thrpt   20  278657344.730 ±  5795747.983  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap100000Get   thrpt   20  107217451.120 ±  1615097.862  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap100000Get    thrpt   20  178553988.505 ±  2146903.597  ops/s

[info] IntMapVSHashMapVsTreeMapOne.hashMap1000000Get  thrpt   20  252115833.484 ±  4949437.168  ops/s
[info] IntMapVSHashMapVsTreeMapOne.intMap1000000Get   thrpt   20  157491584.900 ±  3081346.611  ops/s
[info] IntMapVSHashMapVsTreeMapOne.treeMap1000000Get  thrpt   20   70528833.158 ±   863607.068  ops/s
[success] Total time: 415 s, completed Jun 4, 2016 10:46:31 AM

```