package com.opencodely.codelyhexagonal.ascent.infrastructure.web;

import com.opencodely.codelyhexagonal.ascent.application.AddAscentApplicationService;
import com.opencodely.codelyhexagonal.shared.domain.IdProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AscentController {
  private final AddAscentApplicationService addAscentService;
  private final IdProvider<UUID> idProvider;

  @PostMapping(AscentUrl.BASE_V1)
  @ResponseStatus(HttpStatus.CREATED)
  public AddAscentResponse create(final @RequestBody @Valid AddAscentRequest request) {
    final var uuid = idProvider.provide();
    addAscentService.addAscent(uuid, UUID.fromString(request.climberId()), UUID.fromString(request.routeId()),
      request.proposedGrade(), request.ascensionDate());
    return AddAscentResponse.from(AscentUrl.BASE_V1, uuid);
  }
}
