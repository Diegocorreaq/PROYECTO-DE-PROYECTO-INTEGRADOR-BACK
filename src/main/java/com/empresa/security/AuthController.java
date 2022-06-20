package com.empresa.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entitySecurity.Usuario;
import com.empresa.service.UsuarioServiceImpl;
import com.empresa.util.AppSettings;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/url/auth")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    PasswordEncoder passwordEncoder;
	 @Autowired
	    private UsuarioServiceImpl usuarioService;
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertarUsuario(@RequestBody Usuario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			
			obj.setFechaRegistro(new Date());
			obj.setPassword(passwordEncoder.encode(obj.getPassword()));
			Usuario objSalida = usuarioService.insertaActualizaUsuario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario){
    	log.info(">>> login >>> " + loginUsuario.getLogin());
    	log.info(">>> login >>> " + loginUsuario.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getLogin(), loginUsuario.getPassword()));
        
        //Generacion del Token
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        log.info(">>> jwt >>> " + jwt);
        
        //Validaciones en la base de datos
        UsuarioPrincipal usuario = (UsuarioPrincipal)authentication.getPrincipal();
        log.info(">>> usuario >>> " + usuario.toString());
        
        JwtDto jwtDto = new JwtDto(jwt,  usuario.getUsername(),usuario.getNombreCompleto(), usuario.getAuthorities());
        log.info(">>> jwtDto >>> " + jwtDto.toString());
        
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }
}
