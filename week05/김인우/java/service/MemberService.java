package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*회원가입*/
    public Long join(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        memberRepository.save(member);
        return member.getId();
    }


    /*전체 회원 조회*/
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /*Id로 조회*/
    public Optional<Member> findBylong(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
