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
Benchmark                                                  Mode  Cnt    Score      Error  Units
FFIBenchmark.measureFFMCriticalReturnDouble                avgt    5    3.698 ±    1.777  ns/op
FFIBenchmark.measureFFMCriticalReturnDoubleD               avgt    5    4.010 ±    1.495  ns/op
FFIBenchmark.measureFFMCriticalReturnInt                   avgt    5    3.473 ±    2.092  ns/op
FFIBenchmark.measureFFMCriticalReturnIntI                  avgt    5    4.207 ±    2.088  ns/op
FFIBenchmark.measureFFMCriticalReturnVoid                  avgt    5    4.052 ±    2.431  ns/op
FFIBenchmark.measureFFMReturnDouble                        avgt    5   10.571 ±    4.377  ns/op
FFIBenchmark.measureFFMReturnDoubleD                       avgt    5    9.997 ±    4.692  ns/op
FFIBenchmark.measureFFMReturnInt                           avgt    5   10.365 ±    4.477  ns/op
FFIBenchmark.measureFFMReturnIntI                          avgt    5   10.361 ±    3.043  ns/op
FFIBenchmark.measureFFMReturnVoid                          avgt    5    9.820 ±    3.993  ns/op
FFIBenchmark.measureJFFIReturnDouble                       avgt    5   24.278 ±    9.468  ns/op
FFIBenchmark.measureJFFIReturnDoubleD                      avgt    5   45.663 ±   33.037  ns/op
FFIBenchmark.measureJFFIReturnInt                          avgt    5   12.511 ±    4.997  ns/op
FFIBenchmark.measureJFFIReturnIntI                         avgt    5   12.232 ±    4.789  ns/op
FFIBenchmark.measureJFFIReturnVoid                         avgt    5   13.053 ±    6.505  ns/op
FFIBenchmark.measureJNADirectReturnDouble                  avgt    5   90.230 ±   51.882  ns/op
FFIBenchmark.measureJNADirectReturnDoubleD                 avgt    5  115.256 ±   43.554  ns/op
FFIBenchmark.measureJNADirectReturnInt                     avgt    5   89.151 ±   49.316  ns/op
FFIBenchmark.measureJNADirectReturnIntI                    avgt    5  114.771 ±   70.901  ns/op
FFIBenchmark.measureJNADirectReturnVoid                    avgt    5   85.846 ±   36.829  ns/op
FFIBenchmark.measureJNAReturnDouble                        avgt    5  103.112 ±   75.822  ns/op
FFIBenchmark.measureJNAReturnDoubleD                       avgt    5  368.910 ±  224.996  ns/op
FFIBenchmark.measureJNAReturnInt                           avgt    5   95.027 ±   35.715  ns/op
FFIBenchmark.measureJNAReturnIntI                          avgt    5  307.560 ±  158.443  ns/op
FFIBenchmark.measureJNAReturnVoid                          avgt    5   96.656 ±   73.822  ns/op
FFIBenchmark.measureJNIReturnDouble                        avgt    5   10.952 ±    5.665  ns/op
FFIBenchmark.measureJNIReturnDoubleD                       avgt    5   10.328 ±    7.179  ns/op
FFIBenchmark.measureJNIReturnInt                           avgt    5   10.284 ±    4.058  ns/op
FFIBenchmark.measureJNIReturnIntI                          avgt    5   11.049 ±    3.532  ns/op
FFIBenchmark.measureJNIReturnVoid                          avgt    5   11.285 ±    4.314  ns/op
FFIBenchmark.measureJNRReturnDouble                        avgt    5   11.139 ±    3.078  ns/op
FFIBenchmark.measureJNRReturnDoubleD                       avgt    5   11.550 ±    3.799  ns/op
FFIBenchmark.measureJNRReturnInt                           avgt    5   11.811 ±    7.149  ns/op
FFIBenchmark.measureJNRReturnIntI                          avgt    5   12.157 ±    6.474  ns/op
FFIBenchmark.measureJNRReturnVoid                          avgt    5   11.547 ±    5.864  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDouble   avgt    5    3.631 ±    2.117  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnDoubleD  avgt    5    4.018 ±    2.280  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnInt      avgt    5    4.416 ±    5.061  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnIntI     avgt    5    6.338 ±   10.774  ns/op
FFIBenchmark.measureMultiffiFFMCriticalProxyReturnVoid     avgt    5    4.911 ±    5.195  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDouble        avgt    5   11.650 ±    5.709  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnDoubleD       avgt    5   15.232 ±    9.681  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnInt           avgt    5    9.020 ±    2.956  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnIntI          avgt    5   12.902 ±   11.701  ns/op
FFIBenchmark.measureMultiffiFFMCriticalReturnVoid          avgt    5   23.977 ±   65.312  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDouble           avgt    5   18.611 ±   36.007  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnDoubleD          avgt    5   13.623 ±   11.092  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnInt              avgt    5   13.458 ±   19.218  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnIntI             avgt    5   15.950 ±    9.043  ns/op
FFIBenchmark.measureMultiffiFFMProxyReturnVoid             avgt    5   17.569 ±   21.347  ns/op
FFIBenchmark.measureMultiffiFFMReturnDouble                avgt    5   33.607 ±   63.264  ns/op
FFIBenchmark.measureMultiffiFFMReturnDoubleD               avgt    5   28.632 ±   34.250  ns/op
FFIBenchmark.measureMultiffiFFMReturnInt                   avgt    5   26.712 ±   68.664  ns/op
FFIBenchmark.measureMultiffiFFMReturnIntI                  avgt    5   15.427 ±    6.334  ns/op
FFIBenchmark.measureMultiffiFFMReturnVoid                  avgt    5   15.341 ±    6.161  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDouble      avgt    5  101.621 ±   86.757  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnDoubleD     avgt    5  637.215 ± 1281.218  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnInt         avgt    5   89.604 ±   47.585  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnIntI        avgt    5  274.201 ±  135.074  ns/op
FFIBenchmark.measureMultiffiJNANoASMProxyReturnVoid        avgt    5   87.726 ±   54.385  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDouble           avgt    5   90.883 ±   75.546  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnDoubleD          avgt    5  122.285 ±   90.293  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnInt              avgt    5   96.114 ±   58.556  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnIntI             avgt    5  141.906 ±  292.538  ns/op
FFIBenchmark.measureMultiffiJNAProxyReturnVoid             avgt    5   83.568 ±   38.403  ns/op
FFIBenchmark.measureMultiffiJNAReturnDouble                avgt    5   85.456 ±   47.215  ns/op
FFIBenchmark.measureMultiffiJNAReturnDoubleD               avgt    5  339.145 ±  266.414  ns/op
FFIBenchmark.measureMultiffiJNAReturnInt                   avgt    5   81.361 ±   44.132  ns/op
FFIBenchmark.measureMultiffiJNAReturnIntI                  avgt    5  243.699 ±   89.513  ns/op
FFIBenchmark.measureMultiffiJNAReturnVoid                  avgt    5   86.897 ±   88.629  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDouble      avgt    5   49.958 ±   44.527  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnDoubleD     avgt    5   91.264 ±   70.423  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnInt         avgt    5   25.276 ±   10.990  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnIntI        avgt    5   55.781 ±   31.746  ns/op
FFIBenchmark.measureMultiffiJNRNoASMProxyReturnVoid        avgt    5   26.895 ±   12.975  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDouble           avgt    5   11.525 ±    4.358  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnDoubleD          avgt    5   11.640 ±    5.376  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnInt              avgt    5   11.387 ±    2.687  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnIntI             avgt    5   10.844 ±    4.363  ns/op
FFIBenchmark.measureMultiffiJNRProxyReturnVoid             avgt    5   10.876 ±    0.869  ns/op
FFIBenchmark.measureMultiffiJNRReturnDouble                avgt    5   29.295 ±   22.664  ns/op
FFIBenchmark.measureMultiffiJNRReturnDoubleD               avgt    5   43.720 ±   17.175  ns/op
FFIBenchmark.measureMultiffiJNRReturnInt                   avgt    5   13.322 ±    8.599  ns/op
FFIBenchmark.measureMultiffiJNRReturnIntI                  avgt    5   13.463 ±    3.482  ns/op
FFIBenchmark.measureMultiffiJNRReturnVoid                  avgt    5   12.917 ±    6.465  ns/op
```
