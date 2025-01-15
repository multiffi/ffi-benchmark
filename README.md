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

### Example (UNIX Shell, CMake with Makefile Backend)
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
Benchmark                                                       Mode  Cnt    Score     Error  Units
FFIBenchmark.measureFFMCriticalReturnDouble                     avgt    5    4.058 ±   2.414  ns/op
FFIBenchmark.measureFFMCriticalReturnDoubleD                    avgt    5    3.949 ±   2.005  ns/op
FFIBenchmark.measureFFMCriticalReturnInt                        avgt    5    3.397 ±   0.404  ns/op
FFIBenchmark.measureFFMCriticalReturnIntI                       avgt    5    4.780 ±   1.137  ns/op
FFIBenchmark.measureFFMCriticalReturnVoid                       avgt    5    4.046 ±   1.559  ns/op
FFIBenchmark.measureFFMReturnDouble                             avgt    5    9.851 ±   1.448  ns/op
FFIBenchmark.measureFFMReturnDoubleD                            avgt    5   10.497 ±   4.140  ns/op
FFIBenchmark.measureFFMReturnInt                                avgt    5   10.508 ±   3.986  ns/op
FFIBenchmark.measureFFMReturnIntI                               avgt    5   10.109 ±   3.326  ns/op
FFIBenchmark.measureFFMReturnVoid                               avgt    5   10.115 ±   2.691  ns/op
FFIBenchmark.measureJFFIReturnDouble                            avgt    5   25.783 ±  10.427  ns/op
FFIBenchmark.measureJFFIReturnDoubleD                           avgt    5   42.788 ±  26.839  ns/op
FFIBenchmark.measureJFFIReturnInt                               avgt    5   16.969 ±   6.320  ns/op
FFIBenchmark.measureJFFIReturnIntI                              avgt    5   13.051 ±   4.801  ns/op
FFIBenchmark.measureJFFIReturnVoid                              avgt    5   12.537 ±   6.172  ns/op
FFIBenchmark.measureJNADirectReturnDouble                       avgt    5   84.617 ±  40.007  ns/op
FFIBenchmark.measureJNADirectReturnDoubleD                      avgt    5  118.879 ±  48.781  ns/op
FFIBenchmark.measureJNADirectReturnInt                          avgt    5   81.427 ±  29.725  ns/op
FFIBenchmark.measureJNADirectReturnIntI                         avgt    5  112.679 ±  50.660  ns/op
FFIBenchmark.measureJNADirectReturnVoid                         avgt    5   82.583 ±  25.461  ns/op
FFIBenchmark.measureJNAFunctionReturnDouble                     avgt    5   95.825 ±  25.672  ns/op
FFIBenchmark.measureJNAFunctionReturnDoubleD                    avgt    5  327.051 ±  99.819  ns/op
FFIBenchmark.measureJNAFunctionReturnInt                        avgt    5   87.717 ±  20.347  ns/op
FFIBenchmark.measureJNAFunctionReturnIntI                       avgt    5  301.176 ± 235.789  ns/op
FFIBenchmark.measureJNAFunctionReturnVoid                       avgt    5   83.616 ±  48.877  ns/op
FFIBenchmark.measureJNAReturnDouble                             avgt    5   92.918 ±  16.331  ns/op
FFIBenchmark.measureJNAReturnDoubleD                            avgt    5  340.771 ± 121.882  ns/op
FFIBenchmark.measureJNAReturnInt                                avgt    5   89.276 ±  14.013  ns/op
FFIBenchmark.measureJNAReturnIntI                               avgt    5  280.775 ±  89.978  ns/op
FFIBenchmark.measureJNAReturnVoid                               avgt    5   94.303 ±  49.539  ns/op
FFIBenchmark.measureJNIReturnDouble                             avgt    5   10.299 ±   3.338  ns/op
FFIBenchmark.measureJNIReturnDoubleD                            avgt    5   11.068 ±   4.030  ns/op
FFIBenchmark.measureJNIReturnInt                                avgt    5   10.913 ±   4.845  ns/op
FFIBenchmark.measureJNIReturnIntI                               avgt    5   10.382 ±   1.513  ns/op
FFIBenchmark.measureJNIReturnVoid                               avgt    5   11.140 ±   0.822  ns/op
FFIBenchmark.measureJNRReturnDouble                             avgt    5   11.296 ±   2.534  ns/op
FFIBenchmark.measureJNRReturnDoubleD                            avgt    5   10.811 ±   0.141  ns/op
FFIBenchmark.measureJNRReturnInt                                avgt    5   11.377 ±   0.880  ns/op
FFIBenchmark.measureJNRReturnIntI                               avgt    5   10.870 ±   3.879  ns/op
FFIBenchmark.measureJNRReturnVoid                               avgt    5   11.517 ±   3.236  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDouble        avgt    5    3.426 ±   0.094  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDoubleD       avgt    5    3.893 ±   0.916  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnInt           avgt    5    4.315 ±   1.705  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnIntI          avgt    5    3.830 ±   1.566  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnVoid          avgt    5    4.455 ±   0.519  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDouble             avgt    5   10.413 ±   4.372  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDoubleD            avgt    5   13.968 ±   7.746  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnInt                avgt    5    8.441 ±   2.465  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnIntI               avgt    5    9.820 ±   2.764  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnVoid               avgt    5   13.526 ±   1.178  ns/op
FFIBenchmark.measureMultiffiFFMNoASMCriticalProxyReturnDouble   avgt    5   27.018 ±  18.919  ns/op
FFIBenchmark.measureMultiffiFFMNoASMCriticalProxyReturnDoubleD  avgt    5   25.307 ±  10.433  ns/op
FFIBenchmark.measureMultiffiFFMNoASMCriticalProxyReturnInt      avgt    5   21.413 ±   4.620  ns/op
FFIBenchmark.measureMultiffiFFMNoASMCriticalProxyReturnIntI     avgt    5   21.266 ±   5.037  ns/op
FFIBenchmark.measureMultiffiFFMNoASMCriticalProxyReturnVoid     avgt    5   19.311 ±   4.831  ns/op
FFIBenchmark.measureMultiffiFFMNoASMProxyReturnDouble           avgt    5   29.266 ±  12.810  ns/op
FFIBenchmark.measureMultiffiFFMNoASMProxyReturnDoubleD          avgt    5   28.860 ±  20.658  ns/op
FFIBenchmark.measureMultiffiFFMNoASMProxyReturnInt              avgt    5   25.755 ±   8.979  ns/op
FFIBenchmark.measureMultiffiFFMNoASMProxyReturnIntI             avgt    5   26.606 ±  27.694  ns/op
FFIBenchmark.measureMultiffiFFMNoASMProxyReturnVoid             avgt    5   22.656 ±   1.186  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDouble                avgt    5   10.139 ±   1.955  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDoubleD               avgt    5    9.850 ±   3.515  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnInt                   avgt    5   10.232 ±   3.123  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnIntI                  avgt    5   10.224 ±   2.224  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnVoid                  avgt    5   10.381 ±   3.854  ns/op
FFIBenchmark.measureMultiffiFFMReturnDouble                     avgt    5   17.022 ±  10.414  ns/op
FFIBenchmark.measureMultiffiFFMReturnDoubleD                    avgt    5   18.558 ±   9.138  ns/op
FFIBenchmark.measureMultiffiFFMReturnInt                        avgt    5   14.001 ±   0.953  ns/op
FFIBenchmark.measureMultiffiFFMReturnIntI                       avgt    5   13.513 ±   2.069  ns/op
FFIBenchmark.measureMultiffiFFMReturnVoid                       avgt    5   13.814 ±   1.663  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDouble           avgt    5   94.811 ±  34.129  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDoubleD          avgt    5  307.513 ±  90.866  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnInt              avgt    5  108.790 ± 113.743  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnIntI             avgt    5  263.573 ± 159.647  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnVoid             avgt    5   79.740 ±  32.316  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDouble                avgt    5   79.498 ±  19.920  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDoubleD               avgt    5  101.866 ±  17.229  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnInt                   avgt    5   80.021 ±  11.016  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnIntI                  avgt    5  109.996 ±  44.774  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnVoid                  avgt    5   79.644 ±  37.459  ns/op
FFIBenchmark.measureMultiffiJNAReturnDouble                     avgt    5   81.128 ±  42.009  ns/op
FFIBenchmark.measureMultiffiJNAReturnDoubleD                    avgt    5  322.130 ±  80.107  ns/op
FFIBenchmark.measureMultiffiJNAReturnInt                        avgt    5   76.746 ±  20.926  ns/op
FFIBenchmark.measureMultiffiJNAReturnIntI                       avgt    5  232.780 ±  72.890  ns/op
FFIBenchmark.measureMultiffiJNAReturnVoid                       avgt    5   74.763 ±  38.100  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDouble           avgt    5   44.188 ±  12.311  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDoubleD          avgt    5   54.760 ±   0.330  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnInt              avgt    5   21.285 ±   4.210  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnIntI             avgt    5   20.940 ±   6.095  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnVoid             avgt    5   21.373 ±   9.872  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDouble                avgt    5   11.623 ±   2.748  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDoubleD               avgt    5   11.251 ±   4.304  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnInt                   avgt    5   11.035 ±   3.389  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnIntI                  avgt    5   11.267 ±   1.765  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnVoid                  avgt    5   10.803 ±   1.726  ns/op
FFIBenchmark.measureMultiffiJNRReturnDouble                     avgt    5   28.405 ±  17.824  ns/op
FFIBenchmark.measureMultiffiJNRReturnDoubleD                    avgt    5   42.931 ±  19.714  ns/op
FFIBenchmark.measureMultiffiJNRReturnInt                        avgt    5   13.364 ±   5.143  ns/op
FFIBenchmark.measureMultiffiJNRReturnIntI                       avgt    5   13.799 ±   0.514  ns/op
FFIBenchmark.measureMultiffiJNRReturnVoid                       avgt    5   12.312 ±   2.347  ns/op
```
