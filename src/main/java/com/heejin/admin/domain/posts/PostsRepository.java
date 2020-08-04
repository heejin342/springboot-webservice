package com.heejin.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//<Entity class, PK type> -> 이걸 상속하면 기본CRUD 메소드가 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") List<Posts> findAllDesc();
}
