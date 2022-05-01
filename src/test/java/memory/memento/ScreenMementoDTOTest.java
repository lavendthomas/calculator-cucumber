package memory.memento;

import common.UnexpectedExpressionException;
import org.junit.jupiter.api.Test;

import static common.Configuration.*;
import static memory.memento.ScreenMementoDTO.marshaller;
import static org.junit.jupiter.api.Assertions.*;

class ScreenMementoDTOTest {

    @Test
    void marshaller_happy_case() {
        ScreenMementoDTO dto = new ScreenMementoDTO("0", "0", "mode");
        try {
            dto = marshaller("1 + 1" + EXPRESSION_SEPARATOR + "2" + EXPRESSION_TYPE_SEPARATOR + "mode");
        } catch (UnexpectedExpressionException e) {
            fail();
        }

        assertEquals(dto.getExpression(), "1 + 1");
        assertEquals(dto.getResult(), "2");
        assertEquals(dto.getMode(), "mode");
    }

    @Test
    void marshaller_throws_exception() {
        UnexpectedExpressionException thrown = assertThrows(UnexpectedExpressionException.class, () -> {
            marshaller("123");
        });

        assertEquals(ERROR_MSG_RESULT_STRUCTURE, thrown.getMessage());
    }

}
