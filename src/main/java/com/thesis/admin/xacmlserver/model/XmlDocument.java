package com.thesis.admin.xacmlserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Id;

@Slf4j
@Getter
@Setter
@Document(collection = "XmlDocument")
public class XmlDocument {

        @Id
        private String serviceName;

        private String fileName;

        private String xmlContent;

 //       private String xmlContentEncoded;

        public  XmlDocument (String serviceName , String fileName , String xmlContent ) {
                this.serviceName = serviceName;
                this.fileName = fileName;
                this.xmlContent = xmlContent;
//                this.xmlContentEncoded = encrypt(xmlContentEncoded);

        }

//        public String encrypt(String strToEncrypt) {
//                try {
//                        String key = "UMAIR";
//                        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), "AES");
//                        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
//                        cipher.init(Cipher.ENCRYPT_MODE, sks);
//                        log.info("String to Encrypt Back : {}", strToEncrypt);
//                        byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
//                        return Base64.encodeBase64String(encrypted);
//                } catch (Exception e) {
//                   return null;
//                }
//        }
}
