package com.studyhub.common.vo;

public class Message implements java.io.Serializable {
	private int messageNo;
	private String receiver;
	private String sender;
	private int senderNo;
	private int receiverNo;
	private int groupNo;
	private String groupName;
	private String message;
	private int messageState;
	private String userName;
	
	public Message() {
		super();
	}

	public Message(int messageNo, String receiver, String sender, int groupNo, String groupName, String message,
			int messageState) {
		super();
		this.messageNo = messageNo;
		this.receiver = receiver;
		this.sender = sender;
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.message = message;
		this.messageState = messageState;
	}

	public Message(int messageNo, int senderNo, int receiverNo, int groupNo, String groupName, String message,
			int messageState, String userName) {
		super();
		this.messageNo = messageNo;
		this.senderNo = senderNo;
		this.receiverNo = receiverNo;
		this.groupNo = groupNo;
		this.groupName = groupName;
		this.message = message;
		this.messageState = messageState;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSenderNo() {
		return senderNo;
	}



	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}



	public int getReceiverNo() {
		return receiverNo;
	}



	public void setReceiverNo(int receiverNo) {
		this.receiverNo = receiverNo;
	}



	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageState() {
		return messageState;
	}

	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}

	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", receiver=" + receiver + ", sender=" + sender + ", groupNo="
				+ groupNo + ", groupName=" + groupName + ", message=" + message + ", messageState=" + messageState
				+ "]";
	}
}
