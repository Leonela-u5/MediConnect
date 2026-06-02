package com.mediconnect.controller;

import com.mediconnect.dto.LoginRequest;
import com.mediconnect.dto.UsuarioDTO;
import com.mediconnect.entity.Usuario;
import com.mediconnect.repository.UsuarioRepository;
import com.mediconnect.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(
            @RequestBody Usuario usuario) {

        Usuario nuevo = usuarioService.registrarUsuario(usuario);

        return ResponseEntity.ok(nuevo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo())
                .orElse(null);

        if (usuario == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "Usuario no encontrado"));
        }

        boolean valido = passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword());

        if (!valido) {
            return ResponseEntity.badRequest()
                    .body(Map.of("mensaje", "Contraseña incorrecta"));
        }

        // 🔥 CONVERTIR A DTO
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setCorreo(usuario.getCorreo());
        dto.setRol(usuario.getRol());

        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Login exitoso");
        response.put("usuario", dto);

        return ResponseEntity.ok(response);
    }
}