package multiffi.ffi.benchmark;

import com.sun.jna.Function;
import multiffi.ffi.Foreign;

import java.io.File;

public final class JNAFunction {

    private JNAFunction() {
        throw new AssertionError("No multiffi.ffi.benchmark.JNAFunction instances for you!");
    }

    public static final Function returnVoidFunction, returnIntFunction, returnIntIFunction, returnDoubleFunction, returnDoubleDFunction;
    static {
        returnVoidFunction = Function.getFunction(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), "return_void");
        returnIntFunction = Function.getFunction(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), "return_int");
        returnIntIFunction = Function.getFunction(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), "return_int_i");
        returnDoubleFunction = Function.getFunction(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), "return_double");
        returnDoubleDFunction = Function.getFunction(new File(Foreign.mapLibraryName("benchmark")).getAbsolutePath(), "return_double_d");
    }

}
