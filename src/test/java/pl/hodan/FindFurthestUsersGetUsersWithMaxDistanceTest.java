package pl.hodan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.hodan.model.users.User;
import pl.hodan.model.users.adress.Adress;
import pl.hodan.model.users.geolocation.Geolocation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindFurthestUsersGetUsersWithMaxDistanceTest {
    private List<User> userList;
    private Geolocation geolocation;

    @BeforeEach
    public void initialize() {
        userList = new ArrayList<>();


    }

    @AfterEach
    public void clear(){
        userList.clear();
    }
@Test
    public void getDistanceShouldReturnDistanceBeetweenFirstPointAndSecondPoint(){
        //given
        Geolocation geolocation1 = new Geolocation("51.5057","0.1278");
        Geolocation geolocation2 = new Geolocation("40.7128","-74.0060");
        //when
        FindFurthestUsersGetUsersWithMaxDistance maxDistance = new FindFurthestUsersGetUsersWithMaxDistance(null);
        double result = maxDistance.getDistance(geolocation1,geolocation2);
        //TrueDistance
        double exceptyedDistance = 3471.964;

        //then
        assertEquals(exceptyedDistance,result,0.5);
    }
    @Test
    public void getDistanceShouldThrowIllegalArgumentExceptionWhenGeolocationIsNull(){
        //given
        Geolocation geolocation1 = null;
        Geolocation geolocation2 = new Geolocation("40.7128","-74.0060");
        //when
        FindFurthestUsersGetUsersWithMaxDistance maxDistance = new FindFurthestUsersGetUsersWithMaxDistance(null);
        //TrueDistance
        double exceptyedDistance = 3471.964;

        //then
        assertThrows(IllegalArgumentException.class, () ->maxDistance.getDistance(geolocation1,geolocation2));
    }
    @Test
    public void shouldReturnUsersWithMaxDistanceFromEachOther(){
        //given
        Geolocation geolocation1 = new Geolocation("5.2333","5.222");
        Geolocation geolocation2 = new Geolocation("15.222","15.333");
        Geolocation geolocation3 = new Geolocation("80.222","90.33");

        User user = new User(1,new Adress(geolocation1),"Adam");
        User user1 = new User(1,new Adress(geolocation2),"Tomek");
        User user2 = new User(1,new Adress(geolocation3),"Michał");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        FindFurthestUsersGetUsersWithMaxDistance find = new FindFurthestUsersGetUsersWithMaxDistance(userList);
        //when
        //excepted User, User2
        int userId = userList.get(0).getId();
        int user2Id = userList.get(2).getId();
        List<User> resultUsers = find.usersWithMaxDestanceFromEachOther();

        //then
        assertThat(resultUsers.get(0).getId(),equalTo(userId));
        assertThat(resultUsers.get(1).getId(),equalTo(user2Id));

    }



}