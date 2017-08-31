package javase.javaIO.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FTP 操作类
 * Created by shiwx on 2016/4/3.
 */
public class FTPUtil {
    private static final String CHARSET = "UTF-8";
    private FTPClient client = null;

    private String host = "192.168.0.240";
    private int port = 21;
    private String user = "ftpuser";
    private String password = "ftpuser";

    /**
     * Login FTP
     */
    public boolean connect() throws IOException {
        client = new FTPClient();
        client.setControlEncoding(CHARSET);
        client.connect(host, port);
        return client.login(user, password);
    }

    /**
     * Close Connection
     */
    public void close() {
        if(client != null && client.isConnected()) {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 上传文件
     * @param path 保存FTP位置
     * @param file 要上传的文件
     * @param remoteName 在FTP保存时的名字
     */
    public void upload(String path, File file, String remoteName) {
        try {
            if(cdAssignPath(path)) {
                boolean result = client.storeFile(remoteName, new FileInputStream(file));
                System.out.println("result: " + result);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 下载文件
     */
    public void download(String remotePath, String remoteName, String localPath, String localName) throws IOException {
        if(cdAssignPath(remotePath)) {

            FileOutputStream outputStream = null;
            try {
                File file = new File(localPath);
                if(!file.exists()) {
                    file.mkdirs();
                }
                outputStream = new FileOutputStream(new File(localPath + "/" + localName));
                client.retrieveFile(remoteName, outputStream);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(outputStream != null){
                    outputStream.close();
                }
            }
        }
    }


    /**
     * 删除文件
     */
    public void deleteFile(String pathName) throws IOException {
        client.deleteFile(pathName);
    }

    /**
     * 切换当前目录到指定路径，该路径必须从根路径("/")开始
     */
    public boolean cdAssignPath(String path) throws IOException {
        return client.changeWorkingDirectory(path);
    }

    /**
     * 在父级节点创建子节点目录，如果父级节点为根节点parent可以为空或“/”
     */
    public boolean makeDir(String parent, String path) throws IOException {
        if(cdAssignPath(parent)){
            try {
                //创建已经存在的目录会报错
                return client.makeDirectory(path);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        FTPUtil ftpUtil = new FTPUtil();
        // 连接
        ftpUtil.connect();

        // 上传
        File file = new File("C:\\Users\\shiwx\\Desktop\\ftp.txt");
        String fileName = file.getName();
        ftpUtil.upload("/", file, fileName);

//        // 下载
//        ftpUtil.download("/", fileName, "C:\\Users\\shiwx\\Downloads", "velocity.log");
//
//        // 删除
//        ftpUtil.deleteFile("/velocity.log");
    }

}
