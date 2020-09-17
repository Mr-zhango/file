package cn.myfreecloud.file.service.impl;

import cn.myfreecloud.file.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * @author zhangyang
 */
@Service
public class ListenerServiceImpl implements ListenerService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void createFile(File file) {

        //file

        // restTemplate.postForEntity();
        System.out.println("file created");
    }

    @Override
    public void fileChanged() {
        System.out.println("file cahnged");
    }
}
