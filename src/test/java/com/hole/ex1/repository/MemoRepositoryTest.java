package com.hole.ex1.repository;

import com.hole.ex1.entity.Memo;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class MemoRepositoryTest {

  @Autowired
  MemoRepository memoRepository;

  @Test
  void testClass() {
    System.out.println(memoRepository.getClass().getName());
  }

  @Test
  void testInsetDummies() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Memo memo = Memo.builder().memoText("Sample..." + i).build();
      memoRepository.save(memo);
    });
  }

  @Test
  void testSelect() {
    Long mno = 100L;
    Optional<Memo> result = memoRepository.findById(mno);

    System.out.println("==========================================");

    if (result.isPresent()) {
      Memo memo = result.get();
      System.out.println(memo);
    }
  }

  @Test
  @Transactional
  void testSelect2() {
    Long mno = 100L;
    Memo result = memoRepository.getOne(mno);

    System.out.println("==========================================");
    System.out.println(result);

  }

  @Test
  void testUpdate() {
    Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
    System.out.println(memoRepository.save(memo));
  }

  @Test
  void testDelete() {
    memoRepository.deleteById(100L);
  }

  @Test
  void testPageDefault() {
    PageRequest pageable = PageRequest.of(0, 10);
    Page<Memo> result = memoRepository.findAll(pageable);
    System.out.println(result);
  }

  @Test
  void testSort() {
    Sort sort1 = Sort.by("mno").descending();

    PageRequest pageable = PageRequest.of(0, 10, sort1);

    Page<Memo> result = memoRepository.findAll(pageable);

    result.get().forEach(memo -> {
      System.out.println(memo);
    });
  }

  @Test
  void testQueryMethods() {

    List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
    for (Memo memo : list) {
      System.out.println(memo);
    }
  }


}