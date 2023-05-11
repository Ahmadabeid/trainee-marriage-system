package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.QueAns;
import traineemarriagesystem.service.QueAnsService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/QueAns")
@RequiredArgsConstructor
public class QueAnsController {
    private final QueAnsService queAnsService;

    @PostMapping("/addQueAns")
    public ResponseEntity<QueAns> addQueAns(@RequestBody QueAns queAns){
        QueAns newQueAns = queAnsService.addQueAns(queAns.getQueContent(),
                queAns.getAnsContent(),queAns.getTopic(),queAns.getComment());
        return new ResponseEntity<>(newQueAns, CREATED);

    }
    @GetMapping("/getAllQueAns")
    public ResponseEntity<List<QueAns>> getAllQueAns(){
        List<QueAns> newList=queAnsService.getAllQueAns();
        return new ResponseEntity<>(newList, OK);
    }

    @GetMapping("/getAllQueAns/{QueAnsId}")
    public ResponseEntity<QueAns> getQueAnsById(@PathVariable Long QueAnsId){
        QueAns queAns = queAnsService.getQueAnsById(QueAnsId);
        return new ResponseEntity<>(queAns, OK);
    }

    @DeleteMapping("/delete/{QueAnsId}")
    public void deleteQueAnsById(Long QueAnsId){
        queAnsService.deleteQueAnsById(QueAnsId);
    }

//    @PutMapping("/")
//    public QueAns updateQueAns(@RequestBody QueAns queAns,@PathVariable Long QueAnsId){
//        return queAnsService.addQueAns(queAns);
//    }

}