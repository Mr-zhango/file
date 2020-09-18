package cn.myfreecloud.file.service.impl;

import cn.myfreecloud.file.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * @author zhangyang
 */
@Service
public class ListenerServiceImpl implements ListenerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${upload.key}")
    private String UPLOADKEY;

    @Value("${upload.url}")
    private String UPLOADURL;

    @Override
    public void createFile(File file) {

        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);

        //设置请求体，注意是 LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", fileSystemResource);
        form.add("filename",file.getName());
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);

        String s = null;
        try {
            s = restTemplate.postForObject(UPLOADURL+"?token="+UPLOADKEY, files, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件上传出错");
        }
        System.out.println(s);
        System.out.println("file created");
    }

    @Override
    public void fileChanged() {
        System.out.println("file cahnged");
    }
}
