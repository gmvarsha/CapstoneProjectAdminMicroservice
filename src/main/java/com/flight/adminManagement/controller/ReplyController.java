package com.flight.adminManagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flight.adminManagement.service.ReplyService;
import com.flight.adminManagment.dto.ReplyRequest;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply")
    public ResponseEntity<String> sendReply(@RequestBody ReplyRequest replyRequest) throws Exception {
    	String message=replyService.sendReply(replyRequest);
        return ResponseEntity.ok(message);
    }
   
}
