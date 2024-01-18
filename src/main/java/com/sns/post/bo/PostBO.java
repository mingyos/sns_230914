package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	// input: X   output: List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	public void addPost(int userId, String userLoginId, 
			String subject, String content, MultipartFile file) {
		
		String imagePath = null;
		
		// 업로드할 이미지가 있을 때 업로드
		if (file != null) {
			imagePath = fileManagerService.saveFile(userLoginId, file);
		}
		
		postMapper.insertPost(userId, subject, content, imagePath);
	}
}
