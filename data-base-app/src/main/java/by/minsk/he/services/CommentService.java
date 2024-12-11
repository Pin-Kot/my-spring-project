package by.minsk.he.services;

import by.minsk.he.models.CommentModel;
import by.minsk.he.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentModel insertComment(CommentModel comment) {
        comment.setCreated(ZonedDateTime.now());
        return commentRepository.save(comment);
    }

    public CommentModel findCommentById(UUID id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Comment not found with id: " + id));
    }

    public List<CommentModel> findAll() {
        return commentRepository.findAll();
    }

    public CommentModel updateComment(CommentModel comment) {
        if (!commentRepository.existsById(comment.getCommentId())) {
            throw new NoSuchElementException("Comment not found with " + comment.getCommentId());
        }
        return commentRepository.save(comment);
    }

    public CommentModel deleteComment(UUID id){
        CommentModel comment = findCommentById(id);
        commentRepository.delete(comment);
        return comment;
    }
}
