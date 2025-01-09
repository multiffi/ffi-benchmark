package multiffi.ffi.benchmark;

import multiffi.ffi.ForeignType;
import multiffi.ffi.FunctionHandle;
import multiffi.ffi.ScalarType;

public final class MultiffiFFM {

    private MultiffiFFM() {
        throw new AssertionError("No multiffi.ffi.benchmark.MultiffiFFM instances for you!");
    }

    public static final FunctionHandle hReturnVoid, hReturnInt, hReturnIntI, hReturnDouble, hReturnDoubleD;
    static {
        hReturnVoid = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_void"), ForeignType.VOID);
        hReturnInt = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_int"), ScalarType.INT32);
        hReturnIntI = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_int_i"), ScalarType.INT32, ScalarType.INT32);
        hReturnDouble = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_double"), ScalarType.DOUBLE);
        hReturnDoubleD = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_double_d"), ScalarType.DOUBLE, ScalarType.DOUBLE);
    }

}
