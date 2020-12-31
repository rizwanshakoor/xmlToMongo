package com.thesis.admin.xacmlserver.model.service;

import com.thesis.admin.xacmlserver.model.XmlDocument;

import java.util.List;
import java.util.Optional;

public interface XmlDocumentModelService {

    public void saveXmlDocumentToDb(XmlDocument xmlDocument);

    public List<XmlDocument> findAllXmlDocument();

    public Optional<XmlDocument> findFirstByServiceName(String serviceName);

    public Boolean deleteByServiceName(String serviceName);

}
