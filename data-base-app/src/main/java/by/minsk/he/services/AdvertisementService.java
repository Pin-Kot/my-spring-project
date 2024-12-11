package by.minsk.he.services;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementModel insertAdvertisement(AdvertisementModel advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public AdvertisementModel findAdvertisementById(UUID id) {
        return advertisementRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Advertisement not found with id: " + id));
    }

    public List<AdvertisementModel> findAll() {
        return advertisementRepository.findAll();
    }


    public AdvertisementModel updateAdvertisement(AdvertisementModel advertisement) {
        if (!advertisementRepository.existsById(advertisement.getAdvertisementId())) {
            throw new NoSuchElementException("Advertisement not found with " + advertisement.getAdvertisementId());
        }
        return advertisementRepository.save(advertisement);
    }

    public AdvertisementModel deleteAdvertisement(UUID id){
        AdvertisementModel advertisement = findAdvertisementById(id);
        advertisementRepository.delete(advertisement);
        return advertisement;
    }
}
