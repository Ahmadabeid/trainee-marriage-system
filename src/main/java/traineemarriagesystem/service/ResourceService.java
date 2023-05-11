package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Resource;
import traineemarriagesystem.repository.ResourceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public Resource addResource(String resType, String resName, String resContent,
                                String resFile, Date resDate){
        Resource resource = new Resource();
        resource.setResType(resType);
        resource.setResName(resName);
        resource.setResContent(resContent);
        resource.setResFile(resFile);
        resource.setResDate(resDate);
        return resourceRepository.save(resource);
    }

//    get Resources
    public List<Resource> getAllResource(){
        return resourceRepository.findAll();
    }

//    get resource by id
    public Resource getResourceById(Long resId){
        return resourceRepository.findById(resId).get();
    }

    public void deleteResourceById(Long resId){
        resourceRepository.deleteById(resId);
    }
}
