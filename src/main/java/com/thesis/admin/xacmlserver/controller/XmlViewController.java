package com.thesis.admin.xacmlserver.controller;

import com.thesis.admin.xacmlserver.pojo.DataObject;
import com.thesis.admin.xacmlserver.service.XmlFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController @Slf4j public class XmlViewController {

    @Autowired public XmlFileService xmlFileService;

    @RequestMapping(path = "/xmlView/api/getAll", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllXmlFiles(@RequestHeader Map<String, String> headers) {
        ResponseEntity<?> response = xmlFileService.getAllXmlFile();
        log.debug("response [{}]", response);
        return response;
    }

    @RequestMapping(path = "/xmlView/api/getSingle", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getSingleXmlFile(@RequestHeader Map<String, String> headers,
            @RequestParam(name = "serviceName", required = true) String serviceName) {
        ResponseEntity<?> response = xmlFileService.getSingleXmlFile(serviceName);
        log.debug("response [{}]", response);
        return response;
    }

    @RequestMapping(path = "/xmlView/api/remove", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteSingleXmlFile(@RequestHeader Map<String, String> headers,
            @RequestParam(name = "serviceName", required = true) String serviceName) {
        ResponseEntity<?> response = xmlFileService.deleteSingleXmlFile(serviceName);
        log.debug("response [{}]", response);
        return response;
    }

    @RequestMapping(path = "/xmlView/api/create", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createSingleFile(@RequestHeader Map<String, String> headers,
            @RequestBody DataObject request) {
        ResponseEntity<?> response = xmlFileService.createSingleFile(request);
        log.debug("response [{}]", response);
        return response;
    }

}
