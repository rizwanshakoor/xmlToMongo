package com.thesis.admin.xacmlserver.service;

import com.thesis.admin.xacmlserver.pojo.DataObject;
import org.springframework.http.ResponseEntity;

public interface XmlFileService {

    ResponseEntity<?> getAllXmlFile();

    ResponseEntity<?> getSingleXmlFile(String serviceName);

    ResponseEntity<?> deleteSingleXmlFile(String serviceName);

    ResponseEntity<?> createSingleFile(DataObject request);
}
