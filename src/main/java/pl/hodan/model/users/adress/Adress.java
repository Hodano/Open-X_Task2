package pl.hodan.model.users.adress;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hodan.model.users.geolocation.Geolocation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @JsonProperty("geolocation")
    private Geolocation geolocation;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private int number;
    @JsonProperty("zipcode")
    private String zipCode;

    public Adress(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "geolocation=" + geolocation +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}


