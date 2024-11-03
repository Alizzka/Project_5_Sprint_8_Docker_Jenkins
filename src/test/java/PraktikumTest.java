import org.example.Praktikum;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PraktikumTest {

    @Test
    void testMainMethod() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Запускаем main
        Praktikum.main(new String[]{});

        // Проверка содержимого вывода
        String expectedOutput = "Можно ли использовать имя \"Тимоти Шаламе\" для печати на карте? Да";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);  // Восстановить System.out
    }

    @Test
    void testRunProgram() {
        Praktikum.runProgram();
    }
}

