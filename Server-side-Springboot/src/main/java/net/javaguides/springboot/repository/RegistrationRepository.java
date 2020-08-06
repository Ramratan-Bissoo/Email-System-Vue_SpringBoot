package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.RegistrationEntity;





@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {

	@Query(value = "SELECT * FROM Registration WHERE email_id = ?1 AND pass = ?2", nativeQuery = true)
	List<RegistrationEntity> findLoginId(String id, String pass);
	
	@Query(value = "SELECT * FROM Registration WHERE email_id = ?1", nativeQuery = true)
	List<RegistrationEntity> findAccountMail(String id);
}
