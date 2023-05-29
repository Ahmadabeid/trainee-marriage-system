package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Location;
import traineemarriagesystem.repository.LocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    @Autowired
    private final LocationRepository locationRepository;

    public Location addLocation(String locNumber, String locName) {
        Location location = new Location();
        location.setLocNumber(locNumber);
        location.setLocName(locName);
        return locationRepository.save(location);
    }

    public void deleteByLocationId(Long locationId){
        locationRepository.deleteById(locationId);
    }

//    get locations
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

//    get location by id

    public Location getLocationById(Long locationId)
    {
        return locationRepository.findById(locationId).get();

    }

// update Location
    public Location updateLocation(Long locationId,String locNumber,String locName){
        Location location=getLocationById(locationId);
        location.setLocNumber(locNumber);
        location.setLocName(locName);
        return locationRepository.save(location);
    }

}
