package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.mapper.LikeMapper;


@Service
public class LikeBO {
	
	@Autowired
	private LikeMapper likeMapper;
	
	public int countLike(int postId) {
		return likeMapper.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
	// input : postId, userId     output : X
	public void likeToggle(int postId, int userId) {
		
		if(likeMapper.selectLikeCountByPostIdOrUserId(postId, null) > 0 ) {
			// like가 있으면
			//-- 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
			
		} else {
			// 없으면
			//-- 추가
			likeMapper.insertLike(postId, userId);
			
		}
	}
	
	// input : postId, userId(or null) output:boolean
	public boolean getLikeCountByPostIdUserId(int postId, Integer userId) {
		if(userId == null ) {
			// 비로그인이면 무조건 빈하트 => false
			return false;
		} else {
			// 로그인 0보다 크면(1이면) 채운다 , 그렇지 않으면 false
			if( likeMapper.selectLikeCountByPostIdOrUserId(postId, userId) > 0) {
				return true;
			} else {
				return false;
			}
		}
	}
}
