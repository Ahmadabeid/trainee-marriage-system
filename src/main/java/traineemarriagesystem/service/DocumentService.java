package traineemarriagesystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineemarriagesystem.model.Document;
import traineemarriagesystem.repository.DocumentRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;

    public Document addDocument(String docType, String docName, String docSize ) {

        Document document = new Document();
        document.setDocType(docType);
        document.setDocName(docName);
        document.setDocSize(docSize);
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

   public Document updateDocument(Long docId,String docType, String docName, String docSize){
        Document document=getDocumentById(docId);
        document.setDocType(docType);
        document.setDocName(docName);
        document.setDocSize(docSize);
        return documentRepository.save(document);
   }
}
