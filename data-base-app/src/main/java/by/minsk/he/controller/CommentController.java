package by.minsk.he.controller;

import by.minsk.he.dto.CommentDto;
import by.minsk.he.mapper.CommentMapper;
import by.minsk.he.models.CommentModel;
import by.minsk.he.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/database/comment")
public class CommentController {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping("/create")
    public CommentDto create(
            @RequestBody CommentDto commentDto
    ) {
        CommentModel comment = commentMapper.toCommentModel(commentDto);
        return commentMapper.toCommentDto(commentService.insertComment(comment));
    }

    @GetMapping("/find/{id}")
    public CommentDto findCommentById(
            @PathVariable(name = "id") UUID id
    ) {
        return commentMapper.toCommentDto(commentService.findCommentById(id));
    }

    @GetMapping("/find/all")
    public List<CommentDto> readAll() {
        return commentService.findAll()
                .stream()
                .map(commentMapper::toCommentDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update")
    public CommentDto update(
            @RequestBody CommentDto commentDto
    ) {
        CommentModel comment = commentMapper.toCommentModel(commentDto);
        return commentMapper.toCommentDto(commentService.updateComment(comment));
    }

    @DeleteMapping("/delete/{id}")
    public CommentDto delete(
            @PathVariable(name = "id") UUID id
    ) {
        return commentMapper.toCommentDto(commentService.deleteComment(id));
    }
}
