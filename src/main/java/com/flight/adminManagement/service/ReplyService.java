package com.flight.adminManagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.adminManagement.model.Reply;
import com.flight.adminManagement.repository.ReplyRepository;
import com.flight.adminManagment.dto.ReplyRequest;


	@Service
	public class ReplyService {

	    @Autowired
	    private ReplyRepository replyRepository;

	    public String sendReply(ReplyRequest replyRequest) throws Exception {
	        Reply reply = new Reply();
	        reply.setUserQueryId(replyRequest.getUserQueryId());
	        reply.setAdminReply(replyRequest.getReply());
	        reply.setUserId(replyRequest.getUserId());
	        try {
	        	replyRepository.save(reply);
	        }catch(Exception e) {
	        	throw new Exception("Reply Failed");
	    }
			return "Reply sent successfully";
	}

}
