package projekt3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest
{
    @BeforeEach
    void setup()
    {

    }

    @Test
    void someMethodTest()
    {
        // Arrange
        App app = new App();

        // Act
        boolean result = app.someMethod();

        // Assert
        assertThat(result).isTrue();
    }
}
