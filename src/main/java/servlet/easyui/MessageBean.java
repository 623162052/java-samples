package servlet.easyui;

import java.io.Serializable;

/**
 * Created by shiwx on 2016/3/3.
 */
public class MessageBean implements Serializable {

    private String msgId;
    private String userId;
    private String userName;
    private String sendType;
    private String msgContent;
    private String accessType;
    private String sendTime;
    private String remark;


    public MessageBean(String msgId, String userId, String userName, String sendType, String msgContent, String accessType, String sendTime, String remark) {
        this.msgId = msgId;
        this.userId = userId;
        this.userName = userName;
        this.sendType = sendType;
        this.msgContent = msgContent;
        this.accessType = accessType;
        this.sendTime = sendTime;
        this.remark = remark;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
