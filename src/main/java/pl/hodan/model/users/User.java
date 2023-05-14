package pl.hodan.model.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hodan.model.users.adress.Adress;
import pl.hodan.model.users.name.Name;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("address")
    private Adress address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("__v")
    private int Version; //__v

    public User(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, Adress address, String userName) {
        this.id = id;
        this.address = address;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", phone='" + phone + '\'' +
                ", Version=" + Version +
                '}';
    }

}
