package com.hole.ex1.repository;

import com.hole.ex1.entity.Memo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

  List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
}
