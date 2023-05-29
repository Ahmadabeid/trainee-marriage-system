package traineemarriagesystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traineemarriagesystem.model.Document;
import traineemarriagesystem.service.DocumentService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Document")
public class DocumentController {
    @Autowired
    private final DocumentService documentService;

    @PostMapping("/addDocument")
    public ResponseEntity<Document> addDocument(@RequestBody Document document){
        Document newDocument= documentService.addDocument(document.getDocType( ),
                document.getDocName(), document.getDocSize());
        return new ResponseEntity<>(newDocument, CREATED);
    }
    @DeleteMapping("/deleteDocumentById/{docId}")
    public void deleteDocumentById(@PathVariable Long docId){
        documentService.deleteById(docId);

    }

//    get Documents
    @GetMapping("/getDocuments")
    public ResponseEntity<List<Document>> getDocuments(){
        List<Document> newList=documentService.getAllDocument();
        return new ResponseEntity<>(newList,OK);
    }

//    get document by id

    @GetMapping("/getDocumentById/{docId}")
    public ResponseEntity <Document> getDocumentById(@PathVariable Long docId){
        Document document=documentService.getDocumentById(docId);
        return new ResponseEntity<>(document,OK);
    }

// update Document

    @PutMapping("/updateDocument/{docId}")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document,
                                                   @PathVariable Long docId){
        Document updateDocument=documentService.updateDocument(docId,
                document.getDocType(), document.getDocName(),document.getDocSize());
        return new ResponseEntity<>(updateDocument, OK);
    }


}
