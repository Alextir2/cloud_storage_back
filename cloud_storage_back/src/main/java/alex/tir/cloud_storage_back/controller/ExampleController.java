package alex.tir.cloud_storage_back.controller;

import alex.tir.cloud_storage_back.entity.User;
import alex.tir.cloud_storage_back.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleController {

    private final UserRepository repository;
    @GetMapping("/id")
    public ResponseEntity<User> findByEmail(){
        String email = "alextir2@mail.ru";
        var user = repository.findByEmail(email).orElse(null);
        return ResponseEntity.ok(user);
    }
}
