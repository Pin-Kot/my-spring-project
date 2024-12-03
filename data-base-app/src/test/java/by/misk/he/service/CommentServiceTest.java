package by.misk.he.service;

import by.minsk.he.models.CommentModel;
import by.minsk.he.repository.CommentRepository;
import by.minsk.he.services.CommentService;
import by.misk.he.stubs.CommentStubs;
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

import static by.misk.he.stubs.CommentStubs.COMMENT_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

    @Mock
    private CommentRepository comentRepository;

    @InjectMocks
    private CommentService commentService;

    private final CommentStubs commentStubsTest = new CommentStubs();

    @Test
    void insertComment_then_return() {

        CommentModel testComment = commentStubsTest.createCommentStubs();

        when(comentRepository.save(
                        eq(testComment)
                )
        ).thenReturn(
                testComment
        );
        CommentModel actualComment = commentService.insertComment(testComment);
        Assertions.assertEquals(actualComment, testComment);
        verify(comentRepository, new Times(1)).save(testComment);
    }

    @Test
    void insertCar_then_throws_exception() {

        CommentModel testComment = commentStubsTest.createCommentStubs();

        when(comentRepository.save(
                        eq(testComment)
                )
        ).thenThrow(new RuntimeException("") {
        });
        assertThrows(RuntimeException.class, () -> commentService.insertComment(testComment));
        verify(comentRepository, new Times(1)).save(testComment);
    }

    @Test
    void findCarById_then_return() {

        CommentModel testComment = commentStubsTest.createCommentStubs();
        testComment.setCommentId(COMMENT_ID);

        when(comentRepository.findById(
                        eq(COMMENT_ID)
                )
        ).thenReturn(
                Optional.of(testComment)
        );
        CommentModel actualComment = commentService.findCommentById(COMMENT_ID);
        Assertions.assertEquals(actualComment, testComment);
        verify(comentRepository, new Times(1)).findById(COMMENT_ID);
    }

    @Test
    void findCarById_then_throws_exception() {

        when(comentRepository.findById(
                eq(COMMENT_ID))
        ).thenThrow(new IllegalArgumentException("") {
        });
        assertThrows(IllegalArgumentException.class, () -> commentService.findCommentById(COMMENT_ID));
        verify(comentRepository, new Times(1)).findById(COMMENT_ID);
    }

    @Test
    void findAll_then_return() {

        CommentModel testComment1 = commentStubsTest.createCommentStubs();
        CommentModel testComment2 = commentStubsTest.createCommentStubs();
        List<CommentModel> testList = new ArrayList<>(Arrays.asList(testComment1, testComment2));

        when(comentRepository.findAll()
        ).thenReturn(
                testList
        );
        List<CommentModel> actualList = commentService.findAll();
        Assertions.assertIterableEquals(actualList, testList);
        verify(comentRepository, new Times(1)).findAll();
    }

    @Test
    void updateCar_then_return() {

        CommentModel testComment = commentStubsTest.createCommentStubs();
        testComment.setCommentId(COMMENT_ID);

        when(comentRepository.existsById(
                testComment.getCommentId())
        ).thenReturn(true);

        when(comentRepository.save(
                eq(testComment))
        ).thenReturn(
                testComment
        );
        CommentModel actualComment = commentService.updateComment(testComment);
        Assertions.assertEquals(actualComment, testComment);

        verify(comentRepository, new Times(1)).existsById(COMMENT_ID);
        verify(comentRepository, new Times(1)).save(testComment);
    }

    @Test
    void updateCar_then_throws_exception() {

        CommentModel testComment = commentStubsTest.createCommentStubs();
        testComment.setCommentId(COMMENT_ID);

        when(comentRepository.existsById(
               COMMENT_ID)
        ).thenThrow(new NoSuchElementException("") {
        });
        assertThrows(NoSuchElementException.class, () -> commentService.updateComment(testComment));
        verify(comentRepository, new Times(1)).existsById(COMMENT_ID);
        verify(comentRepository, new Times(0)).save(testComment);
    }

    @Test
    void deleteCar_then_return() {

        CommentModel testComment = commentStubsTest.createCommentStubs();
        testComment.setCommentId(COMMENT_ID);

        when(comentRepository.findById(
                        eq(COMMENT_ID)
                )
        ).thenReturn(
                Optional.of(testComment)
        );
        doNothing().when(comentRepository).delete(testComment);

        CommentModel actualComment = commentService.deleteComment(COMMENT_ID);
        Assertions.assertEquals(actualComment, testComment);
        verify(comentRepository, new Times(1)).findById(COMMENT_ID);
        verify(comentRepository, new Times(1)).delete(testComment);
    }
}
