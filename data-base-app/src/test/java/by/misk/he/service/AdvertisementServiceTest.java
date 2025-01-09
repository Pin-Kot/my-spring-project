package by.misk.he.service;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.repository.AdvertisementRepository;
import by.minsk.he.services.AdvertisementService;
import by.misk.he.stubs.AdvertisementStubs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static by.misk.he.stubs.AdvertisementStubs.ADVERTISEMENT_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdvertisementServiceTest {

    @Mock
    private AdvertisementRepository advertisementRepository;

    @InjectMocks
    private AdvertisementService advertisementService;

    private final AdvertisementStubs advertisementStubsTest = new AdvertisementStubs();

    @Test
    void insertAdvertisement_then_return() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();

        when(advertisementRepository.save(
                        eq(testAdvertisement)
                )
        ).thenReturn(
                testAdvertisement
        );
        AdvertisementModel actualAdvertisement = advertisementService.insertAdvertisement(testAdvertisement);
        Assertions.assertEquals(actualAdvertisement, testAdvertisement);
        verify(advertisementRepository, new Times(1)).save(testAdvertisement);
    }

    @Test
    void insertAdvertisement_then_throws_exception() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();

        when(advertisementRepository.save(
                        eq(testAdvertisement)
                )
        ).thenThrow(new RuntimeException("") {
        });
        assertThrows(RuntimeException.class, () -> advertisementService.insertAdvertisement(testAdvertisement));
        verify(advertisementRepository, new Times(1)).save(testAdvertisement);
    }

    @Test
    void findAdvertisementById_then_return() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();
        testAdvertisement.setAdvertisementId(ADVERTISEMENT_ID);

        when(advertisementRepository.findById(
                        eq(ADVERTISEMENT_ID)
                )
        ).thenReturn(
                Optional.of(testAdvertisement)
        );
        AdvertisementModel actualAdvertisement = advertisementService.findAdvertisementById(ADVERTISEMENT_ID);
        Assertions.assertEquals(actualAdvertisement, testAdvertisement);
        verify(advertisementRepository, new Times(1)).findById(ADVERTISEMENT_ID);
    }

    @Test
    void findAdvertisementById_then_throws_exception() {

        when(advertisementRepository.findById(
                eq(ADVERTISEMENT_ID))
        ).thenThrow(new IllegalArgumentException("") {
        });
        assertThrows(IllegalArgumentException.class, () -> advertisementService.findAdvertisementById(ADVERTISEMENT_ID));
        verify(advertisementRepository, new Times(1)).findById(ADVERTISEMENT_ID);
    }

    @Test
    void findAll_then_return() {

        AdvertisementModel testAdvertisement1 = advertisementStubsTest.createAdvertisementStubs();
        AdvertisementModel testAdvertisement2 = advertisementStubsTest.createAdvertisementStubs();
        List<AdvertisementModel> testList = new ArrayList<>(Arrays.asList(testAdvertisement1, testAdvertisement2));

        when(advertisementRepository.findAllByOrderByAdvertStatusAscRankDesc()
        ).thenReturn(
                testList
        );
        List<AdvertisementModel> actualList = advertisementService.findAllByOrder();
        Assertions.assertIterableEquals(actualList, testList);
        verify(advertisementRepository, new Times(1)).findAllByOrderByAdvertStatusAscRankDesc();
    }

    @Test
    void updateAdvertisement_then_return() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();
        testAdvertisement.setAdvertisementId(ADVERTISEMENT_ID);

        when(advertisementRepository.existsById(
                testAdvertisement.getAdvertisementId())
        ).thenReturn(true);

        when(advertisementRepository.save(
                eq(testAdvertisement))
        ).thenReturn(
                testAdvertisement
        );
        AdvertisementModel actualAdvertisement = advertisementService.updateAdvertisement(testAdvertisement);
        Assertions.assertEquals(actualAdvertisement, testAdvertisement);

        verify(advertisementRepository, new Times(1)).existsById(ADVERTISEMENT_ID);
        verify(advertisementRepository, new Times(1)).save(testAdvertisement);
    }

    @Test
    void updateAdvertisement_then_throws_exception() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();
        testAdvertisement.setAdvertisementId(ADVERTISEMENT_ID);

        when(advertisementRepository.existsById(
               ADVERTISEMENT_ID)
        ).thenThrow(new NoSuchElementException("") {
        });
        assertThrows(NoSuchElementException.class, () -> advertisementService.updateAdvertisement(testAdvertisement));
        verify(advertisementRepository, new Times(1)).existsById(ADVERTISEMENT_ID);
        verify(advertisementRepository, new Times(0)).save(testAdvertisement);
    }

    @Test
    void deleteAdvertisement_then_return() {

        AdvertisementModel testAdvertisement = advertisementStubsTest.createAdvertisementStubs();
        testAdvertisement.setAdvertisementId(ADVERTISEMENT_ID);

        when(advertisementRepository.findById(
                        eq(ADVERTISEMENT_ID)
                )
        ).thenReturn(
                Optional.of(testAdvertisement)
        );
        doNothing().when(advertisementRepository).delete(testAdvertisement);

        AdvertisementModel actualAdvertisement = advertisementService.deleteAdvertisement(ADVERTISEMENT_ID);
        Assertions.assertEquals(actualAdvertisement, testAdvertisement);
        verify(advertisementRepository, new Times(1)).findById(ADVERTISEMENT_ID);
        verify(advertisementRepository, new Times(1)).delete(testAdvertisement);
    }
}
