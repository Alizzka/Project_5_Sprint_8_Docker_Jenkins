import org.example.Account;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Account Name Validation")
@Feature("Name Embossing Rules")
public class AccountTest {

    // Позитивные тесты
    @Test
    @Story("Valid name with a single space, 13 symbols")
    @Description("Проверка, что имя 'Тимоти Шаламе' в 13 символов, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName13SymbolsAndOneSpace() {
        Account account = new Account("Тимоти Шаламе");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 3 symbols")
    @Description("Проверка, что имя 'Т Ш' в 3 символа, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName3SymbolsAndOneSpace() {
        Account account = new Account("Т Ш");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 4 symbols")
    @Description("Проверка, что имя 'Ти Ш' в 4 символа, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName4SymbolsOneSpace() {
        Account account = new Account("Ти Ш");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 5 symbols")
    @Description("Проверка, что имя 'Тим Ш' в 5 символов, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName5SymbolsOneSpace() {
        Account account = new Account("Тим Ш");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 17 symbols")
    @Description("Проверка, что имя 'Тимоти Шаламешала' в 17 символов, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName17SymbolsOneSpace() {
        Account account = new Account("Тимоти Шаламешала");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 18 symbols")
    @Description("Проверка, что имя 'Тимоти Шаламешалам' в 18 символов, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName18SymbolsOneSpace() {
        Account account = new Account("Тимоти Шаламешалам");
        assertTrue(account.checkNameToEmboss());
    }

    @Test
    @Story("Valid name with a single space, 19 symbols")
    @Description("Проверка, что имя 'Тимоти Шаламешаламе' в 19 символов, включая пробел, проходит валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testValidName19SymbolsOneSpace() {
        Account account = new Account("Тимоти Шаламешаламе");
        assertTrue(account.checkNameToEmboss());
    }

    // Негативные тесты
    @Test
    @Story("No spaces in the name")
    @Description("Проверка, что имя без пробелов, 14 символов, 'ТимотейШевроле' не проходит валидацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testNoSpace() {
        Account account = new Account("ТимотейШевроле");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Space at the start of the name")
    @Description("Проверка, что имя с пробелом в начале ' ТимотиШаламе' не проходит валидацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testSpaceAtStart() {
        Account account = new Account(" ТимотиШаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Space at the end of the name")
    @Description("Проверка, что имя с пробелом в конце 'ТимотиШаламе ' не проходит валидацию.")
    @Severity(SeverityLevel.NORMAL)
    public void testSpaceAtEnd() {
        Account account = new Account("ТимотиШаламе ");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("2 spaces in the name")
    @Description("Проверка, что имя с 2 пробелами 'Тимоти  Шаламе' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testMultipleSpaces2() {
        Account account = new Account("Тимоти  Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("3 spaces in the name")
    @Description("Проверка, что имя с 3 пробелами 'Тимоти   Шаламе' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testMultipleSpaces3() {
        Account account = new Account("Тимоти   Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too short, 2 symbols")
    @Description("Проверка, что слишком короткое имя, в 2 символа 'ТШ' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testShortName2() {
        Account account = new Account("ТШ");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too short, 2 symbols including space")
    @Description("Проверка, что слишком короткое имя, в 2 символа, включая пробел, 'Т ' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testShortName2WithSpace() {
        Account account = new Account("Т ");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too short, 1 symbol")
    @Description("Проверка, что слишком короткое имя, в 1 символ 'Т' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testShortName1() {
        Account account = new Account("Т");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too short, 1 symbol = space")
    @Description("Проверка, что слишком короткое имя, в 1 символ пробел ' ' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testShortName1Space() {
        Account account = new Account(" ");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too short, 0 symbols, empty field")
    @Description("Проверка, что пустое поле не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testShortName0() {
        Account account = new Account("");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too long, 24 symbols")
    @Description("Проверка, что слишком длинное имя, в 24 символов, 'Тимоти ШаламеСуперзвезда' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testLongName24() {
        Account account = new Account("Тимоти ШаламеСуперзвезда");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too long, 20 symbols")
    @Description("Проверка, что слишком длинное имя, в 20 символов, 'Тимоти ШаламеСуперзв' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testLongName20() {
        Account account = new Account("Тимоти ШаламеСуперзв");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Name too long, 21 symbols")
    @Description("Проверка, что слишком длинное имя, в 21 символов, 'Тимоти ШаламеСуперзве' не проходит валидацию.")
    @Severity(SeverityLevel.MINOR)
    public void testLongName21() {
        Account account = new Account("Тимоти ШаламеСуперзве");
        assertFalse(account.checkNameToEmboss());
    }

    @Test
    @Story("Имя с цифрами")
    @Description("Имя с цифрами до и после пробела не должно проходить валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testNameWithDigitsBeforeAndAfterSpace() {
        Account account = new Account("Тим1 Шаламе2");
        assertFalse(account.checkNameToEmboss(), "Имя с цифрами до и после пробела не должно проходить валидацию");
    }

    @Test
    @Story("Имя со спец символами")
    @Description("Имя со спец символами до и после пробела не должно проходить валидацию.")
    @Severity(SeverityLevel.CRITICAL)
    public void testNameWithSpecificSymbolsBeforeAndAfterSpace() {
        Account account = new Account("Тимо-ти Ш@ламе");
        assertFalse(account.checkNameToEmboss(), "Имя со спец символами до и после пробела не должно проходить валидацию");
    }
}


