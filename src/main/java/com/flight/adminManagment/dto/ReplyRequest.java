package com.flight.adminManagment.dto;

	public class ReplyRequest {
	    private String reply;
	    private Long userQueryId;
	    private Long userId;
	    public String getReply() {
	        return reply;
	    }

	    public Long getUserQueryId() {
			return userQueryId;
		}


		public void setUserQueryId(Long userQueryId) {
			this.userQueryId = userQueryId;
		}


		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
			this.userId = userId;
		}


		public void setReply(String reply) {
	        this.reply = reply;
	    }
	}


