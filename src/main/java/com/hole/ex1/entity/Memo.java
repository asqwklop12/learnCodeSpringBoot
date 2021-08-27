package com.hole.ex1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_memo")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long mno;

  @Column(length = 200, nullable = false)
  private String memoText;
}
