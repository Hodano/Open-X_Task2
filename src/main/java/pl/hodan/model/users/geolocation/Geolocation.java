package pl.hodan.model.users.geolocation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public
class Geolocation {
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("long")
    private String longitude; //long

    @Override
    public String toString() {
        return "Geolocation{" +
                "lat='" + lat + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
