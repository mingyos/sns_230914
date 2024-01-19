package com.sns.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.comment.entity.CommentEntity;
import com.sns.post.entity.PostEntity;



public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	
	
	public List<CommentEntity> findAllByOrderByIdDesc();
}
