package by.minsk.he.repository;

import by.minsk.he.models.AdvertisementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, UUID> {
}
