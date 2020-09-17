package cn.myfreecloud.file.service;

import java.io.File;

/**
 * @author zhangyang
 */
public interface ListenerService {

    void createFile(File file);

    void fileChanged();
}
