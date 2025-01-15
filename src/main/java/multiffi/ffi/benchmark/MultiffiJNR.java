package multiffi.ffi.benchmark;

import multiffi.ffi.ForeignType;
import multiffi.ffi.FunctionHandle;
import multiffi.ffi.ScalarType;

public final class MultiffiJNR {

    private MultiffiJNR() {
        throw new AssertionError("No multiffi.ffi.benchmark.MultiffiJNR instances for you!");
    }

    public static final FunctionHandle hReturnVoid, hReturnInt, hReturnIntI, hReturnDouble, hReturnDoubleD;
    static {
        hReturnVoid = Multiffi.JNR.downcallHandle(Multiffi.JNR.getSymbolAddress("return_void"), ForeignType.VOID);
        hReturnInt = Multiffi.JNR.downcallHandle(Multiffi.JNR.getSymbolAddress("return_int"), ScalarType.INT32);
        hReturnIntI = Multiffi.JNR.downcallHandle(Multiffi.JNR.getSymbolAddress("return_int_i"), ScalarType.INT32, ScalarType.INT32);
        hReturnDouble = Multiffi.JNR.downcallHandle(Multiffi.JNR.getSymbolAddress("return_double"), ScalarType.DOUBLE);
        hReturnDoubleD = Multiffi.JNR.downcallHandle(Multiffi.JNR.getSymbolAddress("return_double_d"), ScalarType.DOUBLE, ScalarType.DOUBLE);
    }

}
