package com.thesis.admin.xacmlserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.thesis.admin.xacmlserver.model.XmlDocument;
import com.thesis.admin.xacmlserver.model.service.XmlDocumentModelService;
import com.thesis.admin.xacmlserver.pojo.DataObject;
import com.thesis.admin.xacmlserver.pojo.DeleteSingleFileResponse;
import com.thesis.admin.xacmlserver.pojo.GetAllXmlFileResponse;
import com.thesis.admin.xacmlserver.pojo.GetSingleXmlFileReponse;
import com.thesis.admin.xacmlserver.pojo.SingleXACMLResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class XmlFileServiceImpl implements XmlFileService {

    @Autowired
    private XmlDocumentModelService xmlDocumentModelService;

    @Override public ResponseEntity<?> getAllXmlFile() {
        List<XmlDocument> docs =  xmlDocumentModelService.findAllXmlDocument();
        String message = docs.isEmpty() ? "ERROR" : "OK";
        if(message.equalsIgnoreCase("ERROR")) {
            return new ResponseEntity<GetAllXmlFileResponse>(buildEmptyErrorResponse(), HttpStatus.OK);
        } else {
        	 List<DataObject> allDataObject = new ArrayList<>();
        	for (XmlDocument xmlDocument : docs) {
        		DataObject dOb = new DataObject();
        		dOb.setFileName(xmlDocument.getFileName());
        		dOb.setServiceName(xmlDocument.getServiceName());
        		dOb.setXmlContent(xmlDocument.getXmlContent());
        		allDataObject.add(dOb);
			}
            GetAllXmlFileResponse fullResponse = new GetAllXmlFileResponse();
            fullResponse.setData(allDataObject);
            fullResponse.setMessage(message);
            return new ResponseEntity<GetAllXmlFileResponse>(fullResponse,HttpStatus.OK);
        }
    }

    @Override public ResponseEntity<?> getSingleXmlFile(String serviceName) {
        Optional<XmlDocument> docs = xmlDocumentModelService.findFirstByServiceName(serviceName);
        if(ObjectUtils.isEmpty(docs)) {
            return new ResponseEntity<GetAllXmlFileResponse>(buildEmptyErrorResponse(), HttpStatus.OK);
        } else {
            GetSingleXmlFileReponse fullResponse = new GetSingleXmlFileReponse();
            DataObject singleData = new DataObject();
            singleData.setFileName(docs.get().getFileName());
            singleData.setServiceName(docs.get().getServiceName());
            singleData.setXmlContent(docs.get().getXmlContent());
            fullResponse.setData(singleData);
            fullResponse.setMessage("OK");
            return new ResponseEntity<GetSingleXmlFileReponse>(fullResponse,HttpStatus.OK);
        }
    }

    @Override public ResponseEntity<?> deleteSingleXmlFile(String serviceName) {
        Boolean removeSuccess = false;
        if(xmlDocumentModelService.deleteByServiceName(serviceName)) {
            return new ResponseEntity<DeleteSingleFileResponse>(new DeleteSingleFileResponse(true) , HttpStatus.OK);
        }
        return new ResponseEntity<DeleteSingleFileResponse>(new DeleteSingleFileResponse(false) , HttpStatus.OK);
    }

    @Override public ResponseEntity<?> createSingleFile(DataObject request) {
        Optional<XmlDocument> docs = xmlDocumentModelService.findFirstByServiceName(request.getServiceName());
        if(!ObjectUtils.isEmpty(docs)) {
            SingleXACMLResponse errorResponse  = new SingleXACMLResponse();
            errorResponse.setData(request);
            errorResponse.setMessage("ERROR");
            return new ResponseEntity<SingleXACMLResponse>(errorResponse,HttpStatus.OK);
        } else {
            xmlDocumentModelService.saveXmlDocumentToDb(buildXmlDocumentFromDataObject(request));
            return new ResponseEntity<SingleXACMLResponse>(makeSuccessResponseForSingleCreateOrUpdate(request), HttpStatus.OK);
        }
    }

    private SingleXACMLResponse makeSuccessResponseForSingleCreateOrUpdate(DataObject request) {
        SingleXACMLResponse returnObject = new SingleXACMLResponse();
        returnObject.setData(request);
        returnObject.setMessage("OK");
        return returnObject;
    }

    private XmlDocument buildXmlDocumentFromDataObject(DataObject request) {
       return new XmlDocument(request.getServiceName() , request.getFileName(),
                request.getXmlContent());
    }

    public GetAllXmlFileResponse buildEmptyErrorResponse(){
        List<DataObject> emptyData = new ArrayList<>();
        GetAllXmlFileResponse emptyResponse = new GetAllXmlFileResponse();
        emptyResponse.setData(emptyData);
        emptyResponse.setMessage("ERROR");
        return emptyResponse;
    }
}
