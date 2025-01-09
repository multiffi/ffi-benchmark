package multiffi.ffi.benchmark;

import multiffi.ffi.Foreign;

import java.io.File;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public final class FFM {

    private FFM() {
        throw new AssertionError("No multiffi.ffi.benchmark.FFM instances for you!");
    }

    public static final MethodHandle hReturnVoid, hReturnInt, hReturnIntI, hReturnDouble, hReturnDoubleD;
    static {
        Linker linker = Linker.nativeLinker();
        SymbolLookup lookup = SymbolLookup.libraryLookup(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), Arena.global());
        hReturnVoid = linker.downcallHandle(lookup.find("return_void").orElseThrow(), FunctionDescriptor.ofVoid());
        hReturnInt = linker.downcallHandle(lookup.find("return_int").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT));
        hReturnIntI = linker.downcallHandle(lookup.find("return_int_i").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        hReturnDouble = linker.downcallHandle(lookup.find("return_double").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE));
        hReturnDoubleD = linker.downcallHandle(lookup.find("return_double_d").orElseThrow(), FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE, ValueLayout.JAVA_DOUBLE));
    }

}
