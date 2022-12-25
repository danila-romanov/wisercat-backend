package com.wisercat.bestfriend.controller.pets_controller.get_use_case;

import com.wisercat.bestfriend.dto.pet.PetDto;
import com.wisercat.bestfriend.exception.InvalidParameterException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetsGetController {
    private final PetsGetService service;
    @GetMapping("/pets/{id}")
    @Secured("ROLE_ADMIN")
    public PetDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/pets")
    @Secured("ROLE_ADMIN")
    public List<PetDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{username}/pets/{id}")
    public PetDto getPetByIdByUsername(@PathVariable String username, @PathVariable Long id) {
        return service.getPetByIdByUsername(username, id);
    }

    @GetMapping("/{username}/pets")
    public List<PetDto> getUserPetsByPages(@PathVariable String username,
                                           Pageable pageable) {
        return service.getUserPetsByPages(username, pageable);
    }
}
