package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Resource;
import traineemarriagesystem.service.ResourceService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
@CrossOrigin
public class ResourceController {
    @Autowired
    private final ResourceService resourceService;

    @PostMapping("/addResource")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resource){
        Resource newResource = resourceService.addResource(resource.getResType(),
                resource.getResName(),  resource.getResContent(),resource.getResFile(),
                resource.getResDate());
        return new ResponseEntity<>(newResource,CREATED);
        }

//        Get Resource
    @GetMapping("/getResource")
    public ResponseEntity<List<Resource>> getAllUsers(){
        List<Resource> newList=resourceService.getAllResource();
        return new ResponseEntity<>(newList, OK);
    }

//    Get resource by id
    @GetMapping("/getResourceById/{resId}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long resId){
        Resource resource=resourceService.getResourceById(resId);
        return new ResponseEntity<>(resource, OK);
    }

    @DeleteMapping("/delete/{resId}")
    public void deleteResourceById(@PathVariable Long resId){
        resourceService.deleteResourceById(resId);
    }

    @PutMapping("/updateResource/{resId}")
    public ResponseEntity<Resource> updateResource(@RequestBody Resource resource, @PathVariable Long resId){
        Resource updateResource=resourceService.updateResource(resId, resource.getResType(), resource.getResName(),
                resource.getResContent(),resource.getResFile(),resource.getResDate());
        return new ResponseEntity<>(updateResource, OK);
    }



}
