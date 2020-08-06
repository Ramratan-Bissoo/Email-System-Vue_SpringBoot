package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.ReceiverEntity;




@Repository
public interface ReceiverRepository extends JpaRepository<ReceiverEntity, Long> {

	@Query(value = "SELECT * FROM Receiver WHERE S_id = ?1 ORDER BY id DESC", nativeQuery = true)
	List<ReceiverEntity> findSenderMail(String id);
	
	@Query(value = "SELECT * FROM Receiver WHERE R_id = ?1 ORDER BY id DESC", nativeQuery = true)
	List<ReceiverEntity> findReceiverMail(String id);
}