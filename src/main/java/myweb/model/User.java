package myweb.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Byte age;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    public User() {}

    public User(String name, Byte age, String city, String phone) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(getId());
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", age='").append(getAge()).append('\'');
        sb.append(", city='").append(getCity()).append('\'');
        sb.append(", phone='").append(getPhone()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
