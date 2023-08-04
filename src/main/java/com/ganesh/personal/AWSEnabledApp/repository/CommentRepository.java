package com.ganesh.personal.AWSEnabledApp.repository;

import com.ganesh.personal.AWSEnabledApp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
