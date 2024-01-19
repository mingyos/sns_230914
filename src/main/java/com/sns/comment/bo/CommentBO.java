package com.sns.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.comment.entity.CommentEntity;
import com.sns.comment.repository.CommentRepository;
import com.sns.common.FileManagerService;
import com.sns.post.entity.PostEntity;

@Service
public class CommentBO {
		@Autowired
		private FileManagerService fileManagerService;
		
		@Autowired
		private CommentRepository commentRepository;
		
		public List<CommentEntity> getCommentList() {
			return commentRepository.findAllByOrderByIdDesc();
		}
		
		public CommentEntity addComment(int userId, String userLoginId, 
			String content, int postId) {
		
		
		return commentRepository.save(CommentEntity.builder()
				.userId(userId)
				.content(content)
				.postId(postId)
				.build());
	}
}
