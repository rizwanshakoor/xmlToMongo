package com.thesis.admin.xacmlserver.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thesis.admin.xacmlserver.model.XmlDocument;

public interface XmlDocumentRepository extends MongoRepository<XmlDocument, String> {
 //    public List<XmlDocument> findAllXmlDocument();
	Optional<XmlDocument> findFirstByServiceName(String serviceName);

	Long deleteXmlDocumentByServiceName(String serviceName);
}
