package com.hole.ex1.repository;

import com.hole.ex1.entity.Memo;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}