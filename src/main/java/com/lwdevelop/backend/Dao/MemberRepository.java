package com.lwdevelop.backend.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lwdevelop.backend.Model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}