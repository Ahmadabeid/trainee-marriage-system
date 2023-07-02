package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
public class QueAnsController {
    @Autowired
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

    @GetMapping("/getQueAnsById/{queAnsId}")
    public ResponseEntity<QueAns> getQueAnsById(@PathVariable Long queAnsId){
        QueAns queAns = queAnsService.getQueAnsById(queAnsId);
        return new ResponseEntity<>(queAns, OK);
    }

    @DeleteMapping("/deleteQueAnsById/{queAnsId}")
    public void deleteQueAnsById(@PathVariable Long queAnsId){
        queAnsService.deleteQueAnsById(queAnsId);
    }

// Update Question and Answer
   @PutMapping("/updateQueAns/{queAnsId}")
    public ResponseEntity<QueAns> updateQueAns(@RequestBody QueAns queAns,
   @PathVariable Long queAnsId){
        QueAns updateQueAns = queAnsService.updateQueAns(queAnsId,
                queAns.getQueContent(),queAns.getAnsContent(),
                queAns.getTopic(),queAns.getComment());
        return new ResponseEntity<>(updateQueAns, OK);
   }


}
