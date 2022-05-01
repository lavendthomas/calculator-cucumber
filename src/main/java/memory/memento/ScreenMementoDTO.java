package memory.memento;

import common.UnexpectedExpressionException;

import java.io.Serial;
import java.io.Serializable;
import static common.Configuration.*;

/**
 * Memento DTO (data transfer object) class with marshalling capabilities
 */
public class ScreenMementoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;
    private final String expression;
    private final String result;
    private final String mode;

    public ScreenMementoDTO(String exp, String res, String mode) {
        expression = exp;
        result = res;
        this.mode = mode;
    }

    public static ScreenMementoDTO marshaller(String res) throws UnexpectedExpressionException {
        String[] tab = res.split(EXPRESSION_SEPARATOR);
        ScreenMementoDTO dto;

        try {
            String[] subTab = tab[1].split(EXPRESSION_TYPE_SEPARATOR);
            dto = new ScreenMementoDTO(tab[0], subTab[0], subTab[1]);
        } catch (IndexOutOfBoundsException e) {
            throw new UnexpectedExpressionException(ERROR_MSG_RESULT_STRUCTURE);
        }

        return dto;
    }

    @Override
    public String toString() {
        return expression+ EXPRESSION_SEPARATOR +result+ EXPRESSION_TYPE_SEPARATOR +mode;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

    public String getMode() { return mode; }

}
