package org.example.demo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * database for the {@link OnlineDelivery}
 */
@Repository
public interface RepositoryOnlineDelivery extends JpaRepository<OnlineDelivery, Long> {
}
