# Small Scala JSON libraries benchmark

De/serialization of a simple class from existing codebase.

## Deserialization

```
>  jmh:run -i 20 -wi 20 -f1 -t1 com.github.ckozak.url.UrlValidator

[info] # Run complete. Total time: 00:04:03
[info] 
[info] Benchmark                             Mode  Cnt        Score        Error  Units
[info] ValidateUrl.failureWithNewUrl        thrpt   20  7601154.264 ± 420496.342  ops/s
[info] ValidateUrl.failureWithUrlValidator  thrpt   20  1651827.280 ±  57899.863  ops/s
[info] ValidateUrl.failureWithRegex         thrpt   20   762392.200 ±  65500.445  ops/s
[info] ValidateUrl.successWithNewUrl        thrpt   20  6268855.233 ± 207494.480  ops/s
[info] ValidateUrl.successWithRegex         thrpt   20   837002.152 ±  12968.914  ops/s
[info] ValidateUrl.successWithUrlValidator  thrpt   20   276176.758 ±   4833.321  ops/s
[success] Total time: 280 s, completed Jun 1, 2016 7:13:05 PM



>  jmh:run -i 20 -wi 20 -f1 -t16 com.github.ckozak.url.UrlValidator

[info] # Run complete. Total time: 00:04:12
[info] 
[info] Benchmark                             Mode  Cnt        Score        Error  Units
[info] ValidateUrl.failureWithNewUrl        thrpt   20  6619439.893 ± 181525.601  ops/s
[info] ValidateUrl.failureWithUrlValidator  thrpt   20  5773149.148 ± 181853.602  ops/s
[info] ValidateUrl.failureWithRegex         thrpt   20  2302582.556 ± 198898.646  ops/s
[info] ValidateUrl.successWithNewUrl        thrpt   20  6586674.337 ± 332380.037  ops/s
[info] ValidateUrl.successWithRegex         thrpt   20  2101854.217 ± 266065.593  ops/s
[info] ValidateUrl.successWithUrlValidator  thrpt   20  1001315.787 ±  25085.514  ops/s
[success] Total time: 255 s, completed Jun 1, 2016 7:23:40 PM

```