import java.util.Objects;
import java.util.Random;

public class Customer {
    private String name;
    private String email;
    private String number;
    private Genders gender;
    Random random = new Random();
    private final int customerNumber = random.nextInt();
    private int age;
    enum Genders {
        Male,
        Female,
        Other,
        Java_Developer
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getName() + "\n  age: " + getAge() + "\n  phone number: " + getNumber() + "\n  email: " + getEmail() + "\n  gender: " + getGender().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getAge() == customer.getAge() && getName().equals(customer.getName()) && getEmail().equals(customer.getEmail()) && getNumber().equals(customer.getNumber()) && getGender() == customer.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getNumber(), getGender(), getAge());
    }
}
