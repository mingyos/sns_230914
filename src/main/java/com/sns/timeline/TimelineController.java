package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.comment.bo.CommentBO;
import com.sns.post.bo.PostBO;
import com.sns.timeline.bo.TimelineBO;
import com.sns.timeline.domain.CardView;

@Controller
public class TimelineController {

	@Autowired
	private PostBO postBO;
	@Autowired
	private CommentBO commentBO;
	@Autowired 
	private TimelineBO timelineBO;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		// 글 목록 조회
		//List<PostEntity> postList = postBO.getPostList();
		//List<CommentEntity> commentList = commentBO.getCommentList();
		List<CardView> cardList = timelineBO.generateCardView(); 
		//model.addAttribute("commentList", commentList);
		//model.addAttribute("postList", postList);
		model.addAttribute("cardList", cardList);
		model.addAttribute("viewName", "timeline/timeline");
		return "template/layout";
	}
}
