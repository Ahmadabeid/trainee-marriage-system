package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.QueAns;
import traineemarriagesystem.repository.QueAnsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueAnsService {
    private final QueAnsRepository queAnsRepository;

    public QueAns addQueAns(String QueContent, String AnsContent,
                            String Topic,String Comment){
        QueAns queAns=new QueAns();
        queAns.setQueContent(QueContent);
        queAns.setAnsContent(AnsContent);
        queAns.setTopic(Topic);
        queAns.setComment(Comment);
        return queAnsRepository.save(queAns);
    }

//
    public List<QueAns> getAllQueAns(){
        return queAnsRepository.findAll();
    }

    public QueAns getQueAnsById(Long QueAnsId){
        return queAnsRepository.findById(QueAnsId).get();
    }

    public void deleteQueAnsById(Long QueAnsId){
        queAnsRepository.deleteById(QueAnsId);
    }


}

