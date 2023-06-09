package com.opencodely.codelyhexagonal.ascent.domain;

import java.time.LocalDate;

public record AscensionDate(LocalDate date) {

  public AscensionDate {
    if (date.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("The ascension date can not be a future date");
    }
  }
}
