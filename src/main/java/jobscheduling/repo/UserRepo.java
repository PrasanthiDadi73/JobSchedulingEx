package jobscheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jobscheduling.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
