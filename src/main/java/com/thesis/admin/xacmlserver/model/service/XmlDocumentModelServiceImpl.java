package com.thesis.admin.xacmlserver.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.admin.xacmlserver.model.XmlDocument;
import com.thesis.admin.xacmlserver.model.repository.XmlDocumentRepository;

@Service
public class XmlDocumentModelServiceImpl implements  XmlDocumentModelService {

    @Autowired
    private XmlDocumentRepository repo;


    @Override public void saveXmlDocumentToDb(XmlDocument xmlDocument) {
        repo.save(xmlDocument);
    }

    @Override public List<XmlDocument> findAllXmlDocument() {
       return repo.findAll();
    }

    @Override public Optional<XmlDocument> findFirstByServiceName(String serviceName) {
		return repo.findFirstByServiceName(serviceName);
    }

    @Override public Boolean deleteByServiceName(String serviceName) {
        try{
			repo.deleteXmlDocumentByServiceName(serviceName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
