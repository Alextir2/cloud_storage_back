package alex.tir.cloud_storage_back.controller;

import alex.tir.cloud_storage_back.entity.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleController {

    @GetMapping("/id")
    public UserPrincipal testApi(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return userPrincipal;
    }
}
