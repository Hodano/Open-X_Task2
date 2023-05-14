package pl.hodan.model.products.ratings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private float rate;
    private int count;

    @Override
    public String toString() {
        return "Raiting{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }
}
