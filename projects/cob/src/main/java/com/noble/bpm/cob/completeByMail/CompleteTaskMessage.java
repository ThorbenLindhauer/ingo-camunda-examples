package com.noble.bpm.cob.completeByMail;

import lombok.Data;

@Data
public class CompleteTaskMessage {
	private String subject;
	private String body;
}
