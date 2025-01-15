package multiffi.ffi.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class FFIBenchmark {

    @Benchmark
    public void measureJNIReturnVoid(Blackhole blackhole) {
        JNI.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJNIReturnInt(Blackhole blackhole) {
        blackhole.consume(JNI.return_int());
    }

    @Benchmark
    public void measureJNIReturnIntI(Blackhole blackhole) {
        blackhole.consume(JNI.return_int_i(0));
    }

    @Benchmark
    public void measureJNIReturnDouble(Blackhole blackhole) {
        blackhole.consume(JNI.return_double());
    }

    @Benchmark
    public void measureJNIReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JNI.return_double_d(0));
    }

    @Benchmark
    public void measureFFMReturnVoid(Blackhole blackhole) throws Throwable {
        FFM.hReturnVoid.invokeExact();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureFFMReturnInt(Blackhole blackhole) throws Throwable {
        blackhole.consume((int) FFM.hReturnInt.invokeExact());
    }

    @Benchmark
    public void measureFFMReturnIntI(Blackhole blackhole) throws Throwable {
        blackhole.consume((int) FFM.hReturnIntI.invokeExact(0));
    }

    @Benchmark
    public void measureFFMReturnDouble(Blackhole blackhole) throws Throwable {
        blackhole.consume((double) FFM.hReturnDouble.invokeExact());
    }

    @Benchmark
    public void measureFFMReturnDoubleD(Blackhole blackhole) throws Throwable {
        blackhole.consume((double) FFM.hReturnDoubleD.invokeExact(0.0));
    }

    @Benchmark
    public void measureFFMCriticalReturnVoid(Blackhole blackhole) throws Throwable {
        FFMCritical.hReturnVoid.invokeExact();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureFFMCriticalReturnInt(Blackhole blackhole) throws Throwable {
        blackhole.consume((int) FFMCritical.hReturnInt.invokeExact());
    }

    @Benchmark
    public void measureFFMCriticalReturnIntI(Blackhole blackhole) throws Throwable {
        blackhole.consume((int) FFMCritical.hReturnIntI.invokeExact(0));
    }

    @Benchmark
    public void measureFFMCriticalReturnDouble(Blackhole blackhole) throws Throwable {
        blackhole.consume((double) FFMCritical.hReturnDouble.invokeExact());
    }

    @Benchmark
    public void measureFFMCriticalReturnDoubleD(Blackhole blackhole) throws Throwable {
        blackhole.consume((double) FFMCritical.hReturnDoubleD.invokeExact(0.0));
    }

    @Benchmark
    public void measureJNAReturnVoid(Blackhole blackhole) {
        JNALibrary.INSTANCE.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJNAReturnInt(Blackhole blackhole) {
        blackhole.consume(JNALibrary.INSTANCE.return_int());
    }

    @Benchmark
    public void measureJNAReturnIntI(Blackhole blackhole) {
        blackhole.consume(JNALibrary.INSTANCE.return_int_i(0));
    }

    @Benchmark
    public void measureJNAReturnDouble(Blackhole blackhole) {
        blackhole.consume(JNALibrary.INSTANCE.return_double());
    }

    @Benchmark
    public void measureJNAReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JNALibrary.INSTANCE.return_double_d(0));
    }

    @Benchmark
    public void measureJNAFunctionReturnVoid(Blackhole blackhole) {
        JNAFunction.returnVoidFunction.invokeVoid(new Object[0]);
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJNAFunctionReturnInt(Blackhole blackhole) {
        blackhole.consume(JNAFunction.returnIntFunction.invokeInt(new Object[0]));
    }

    @Benchmark
    public void measureJNAFunctionReturnIntI(Blackhole blackhole) {
        blackhole.consume(JNAFunction.returnIntIFunction.invokeInt(new Object[] { 0 }));
    }

    @Benchmark
    public void measureJNAFunctionReturnDouble(Blackhole blackhole) {
        blackhole.consume(JNAFunction.returnDoubleDFunction.invokeDouble(new Object[0]));
    }

    @Benchmark
    public void measureJNAFunctionReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JNAFunction.returnDoubleDFunction.invokeDouble(new Object[] { 0.0 }));
    }

    @Benchmark
    public void measureJNADirectReturnVoid(Blackhole blackhole) {
        JNADirect.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJNADirectReturnInt(Blackhole blackhole) {
        blackhole.consume(JNADirect.return_int());
    }

    @Benchmark
    public void measureJNADirectReturnIntI(Blackhole blackhole) {
        blackhole.consume(JNADirect.return_int_i(0));
    }

    @Benchmark
    public void measureJNADirectReturnDouble(Blackhole blackhole) {
        blackhole.consume(JNADirect.return_double());
    }

    @Benchmark
    public void measureJNADirectReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JNADirect.return_double_d(0));
    }

    @Benchmark
    public void measureJNRReturnVoid(Blackhole blackhole) {
        JNRLibrary.INSTANCE.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJNRReturnInt(Blackhole blackhole) {
        blackhole.consume(JNRLibrary.INSTANCE.return_int());
    }

    @Benchmark
    public void measureJNRReturnIntI(Blackhole blackhole) {
        blackhole.consume(JNRLibrary.INSTANCE.return_int_i(0));
    }

    @Benchmark
    public void measureJNRReturnDouble(Blackhole blackhole) {
        blackhole.consume(JNRLibrary.INSTANCE.return_double());
    }

    @Benchmark
    public void measureJNRReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JNRLibrary.INSTANCE.return_double_d(0));
    }

    @Benchmark
    public void measureJFFIReturnVoid(Blackhole blackhole) {
        JFFILibrary.INSTANCE.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureJFFIReturnInt(Blackhole blackhole) {
        blackhole.consume(JFFILibrary.INSTANCE.return_int());
    }

    @Benchmark
    public void measureJFFIReturnIntI(Blackhole blackhole) {
        blackhole.consume(JFFILibrary.INSTANCE.return_int_i(0));
    }

    @Benchmark
    public void measureJFFIReturnDouble(Blackhole blackhole) {
        blackhole.consume(JFFILibrary.INSTANCE.return_double());
    }

    @Benchmark
    public void measureJFFIReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(JFFILibrary.INSTANCE.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiFFMReturnVoid(Blackhole blackhole) {
        MultiffiFFM.hReturnVoid.invokeVoid();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiFFM.hReturnInt.invokeInt());
    }

    @Benchmark
    public void measureMultiffiFFMReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiFFM.hReturnIntI.invokeInt(0));
    }

    @Benchmark
    public void measureMultiffiFFMReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiFFM.hReturnDouble.invokeDouble());
    }

    @Benchmark
    public void measureMultiffiFFMReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiFFM.hReturnDoubleD.invokeDouble(0.0));
    }

    @Benchmark
    public void measureMultiffiFFMCriticalReturnVoid(Blackhole blackhole) {
        MultiffiFFM.hReturnVoid.invokeVoid();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMCriticalReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiFFMCritical.hReturnInt.invokeInt());
    }

    @Benchmark
    public void measureMultiffiFFMCriticalReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiFFMCritical.hReturnIntI.invokeInt(0));
    }

    @Benchmark
    public void measureMultiffiFFMCriticalReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiFFMCritical.hReturnDouble.invokeDouble());
    }

    @Benchmark
    public void measureMultiffiFFMCriticalReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiFFMCritical.hReturnDoubleD.invokeDouble(0.0));
    }

    @Benchmark
    public void measureMultiffiJNAReturnVoid(Blackhole blackhole) {
        MultiffiJNA.hReturnVoid.invokeVoid();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNAReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiJNA.hReturnInt.invokeInt());
    }

    @Benchmark
    public void measureMultiffiJNAReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiJNA.hReturnIntI.invokeInt(0));
    }

    @Benchmark
    public void measureMultiffiJNAReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiJNA.hReturnDouble.invokeDouble());
    }

    @Benchmark
    public void measureMultiffiJNAReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiJNA.hReturnDoubleD.invokeDouble(0.0));
    }

    @Benchmark
    public void measureMultiffiJNRReturnVoid(Blackhole blackhole) {
        MultiffiJNR.hReturnVoid.invokeVoid();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNRReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiJNR.hReturnInt.invokeInt());
    }

    @Benchmark
    public void measureMultiffiJNRReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiJNR.hReturnIntI.invokeInt(0));
    }

    @Benchmark
    public void measureMultiffiJNRReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiJNR.hReturnDouble.invokeDouble());
    }

    @Benchmark
    public void measureMultiffiJNRReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiJNR.hReturnDoubleD.invokeDouble(0.0));
    }

    @Benchmark
    public void measureMultiffiFFMProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_FFM.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM.return_int());
    }

    @Benchmark
    public void measureMultiffiFFMProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiFFMProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM.return_double());
    }

    @Benchmark
    public void measureMultiffiFFMProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiFFMCriticalProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_FFM_CRITICAL.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMCriticalProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_CRITICAL.return_int());
    }

    @Benchmark
    public void measureMultiffiFFMCriticalProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_CRITICAL.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiFFMCriticalProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_CRITICAL.return_double());
    }

    @Benchmark
    public void measureMultiffiFFMCriticalProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_CRITICAL.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiFFMNoASMProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_FFM_NOASM.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMNoASMProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM.return_int());
    }

    @Benchmark
    public void measureMultiffiFFMNoASMProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiFFMNoASMProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM.return_double());
    }

    @Benchmark
    public void measureMultiffiFFMNoASMProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiFFMNoASMCriticalProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_FFM_NOASM_CRITICAL.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiFFMNoASMCriticalProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM_CRITICAL.return_int());
    }

    @Benchmark
    public void measureMultiffiFFMNoASMCriticalProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM_CRITICAL.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiFFMNoASMCriticalProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM_CRITICAL.return_double());
    }

    @Benchmark
    public void measureMultiffiFFMNoASMCriticalProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_FFM_NOASM_CRITICAL.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiJNAProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_JNA.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNAProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA.return_int());
    }

    @Benchmark
    public void measureMultiffiJNAProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiJNAProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA.return_double());
    }

    @Benchmark
    public void measureMultiffiJNAProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiJNANoASMProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_JNA_NOASM.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNANoASMProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA_NOASM.return_int());
    }

    @Benchmark
    public void measureMultiffiJNANoASMProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA_NOASM.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiJNANoASMProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA_NOASM.return_double());
    }

    @Benchmark
    public void measureMultiffiJNANoASMProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNA_NOASM.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiJNRProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_JNR.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNRProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR.return_int());
    }

    @Benchmark
    public void measureMultiffiJNRProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiJNRProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR.return_double());
    }

    @Benchmark
    public void measureMultiffiJNRProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR.return_double_d(0));
    }

    @Benchmark
    public void measureMultiffiJNRNoASMProxyReturnVoid(Blackhole blackhole) {
        MultiffiLibrary.INSTANCE_JNR_NOASM.return_void();
        blackhole.consume(0);
    }

    @Benchmark
    public void measureMultiffiJNRNoASMProxyReturnInt(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR_NOASM.return_int());
    }

    @Benchmark
    public void measureMultiffiJNRNoASMProxyReturnIntI(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR_NOASM.return_int_i(0));
    }

    @Benchmark
    public void measureMultiffiJNRNoASMProxyReturnDouble(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR_NOASM.return_double());
    }

    @Benchmark
    public void measureMultiffiJNRNoASMProxyReturnDoubleD(Blackhole blackhole) {
        blackhole.consume(MultiffiLibrary.INSTANCE_JNR_NOASM.return_double_d(0));
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(FFIBenchmark.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

}
