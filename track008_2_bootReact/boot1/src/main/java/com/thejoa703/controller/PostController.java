package com.thejoa703.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name="Post Api", description="Post 관련 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class PostController {
	
	private final PostService postService;
	
	@Operation(summary="게시글 작성" , description="특정유저 ID와 내용을 받아 게시글을 작성합니다.")
	@PostMapping
	@Transactional
	public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto requestDto){
		Post createdPost = postService.createPost(requestDto.getUserId(),requestDto.getContent());
		return ResponseEntity.ok(new PostResponseDto(createdPost)); //200
		
	}
	
	@Operation(summary="전체 게시글", description = "전체 게시글 조회")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getAllPosts(){
		List<Post> posts = postService.getAllPosts();
		List<PostResponseDto> lists = posts.stream()
											.map(PostResponseDto::new)
											.collect(Collectors.toList());
		return ResponseEntity.ok(lists);
		
	}
	
	@Operation(summary="단건게시", description = "단건게시")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id){
		Post post = postService.getPostById(id);
		return ResponseEntity.ok(new PostResponseDto(post));
	}
	
	@Operation(summary="게시글 수정", description = "게시글 수정시")
	@PutMapping("/{id}")
	public ResponseEntity<PostResponseDto> updatePost(@PathVariable("id") Long id,@RequestBody PostRequestDto requestDto){
		Post post = postService.updatePost(id,requestDto.getContent());
		return ResponseEntity.ok(new PostResponseDto(post));
	}
	
	@Operation(summary="게시글 삭제", description = "게시글 삭제시")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable("id") Long id){
		postService.deletePost(id);
		return ResponseEntity.ok(id);
	}

}
