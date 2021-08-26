package com.telecom.customerdatamanagement.Customer;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.customerdatamanagement.ExceptionHandling.SubscriberAlreadyExistsAuthenticationError;
import com.telecom.customerdatamanagement.ExceptionHandling.SubscriberNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SubscriberResource {

	@Autowired
	private SubscriberRepo subscriberRepo;
	
	@SuppressWarnings("unused")
	@PostMapping("/Subscriber")
	public void CreateSubscriber(@Valid @RequestBody Subscriber subscriber){
//		if(subscriberRepo.existsById(subscriber.getIMSI()))
//			throw new SubscriberAlreadyExistsAuthenticationError("Subscriber with same IMSI "+subscriber.getIMSI() + " exists");
		
			Subscriber new_subscriber = subscriberRepo.save(subscriber); 
			return;
	}
	
	@DeleteMapping("/Subscriber/{iMSI}")
	public void deleteSubscriberByIMSI(@PathVariable("iMSI") String iMSI) {
		subscriberRepo.deleteById(iMSI);
	}
	
//	@PostMapping("/Subscriber/list")
//	public void CreateSubscriberList(List<Subscriber> subscriber) throws SubscriberAlreadyExistsAuthenticationError{
//		boolean exists = false;
//		List<String> Existing_IMSI = new ArrayList<>();
//		for(Subscriber s:subscriber)
//		{
//			if(subscriberRepo.existsById(s.getIMSI()))
//			{
//				Existing_IMSI.add(s.getIMSI());
//				exists=true;
//			}
//		}
//		if(exists)
//		{
//			for(String str: Existing_IMSI)
//				throw new SubscriberAlreadyExistsAuthenticationError("Subscriber with same IMSI "+str + " exists");
//		}
//		List<Subscriber> new_subscribers = subscriberRepo.saveAll(subscriber);
//		return;
//	}
	
	@GetMapping("/Subscriber")
	public List<Subscriber> getAllSubscribers(){
		return subscriberRepo.findAll();
	}
	
	@GetMapping("/Subscriber/{iMSI}")
	public Optional<Subscriber> getSubscriber(@PathVariable("iMSI") String iMSI) {
		Optional<Subscriber> subscriber = subscriberRepo.findById(iMSI);
		if(!subscriber.isPresent())
			throw new SubscriberNotFoundException("IMSI "+iMSI);
		return subscriber;
	}
}

