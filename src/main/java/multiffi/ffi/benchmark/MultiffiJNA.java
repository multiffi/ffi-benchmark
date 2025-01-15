package multiffi.ffi.benchmark;

import multiffi.ffi.ForeignType;
import multiffi.ffi.FunctionHandle;
import multiffi.ffi.ScalarType;

public final class MultiffiJNA {

    private MultiffiJNA() {
        throw new AssertionError("No multiffi.ffi.benchmark.MultiffiJNA instances for you!");
    }

    public static final FunctionHandle hReturnVoid, hReturnInt, hReturnIntI, hReturnDouble, hReturnDoubleD;
    static {
        hReturnVoid = Multiffi.JNA.downcallHandle(Multiffi.JNA.getSymbolAddress("return_void"), ForeignType.VOID);
        hReturnInt = Multiffi.JNA.downcallHandle(Multiffi.JNA.getSymbolAddress("return_int"), ScalarType.INT32);
        hReturnIntI = Multiffi.JNA.downcallHandle(Multiffi.JNA.getSymbolAddress("return_int_i"), ScalarType.INT32, ScalarType.INT32);
        hReturnDouble = Multiffi.JNA.downcallHandle(Multiffi.JNA.getSymbolAddress("return_double"), ScalarType.DOUBLE);
        hReturnDoubleD = Multiffi.JNA.downcallHandle(Multiffi.JNA.getSymbolAddress("return_double_d"), ScalarType.DOUBLE, ScalarType.DOUBLE);
    }

}
