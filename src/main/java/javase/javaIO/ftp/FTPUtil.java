package javase.javaIO.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FTP ������
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
     * �ϴ��ļ�
     * @param path ����FTPλ��
     * @param file Ҫ�ϴ����ļ�
     * @param remoteName ��FTP����ʱ������
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
     * �����ļ�
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
     * ɾ���ļ�
     */
    public void deleteFile(String pathName) throws IOException {
        client.deleteFile(pathName);
    }

    /**
     * �л���ǰĿ¼��ָ��·������·������Ӹ�·��("/")��ʼ
     */
    public boolean cdAssignPath(String path) throws IOException {
        return client.changeWorkingDirectory(path);
    }

    /**
     * �ڸ����ڵ㴴���ӽڵ�Ŀ¼����������ڵ�Ϊ���ڵ�parent����Ϊ�ջ�/��
     */
    public boolean makeDir(String parent, String path) throws IOException {
        if(cdAssignPath(parent)){
            try {
                //�����Ѿ����ڵ�Ŀ¼�ᱨ��
                return client.makeDirectory(path);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        FTPUtil ftpUtil = new FTPUtil();
        // ����
        ftpUtil.connect();

        // �ϴ�
        File file = new File("C:\\Users\\shiwx\\Desktop\\ftp.txt");
        String fileName = file.getName();
        ftpUtil.upload("/", file, fileName);

//        // ����
//        ftpUtil.download("/", fileName, "C:\\Users\\shiwx\\Downloads", "velocity.log");
//
//        // ɾ��
//        ftpUtil.deleteFile("/velocity.log");
    }

}
