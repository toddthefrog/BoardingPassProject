import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        customer.setName("todd");
        assertEquals("todd", customer.getName());
    }

    @Test
    void getEmail() {
        customer.setEmail("a@a.com");
        assertEquals("a@a.com",customer.getEmail());
    }

    @Test
    void getNumber() {
        customer.setNumber(123);
        assertEquals(123,customer.getNumber());
    }

    @Test
    void getGender() {
        customer.setGender("F");
        assertEquals("F",customer.getGender());
    }

    @Test
    void getAge() {
        customer.setAge(345);
        assertEquals(345,customer.getAge());
    }
}