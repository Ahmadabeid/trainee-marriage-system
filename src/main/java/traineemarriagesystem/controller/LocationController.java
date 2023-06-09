package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Location;
import traineemarriagesystem.service.LocationService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/Location")
@RequiredArgsConstructor
public class LocationController {
    @Autowired
    private final LocationService locationService;

    @PostMapping("/addLocation")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        Location newLocation=locationService.addLocation(location.getLocNumber(),
                location.getLocName());
        return new ResponseEntity<>(newLocation,CREATED);
    }

    @DeleteMapping("/delete/{locationId}")
    public void deleteLocationById(@PathVariable Long locationId){
        locationService.deleteByLocationId(locationId);
    }

//    get locations

    @GetMapping("/getLocations")
    public ResponseEntity<List<Location>> getAllLocations(){
        List<Location> newList=locationService.getAllLocations();
        return new ResponseEntity<>(newList,OK);
    }

//    get location by id

    @GetMapping("/getLocationById/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId){
        Location location=locationService.getLocationById(locationId);
        return new ResponseEntity<>(location,OK);
    }

// update location
    @PutMapping("/updateLocation/{locationId}")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location,@PathVariable Long locationId){
        Location updateLocation=locationService.updateLocation(locationId,
                location.getLocNumber(),location.getLocName());
        return new ResponseEntity<>(updateLocation, OK);
    }

}
