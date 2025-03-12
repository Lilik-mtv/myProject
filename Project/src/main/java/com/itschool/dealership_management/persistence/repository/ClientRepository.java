package main.java.com.itschool.dealership_management.persistence.repository;

import com.itschool.dealership_management.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
}
