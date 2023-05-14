package pl.hodan;

import lombok.AllArgsConstructor;
import pl.hodan.model.users.User;
import pl.hodan.model.users.geolocation.Geolocation;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;



@AllArgsConstructor
public class FindFurthestUsersGetUsersWithMaxDistance {
    private List<User> users;

    private double StringConvertToDouble(String coordinate) {
        double coordinateDouble = Double.parseDouble(coordinate);
        return coordinateDouble;
    }

    public double getDistance(Geolocation firstPoint, Geolocation secondPoint) {
        if(firstPoint == null || secondPoint ==null){
            throw new IllegalArgumentException("Geolocation is null");
        }
        double latitude1 =  StringConvertToDouble(firstPoint.getLat());
        double longtitude1 =  StringConvertToDouble(firstPoint.getLongitude());
        double latitude2 =  StringConvertToDouble(secondPoint.getLat());
        double longtitude2 =  StringConvertToDouble(secondPoint.getLongitude());

        double temp = longtitude1- longtitude2;

        double distanceInMils = acos(sin(degressToradian(latitude1)) * sin(degressToradian(latitude2)) + cos(degressToradian(latitude1)) * cos(degressToradian(latitude2)) * cos(degressToradian(temp)));
        distanceInMils = radianToDegress(distanceInMils);
        distanceInMils = 60 * 1.1515 * distanceInMils;

        return distanceInMils;

    }

    private double degressToradian(double degress) {
        return degress * PI / 180.0;
    }

    private double radianToDegress(double radian) {
        return radian * 180.0 / PI;
    }

    public List<User> usersWithMaxDestanceFromEachOther(){
        double maxDistance =0;
        User userFirstWithMaxDistance = null;
        User userSecondWithMaxDistance = null;

        for (User user1:users) {
            for (User user2:users) {
                double distance = getDistance(user1.getAddress().getGeolocation(), user2.getAddress().getGeolocation());
                if(distance > maxDistance){
                    maxDistance = distance;
                    userFirstWithMaxDistance = user1;
                    userSecondWithMaxDistance = user2;
                }
            }
        }

        List<User>usersWithMaxDistance = new ArrayList<>();
        usersWithMaxDistance.add(userFirstWithMaxDistance);
        usersWithMaxDistance.add(userSecondWithMaxDistance);
        return usersWithMaxDistance;
    }


}
