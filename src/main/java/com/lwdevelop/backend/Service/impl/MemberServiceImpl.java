package com.lwdevelop.backend.Service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwdevelop.backend.Dao.MemberRepository;
import com.lwdevelop.backend.Model.Member;
import com.lwdevelop.backend.Service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member saveMember(Member member) {
        member.setMid(UUID.randomUUID().toString().replaceAll("-", ""));
        member.setCreateTime(new Date());
        memberRepository.save(member);
        return member;
    }

}