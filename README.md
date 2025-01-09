# Multiffi FFI Benchmark

JMH performance benchmark for Java's native call APIs/libraries: 
[JNI](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/jniTOC.html), 
[FFM](https://openjdk.org/jeps/454), 
[JNA](https://github.com/java-native-access/jna), 
[JNADirect](https://github.com/java-native-access/jna/blob/master/www/DirectMapping.md), 
[JNR](https://github.com/jnr/jnr-ffi), 
[JFFI](https://github.com/jnr/jffi), 
[Multiffi/FFI](https://github.com/multiffi/ffi).

## Benchmark
5 functions to measure:
- no arguments, return void
- no arguments, return int
- 1 argument: int, return int
- no arguments, return double
- 1 argument: double, return double

## Build
### Prerequisites
- JDK 22+
- Gradle 8.10
- C compiler with C99 support
- CMake 3.24+ with a valid backend
- JAVA_HOME environment variable

### Example (sh, CMake with Makefile Backend)
First, build the native shared library:
```shell
cd ${PROJECT_ROOT}/src/main/c
cmake -S . -B ./build -DCMAKE_BUILD_TYPE=MinSizeRel
cd build
make
cp ${LIBRARY_NAME} ${PROJECT_ROOT}/
```

Then, run the jmh main class:
```shell
cd ${PROJECT_ROOT}
./gradlew clean jmh
```

## Results
CPU: Intel® Core™ i7-1165G7 @ 2.80GHz  
OS: GNU/Linux  
JDK: Eclipse Temurin JDK 23.0.1+11  
VM: OpenJDK 64-Bit Server VM, 23.0.1+11  
JMH version: 1.37
Blackhole mode: compiler (auto-detected)  
Warmup: 3 iterations, 10 s each  
Measurement: 5 iterations, 10 s each  
Benchmark mode: Average time, time/op (smaller is better)

```text
Benchmark                                                  Mode  Cnt    Score     Error  Units
FFIBenchmark.measureFFMCriticalReturnDouble                avgt    5    3.921 ±   4.357  ns/op
FFIBenchmark.measureFFMCriticalReturnDoubleD               avgt    5    3.990 ±   1.784  ns/op
FFIBenchmark.measureFFMCriticalReturnInt                   avgt    5    3.620 ±   2.541  ns/op
FFIBenchmark.measureFFMCriticalReturnIntI                  avgt    5    3.874 ±   1.402  ns/op
FFIBenchmark.measureFFMCriticalReturnVoid                  avgt    5    3.777 ±   2.609  ns/op
FFIBenchmark.measureFFMReturnDouble                        avgt    5    9.909 ±   5.341  ns/op
FFIBenchmark.measureFFMReturnDoubleD                       avgt    5    9.654 ±   4.726  ns/op
FFIBenchmark.measureFFMReturnInt                           avgt    5   10.528 ±   7.152  ns/op
FFIBenchmark.measureFFMReturnIntI                          avgt    5   10.143 ±   3.922  ns/op
FFIBenchmark.measureFFMReturnVoid                          avgt    5    9.925 ±   4.447  ns/op
FFIBenchmark.measureJFFIReturnDouble                       avgt    5   11.088 ±   2.427  ns/op
FFIBenchmark.measureJFFIReturnDoubleD                      avgt    5   11.163 ±   4.180  ns/op
FFIBenchmark.measureJFFIReturnInt                          avgt    5   11.051 ±   5.376  ns/op
FFIBenchmark.measureJFFIReturnIntI                         avgt    5   10.736 ±   3.835  ns/op
FFIBenchmark.measureJFFIReturnVoid                         avgt    5   10.802 ±   3.972  ns/op
FFIBenchmark.measureJNADirectReturnDouble                  avgt    5   84.891 ±  55.869  ns/op
FFIBenchmark.measureJNADirectReturnDoubleD                 avgt    5  107.322 ±  37.283  ns/op
FFIBenchmark.measureJNADirectReturnInt                     avgt    5   78.389 ±  37.819  ns/op
FFIBenchmark.measureJNADirectReturnIntI                    avgt    5  106.022 ±  49.758  ns/op
FFIBenchmark.measureJNADirectReturnVoid                    avgt    5   80.741 ±  44.313  ns/op
FFIBenchmark.measureJNAReturnDouble                        avgt    5   92.971 ±  37.531  ns/op
FFIBenchmark.measureJNAReturnDoubleD                       avgt    5  347.726 ± 372.161  ns/op
FFIBenchmark.measureJNAReturnInt                           avgt    5   96.692 ±  67.942  ns/op
FFIBenchmark.measureJNAReturnIntI                          avgt    5  262.270 ± 126.216  ns/op
FFIBenchmark.measureJNAReturnVoid                          avgt    5   96.983 ±  49.700  ns/op
FFIBenchmark.measureJNIReturnDouble                        avgt    5   10.437 ±   3.827  ns/op
FFIBenchmark.measureJNIReturnDoubleD                       avgt    5   10.734 ±   6.816  ns/op
FFIBenchmark.measureJNIReturnInt                           avgt    5   10.076 ±   4.791  ns/op
FFIBenchmark.measureJNIReturnIntI                          avgt    5   11.286 ±   7.431  ns/op
FFIBenchmark.measureJNIReturnVoid                          avgt    5   10.273 ±   5.157  ns/op
FFIBenchmark.measureJNRReturnDouble                        avgt    5   10.769 ±   3.098  ns/op
FFIBenchmark.measureJNRReturnDoubleD                       avgt    5   11.809 ±   5.242  ns/op
FFIBenchmark.measureJNRReturnInt                           avgt    5   10.505 ±   1.893  ns/op
FFIBenchmark.measureJNRReturnIntI                          avgt    5   10.995 ±   5.997  ns/op
FFIBenchmark.measureJNRReturnVoid                          avgt    5   11.254 ±   4.898  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDouble   avgt    5    3.488 ±   2.268  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDoubleD  avgt    5    4.113 ±   3.199  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnInt      avgt    5    3.378 ±   2.383  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnIntI     avgt    5    3.852 ±   1.547  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnVoid     avgt    5    3.921 ±   2.163  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDouble        avgt    5   10.910 ±   7.116  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDoubleD       avgt    5   13.715 ±  14.789  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnInt           avgt    5    9.183 ±   4.582  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnIntI          avgt    5   10.954 ±  12.795  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnVoid          avgt    5   14.039 ±   7.318  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDouble           avgt    5    9.629 ±   3.406  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDoubleD          avgt    5    9.442 ±   4.271  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnInt              avgt    5   10.136 ±   2.752  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnIntI             avgt    5   11.800 ±   2.986  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnVoid             avgt    5    9.595 ±   3.473  ns/op
FFIBenchmark.measureMultiffiFFMReturnDouble                avgt    5   16.025 ±   6.788  ns/op
FFIBenchmark.measureMultiffiFFMReturnDoubleD               avgt    5   18.300 ±   7.764  ns/op
FFIBenchmark.measureMultiffiFFMReturnInt                   avgt    5   15.601 ±  10.439  ns/op
FFIBenchmark.measureMultiffiFFMReturnIntI                  avgt    5   14.878 ±  10.161  ns/op
FFIBenchmark.measureMultiffiFFMReturnVoid                  avgt    5   14.357 ±   3.633  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDouble      avgt    5   97.172 ±  55.662  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDoubleD     avgt    5  358.443 ± 205.594  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnInt         avgt    5   96.205 ±  63.602  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnIntI        avgt    5  282.072 ± 204.915  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnVoid        avgt    5   78.910 ±  41.103  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDouble           avgt    5   79.186 ±  33.923  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDoubleD          avgt    5  105.324 ±  47.596  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnInt              avgt    5   83.672 ±  58.382  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnIntI             avgt    5  106.174 ±  91.204  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnVoid             avgt    5   79.585 ±  31.512  ns/op
FFIBenchmark.measureMultiffiJNAReturnDouble                avgt    5   88.017 ±  56.688  ns/op
FFIBenchmark.measureMultiffiJNAReturnDoubleD               avgt    5  304.737 ± 138.740  ns/op
FFIBenchmark.measureMultiffiJNAReturnInt                   avgt    5   76.119 ±  33.180  ns/op
FFIBenchmark.measureMultiffiJNAReturnIntI                  avgt    5  234.871 ± 141.360  ns/op
FFIBenchmark.measureMultiffiJNAReturnVoid                  avgt    5   72.926 ±  38.152  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDouble      avgt    5   45.449 ±  20.318  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDoubleD     avgt    5   79.491 ±  55.846  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnInt         avgt    5   27.725 ±   8.274  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnIntI        avgt    5   49.187 ±  41.879  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnVoid        avgt    5   24.496 ±  15.223  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDouble           avgt    5   10.520 ±   3.762  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDoubleD          avgt    5   11.245 ±   6.240  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnInt              avgt    5   10.814 ±   3.053  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnIntI             avgt    5   11.256 ±   5.799  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnVoid             avgt    5   11.358 ±   5.250  ns/op
FFIBenchmark.measureMultiffiJNRReturnDouble                avgt    5   39.349 ±  24.939  ns/op
FFIBenchmark.measureMultiffiJNRReturnDoubleD               avgt    5   60.974 ±  47.156  ns/op
FFIBenchmark.measureMultiffiJNRReturnInt                   avgt    5   20.670 ±  11.473  ns/op
FFIBenchmark.measureMultiffiJNRReturnIntI                  avgt    5   38.172 ±  27.314  ns/op
FFIBenchmark.measureMultiffiJNRReturnVoid                  avgt    5   26.940 ±  15.717  ns/op
```
