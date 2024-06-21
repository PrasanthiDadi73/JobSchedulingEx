package jobscheduling.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jobscheduling.entity.User;
import jobscheduling.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Scheduled(fixedRate = 5000)
	public void add2DBJob() {
		User user = new User();
		user.setName("user" + new Random().nextInt(374483));
		userRepo.save(user);
		System.out.println("add service call in " + new Date().toString());
	}
	
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchDBJob() {
		List<User> users = userRepo.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " + users.size());
		log.info("users : {}", users);
	}
	
}
