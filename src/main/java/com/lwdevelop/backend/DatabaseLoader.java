package com.lwdevelop.backend;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lwdevelop.backend.Dao.MemberRepository;
//import com.lwdevelop.backend.Model.Member;
import com.lwdevelop.backend.Model.Member;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {

    //Member member = new Member( "michael4@gmail.com", "abc123453", "michael", "jordan");
    //member.setMid(UUID.randomUUID().toString().replaceAll("-", ""));
    //memberRepository.save(member);

    }
}