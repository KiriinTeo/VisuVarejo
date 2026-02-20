package io.github.kiriinteo.visuvarejo.adapter.web.auth;

import io.github.kiriinteo.visuvarejo.adapter.web.auth.dto.RegisterRequest;
import io.github.kiriinteo.visuvarejo.adapter.web.auth.dto.RegisterResponse;
import io.github.kiriinteo.visuvarejo.application.identity.RegisterUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;

    public AuthController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ) {

        var result = registerUserUseCase.execute(
                new RegisterUserUseCase.RegisterCommand(
                        request.name(),
                        request.email(),
                        request.password(),
                        request.companyName(),
                        request.companyDocument()
                )
        );

        return ResponseEntity.ok(
                new RegisterResponse(
                        result.userId(),
                        result.companyId(),
                        result.email(),
                        "User registered successfully"
                )
        );
    }
}