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
import net.javaguides.springboot.model.ReceiverEntity;

import net.javaguides.springboot.repository.ReceiverRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/receiver")
public class ReceiverController {
 
	@Autowired
 	private ReceiverRepository receiverRepository;
	
	@PostMapping("/MailSend")
	public ReceiverEntity register(@Valid @RequestBody ReceiverEntity receiverEntity)
	{
		return receiverRepository.save(receiverEntity);
	}
	
	@GetMapping("/getAllMail")
	public List<ReceiverEntity> getAllMail() 
	{
		return receiverRepository.findAll();
	}
	
	 @DeleteMapping("/DeleteMail/{id}")
	 public Map<String, Boolean> deleteMail(@PathVariable(value = "id") Long mailId)
	         throws ResourceNotFoundException {
		 ReceiverEntity receiverEntity = receiverRepository.findById(mailId)
	       .orElseThrow(() -> new ResourceNotFoundException("Email not found for this id :: " + mailId));

	        receiverRepository.delete(receiverEntity);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	 @GetMapping("/getSentMail/{S_id}")
		public List<ReceiverEntity> getSentMail(@PathVariable("S_id") String id) {
			return receiverRepository.findSenderMail(id);
		}
	 @GetMapping("/getInboxMail/{R_id}")
		public List<ReceiverEntity> getInboxMail(@PathVariable("R_id") String id) {
			return receiverRepository.findReceiverMail(id);
		}
}
