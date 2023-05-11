package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Document;
import traineemarriagesystem.repository.DocumentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;

    public Document addDocument(String docType, String docName ){
        Document document=new Document();
        document.setDocType(docType);
        document.setDocName(docName);
        return documentRepository.save(document);
    }
    public void deleteById(Long docId){
        documentRepository.deleteById(docId);
    }

//    get users
    public List<Document> getAllDocument(){
        return documentRepository.findAll();
    }
//    get user by id

    public Document getDocumentById(Long docId){
        return documentRepository.findById(docId).get();
    }
}
