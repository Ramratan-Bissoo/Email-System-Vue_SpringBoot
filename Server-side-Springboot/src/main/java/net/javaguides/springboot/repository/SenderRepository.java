package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import net.javaguides.springboot.model.SenderEntity;



@Repository
public interface SenderRepository extends JpaRepository<SenderEntity, Long> {

	@Query(value = "SELECT * FROM Sender WHERE S_id = ?1 ORDER BY id DESC", nativeQuery = true)
	List<SenderEntity> findSenderMail(String id);
	
	@Query(value = "SELECT * FROM Sender WHERE R_id = ?1 ORDER BY id DESC", nativeQuery = true)
	List<SenderEntity> findReceiverMail(String id);
}