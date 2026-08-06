package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thejoa703.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow,Long>{ // Entity , PK (★기본키)
	
	// 팔로우 단건조회 - 팔로워 / 팔로잉 findBy ※ Optional <Follow>
	//Optional<Follow> findByFollower_IdAndFollow_Id(Long followerId,Long followeeId);
	Optional<Follow> findByFollower_IdAndFollowee_Id(Long followerId, Long followeeId);
	// 팔로잉 목록 조회 findBy → AppUser(엔티티) follower(필드) id 찾기 ※ List<Follow>
	// 1) 쿼리 1개 : findByFollower_Id(1L) 팔로잉 목록 10명   1
	// 2) 추가쿼리 10개: 각각의 정보를 가져올려면 쿼리 10번더       N   (11번의 쿼리) → 11번의 쿼리실행 x 
	// 3) @EntityGraph(attributePaths= {"followee"}) 쿼리 실행할때 Followee 데이터까지 한꺼번에 조회
	@EntityGraph(attributePaths= {"followee"}) 
	List<Follow> findByFollower_Id(Long followerId);
	// 팔로워 목록 조회 findBy → AppUser(엔티티) followee(필드) id 찾기 ※ List<Follow>
	List<Follow> findByFollowee_id(Long followeeId);
	// 팔로잉 수 집계  countBy → AppUser(엔티티) follower(필드) id 찾기 ※ long
	long countByFollower_id(Long followerId);
	// 팔로워 수 집계  countBy → AppUser(엔티티) followee(필드) id 찾기 ※ long
	long countByFollowee_id(Long followeeId);
}
