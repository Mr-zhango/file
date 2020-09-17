package cn.myfreecloud.file.listener;

import cn.myfreecloud.file.service.ListenerService;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * @author zhangyang
 */
public class FileListener extends FileAlterationListenerAdaptor {

    /**
     * 声明业务服务
     */
    private ListenerService listenerService;

    /**
     * 采用构造函数注入服务
     * @param listenerService
     */
    public FileListener(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    /**
     * 文件创建执行
     * @param file
     */
    @Override
    public void onFileCreate(File file) {
        // 触发业务
        listenerService.createFile(file);
    }

    /**
     * 文件创建修改
     * @param file
     */
    @Override
    public void onFileChange(File file) {
        // 触发业务
        listenerService.fileChanged();
    }

    /**
     * 文件创建删除
     * @param file
     */
    @Override
    public void onFileDelete(File file) {

    }

    /**
     * 目录创建
     * @param directory
     */
    @Override
    public void onDirectoryCreate(File directory) {

    }

    /**
     * 目录修改
     * @param directory
     */
    @Override
    public void onDirectoryChange(File directory) {

    }

    /**
     * 目录删除
     * @param directory
     */
    @Override
    public void onDirectoryDelete(File directory) {

    }


    /**
     * 轮询开始
     * @param observer
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
        System.out.println("轮询开始");
    }

    /**
     * 轮询结束
     * @param observer
     */
    @Override
    public void onStop(FileAlterationObserver observer) {
        System.out.println("轮询结束");
    }
}