package com.opencodely.codelyhexagonal.ascent.domain;

import com.opencodely.codelyhexagonal.shared.domain.Validatable;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AscentId(@NotNull UUID id) implements Validatable {

  public AscentId(UUID id) {
    this.id = id;
    validate();
  }

  @Override
  public String toString() {
    return id.toString();
  }

}

