package multiffi.ffi.benchmark;

import multiffi.ffi.ForeignType;
import multiffi.ffi.FunctionHandle;
import multiffi.ffi.ScalarType;
import multiffi.ffi.StandardCallOption;

public final class MultiffiFFMCritical {

    private MultiffiFFMCritical() {
        throw new AssertionError("No multiffi.ffi.benchmark.MultiffiFFMCritical instances for you!");
    }

    public static final FunctionHandle hReturnVoid, hReturnInt, hReturnIntI, hReturnDouble, hReturnDoubleD;
    static {
        hReturnVoid = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_void"), ForeignType.VOID, new ForeignType[] {}, StandardCallOption.TRIVIAL);
        hReturnInt = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_int"), ScalarType.INT32, new ForeignType[] {}, StandardCallOption.TRIVIAL);
        hReturnIntI = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_int_i"), ScalarType.INT32, new ForeignType[] { ScalarType.INT32 }, StandardCallOption.TRIVIAL);
        hReturnDouble = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_double"), ScalarType.DOUBLE, new ForeignType[] {}, StandardCallOption.TRIVIAL);
        hReturnDoubleD = Multiffi.FFM.downcallHandle(Multiffi.FFM.getSymbolAddress("return_double_d"), ScalarType.DOUBLE, new ForeignType[] { ScalarType.DOUBLE }, StandardCallOption.TRIVIAL);
    }

}
