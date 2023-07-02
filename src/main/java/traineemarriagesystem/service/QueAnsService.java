package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.QueAns;
import traineemarriagesystem.repository.QueAnsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueAnsService {
    @Autowired
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

    public QueAns getQueAnsById(Long queAnsId){
        return queAnsRepository.findById(queAnsId).get();
    }

    public void deleteQueAnsById(Long queAnsId){
        queAnsRepository.deleteById(queAnsId);
    }


   public QueAns updateQueAns(Long queAnsId,String queContent, String ansContent,String topic, String comment){
        QueAns queAns=getQueAnsById(queAnsId);
        queAns.setQueContent(queContent);
        queAns.setAnsContent(ansContent);
        queAns.setTopic(topic);
        queAns.setComment(comment);
        return queAnsRepository.save(queAns);
   }
}

