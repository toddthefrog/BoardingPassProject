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
        customer.setNumber("1234567890");
        assertEquals("1234567890",customer.getNumber());
    }

    @Test
    void getGender() {
        customer.setGender(Customer.Genders.Female);
        assertEquals(Customer.Genders.Female,customer.getGender());
    }

    @Test
    void getAge() {
        customer.setAge(345);
        assertEquals(345,customer.getAge());
    }
}