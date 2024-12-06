package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TableTest {
    @Test
    @DisplayName("Test case not set height and width to show default value of height = 1.0")
    void getHeight() {
        Table table = new Table();
        Assertions.assertEquals(1.0, table.getHeight());
    }

    @Test
    @DisplayName("Test case with height = 9.2 and height is negative")
    void setHeight() {
        Table table = new Table(8.9, 7.6);
        Assertions.assertEquals(8.9, table.getHeight());

        table.setHeight(9.2);
        Assertions.assertEquals(4.5, table.getHeight());

        // test: if height < 0: -> throw exception : RuntimeException "Height is not negative"
        Exception exception = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                table.setHeight(-1);
            }
        });
        Assertions.assertEquals("Height must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Test case not set height and width to show default value of width = 1.0")
    void getWidth() {
        Table table = new Table();
        Assertions.assertEquals(1.0, table.getWidth());
    }

    @Test
    @DisplayName("Test case with width = 9.2 and width is negative")
    void setWidth() {
        Table table = new Table(8.9, 7.6);
        Assertions.assertEquals(7.6, table.getWidth());

        table.setWidth(9.2);
        Assertions.assertEquals(9.2, table.getWidth());

        // test: if width < 0: -> throw exception : RuntimeException "Width is not negative"
        Exception exception = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                table.setWidth(-1);
            }
        });
        Assertions.assertEquals("Width must be positive", exception.getMessage());
    }

    @Test
    @DisplayName("Test case with height = 3.6, width = 9.3 and area = 33.48")
    void area() {
        Table table = new Table(3.6, 9.3);
        Assertions.assertEquals(40, table.area());
    }

    @Test
    @DisplayName("Test case with height = 3.6, width = 9.3 and perimeter = 25.80")
    void perimeter() {
        Table table = new Table(3.6, 9.3);
        Assertions.assertEquals(25.80, table.perimeter());
    }
}