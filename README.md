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
FFIBenchmark.measureFFMCriticalReturnDouble                avgt    5    4.194 ±   5.300  ns/op
FFIBenchmark.measureFFMCriticalReturnDoubleD               avgt    5    4.012 ±   1.472  ns/op
FFIBenchmark.measureFFMCriticalReturnInt                   avgt    5    3.451 ±   2.118  ns/op
FFIBenchmark.measureFFMCriticalReturnIntI                  avgt    5    4.161 ±   3.261  ns/op
FFIBenchmark.measureFFMCriticalReturnVoid                  avgt    5    4.142 ±   2.442  ns/op
FFIBenchmark.measureFFMReturnDouble                        avgt    5    9.895 ±   3.708  ns/op
FFIBenchmark.measureFFMReturnDoubleD                       avgt    5   10.758 ±   4.867  ns/op
FFIBenchmark.measureFFMReturnInt                           avgt    5   10.593 ±   2.854  ns/op
FFIBenchmark.measureFFMReturnIntI                          avgt    5    9.901 ±   3.693  ns/op
FFIBenchmark.measureFFMReturnVoid                          avgt    5    9.908 ±   4.729  ns/op
FFIBenchmark.measureJFFIReturnDouble                       avgt    5   24.674 ±  12.044  ns/op
FFIBenchmark.measureJFFIReturnDoubleD                      avgt    5   42.278 ±  31.962  ns/op
FFIBenchmark.measureJFFIReturnInt                          avgt    5   12.857 ±   4.925  ns/op
FFIBenchmark.measureJFFIReturnIntI                         avgt    5   13.017 ±   5.100  ns/op
FFIBenchmark.measureJFFIReturnVoid                         avgt    5   12.865 ±   5.120  ns/op
FFIBenchmark.measureJNADirectReturnDouble                  avgt    5   86.693 ±  48.477  ns/op
FFIBenchmark.measureJNADirectReturnDoubleD                 avgt    5  112.694 ±  41.022  ns/op
FFIBenchmark.measureJNADirectReturnInt                     avgt    5   82.319 ±  36.637  ns/op
FFIBenchmark.measureJNADirectReturnIntI                    avgt    5  107.550 ±  64.214  ns/op
FFIBenchmark.measureJNADirectReturnVoid                    avgt    5   88.388 ±  41.813  ns/op
FFIBenchmark.measureJNAReturnDouble                        avgt    5  100.716 ±  58.079  ns/op
FFIBenchmark.measureJNAReturnDoubleD                       avgt    5  336.410 ± 246.009  ns/op
FFIBenchmark.measureJNAReturnInt                           avgt    5  100.289 ±  32.735  ns/op
FFIBenchmark.measureJNAReturnIntI                          avgt    5  284.400 ± 125.287  ns/op
FFIBenchmark.measureJNAReturnVoid                          avgt    5   90.989 ±  30.362  ns/op
FFIBenchmark.measureJNIReturnDouble                        avgt    5   10.550 ±   5.542  ns/op
FFIBenchmark.measureJNIReturnDoubleD                       avgt    5   10.235 ±   5.418  ns/op
FFIBenchmark.measureJNIReturnInt                           avgt    5   10.466 ±   2.353  ns/op
FFIBenchmark.measureJNIReturnIntI                          avgt    5   10.515 ±   4.926  ns/op
FFIBenchmark.measureJNIReturnVoid                          avgt    5   10.712 ±   5.547  ns/op
FFIBenchmark.measureJNRReturnDouble                        avgt    5   11.334 ±   2.811  ns/op
FFIBenchmark.measureJNRReturnDoubleD                       avgt    5   10.772 ±   3.878  ns/op
FFIBenchmark.measureJNRReturnInt                           avgt    5   10.894 ±   4.452  ns/op
FFIBenchmark.measureJNRReturnIntI                          avgt    5   11.371 ±   3.534  ns/op
FFIBenchmark.measureJNRReturnVoid                          avgt    5   11.372 ±   3.911  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDouble   avgt    5    3.789 ±   1.959  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDoubleD  avgt    5    3.965 ±   2.024  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnInt      avgt    5    3.567 ±   1.961  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnIntI     avgt    5    3.789 ±   2.077  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnVoid     avgt    5    3.820 ±   0.849  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDouble        avgt    5   12.155 ±  12.412  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDoubleD       avgt    5   14.578 ±   8.389  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnInt           avgt    5    9.433 ±   4.139  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnIntI          avgt    5   10.839 ±   5.821  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnVoid          avgt    5   14.600 ±   7.638  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDouble           avgt    5   10.409 ±   5.587  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDoubleD          avgt    5    9.611 ±   2.304  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnInt              avgt    5    9.703 ±   3.488  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnIntI             avgt    5   12.952 ±   5.469  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnVoid             avgt    5   10.175 ±   5.208  ns/op
FFIBenchmark.measureMultiffiFFMReturnDouble                avgt    5   16.730 ±   7.672  ns/op
FFIBenchmark.measureMultiffiFFMReturnDoubleD               avgt    5   18.294 ±   6.760  ns/op
FFIBenchmark.measureMultiffiFFMReturnInt                   avgt    5   14.094 ±   5.861  ns/op
FFIBenchmark.measureMultiffiFFMReturnIntI                  avgt    5   15.242 ±   8.650  ns/op
FFIBenchmark.measureMultiffiFFMReturnVoid                  avgt    5   14.006 ±   5.996  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDouble      avgt    5   95.944 ±  70.058  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDoubleD     avgt    5  343.547 ± 261.444  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnInt         avgt    5   82.089 ±  37.464  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnIntI        avgt    5  259.277 ± 152.047  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnVoid        avgt    5   81.552 ±  35.034  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDouble           avgt    5   77.852 ±  35.094  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDoubleD          avgt    5  109.233 ±  68.433  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnInt              avgt    5   80.248 ±  31.446  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnIntI             avgt    5  105.182 ±  44.533  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnVoid             avgt    5   87.607 ±  66.138  ns/op
FFIBenchmark.measureMultiffiJNAReturnDouble                avgt    5   76.634 ±  49.938  ns/op
FFIBenchmark.measureMultiffiJNAReturnDoubleD               avgt    5  302.456 ± 136.001  ns/op
FFIBenchmark.measureMultiffiJNAReturnInt                   avgt    5   75.469 ±  52.398  ns/op
FFIBenchmark.measureMultiffiJNAReturnIntI                  avgt    5  242.772 ± 172.470  ns/op
FFIBenchmark.measureMultiffiJNAReturnVoid                  avgt    5   73.695 ±  35.541  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDouble      avgt    5   44.013 ±  20.332  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDoubleD     avgt    5   81.801 ±  50.209  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnInt         avgt    5   24.891 ±   9.386  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnIntI        avgt    5   50.352 ±  42.205  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnVoid        avgt    5   24.866 ±  10.057  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDouble           avgt    5   11.387 ±   5.635  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDoubleD          avgt    5   11.679 ±   7.289  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnInt              avgt    5   11.323 ±   7.082  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnIntI             avgt    5   10.858 ±   4.306  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnVoid             avgt    5   11.022 ±   3.553  ns/op
FFIBenchmark.measureMultiffiJNRReturnDouble                avgt    5   27.093 ±  18.061  ns/op
FFIBenchmark.measureMultiffiJNRReturnDoubleD               avgt    5   42.993 ±  29.516  ns/op
FFIBenchmark.measureMultiffiJNRReturnInt                   avgt    5   12.751 ±   5.317  ns/op
FFIBenchmark.measureMultiffiJNRReturnIntI                  avgt    5   13.555 ±   7.328  ns/op
FFIBenchmark.measureMultiffiJNRReturnVoid                  avgt    5   19.049 ±   7.520  ns/op
```
