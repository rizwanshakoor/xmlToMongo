package com.thesis.admin.xacmlserver.model.repository;

import com.thesis.admin.xacmlserver.model.XmlDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface XmlDocumentRepository extends MongoRepository<XmlDocument, String> {
 //    public List<XmlDocument> findAllXmlDocument();
}
