package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import net.javaguides.springboot.exception.ResourceNotFoundException;

import net.javaguides.springboot.model.SenderEntity;
import net.javaguides.springboot.repository.SenderRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sender")
public class SenderController {
 
	@Autowired
 	private SenderRepository senderRepository;
	
	@PostMapping("/MailSend")
	public SenderEntity register(@Valid @RequestBody SenderEntity senderEntity)
	{
		return senderRepository.save(senderEntity);
	}
	
	@GetMapping("/getAllMail")
	public List<SenderEntity> getAllMail() 
	{
		return senderRepository.findAll();
	}
	 @DeleteMapping("/DeleteMail/{id}")
	 public Map<String, Boolean> deleteMail(@PathVariable(value = "id") Long mailId)
	         throws ResourceNotFoundException {
	        SenderEntity senderEntity = senderRepository.findById(mailId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + mailId));

	        senderRepository.delete(senderEntity);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	 @GetMapping("/getSentMail/{S_id}")
		public List<SenderEntity> getSentMail(@PathVariable("S_id") String Sender_id) {
			return senderRepository.findSenderMail(Sender_id);
		}
	 @GetMapping("/getInboxMail/{R_id}")
		public List<SenderEntity> getInboxMail(@PathVariable("R_id") String Sender_id) {
			return senderRepository.findReceiverMail(Sender_id);
		}
}
