package gui.navigation;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculator modes enumeration
 */
public enum ModeEnum {

    BASIC_MODE(0, "BasicMode"),
    CONVERTER_MODE(1, "ConverterMode"),
    SCIENTIFIC_MODE(2, "ScientificMode"),
    FUNCTION_MODE(3, "FunctionMode"),
    LOGICAL_MODE(4, "LogicalMode");

    private final int index;
    private final String id;

    private static final Map<String, ModeEnum> lookup = new HashMap();

    static {
        for(ModeEnum h : ModeEnum.values())
            lookup.put(h.id(), h);
    }

    ModeEnum(int index, String id){
        this.index = index;
        this.id = id;
    }

    public String id(){
        return id;
    }

    public static ModeEnum mode(String title) {
        return lookup.get(title);
    }
}

