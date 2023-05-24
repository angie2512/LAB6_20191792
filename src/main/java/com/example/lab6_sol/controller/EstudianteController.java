package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Rol;
import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/lista")
    public String listaUsuarios(Model model){
        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }

    @GetMapping(value = "/formulario")
    public String vistaformulario(Model model){
        return "formularioestudiante";
    }

    @PostMapping(value = "/guardar" )
    public String guardarEstudiante(Usuario user, RedirectAttributes attr, @RequestParam("rolid") int rol){
        if (user.getId() == 0) {
            attr.addFlashAttribute("doc", "Creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Actualizado exitosamente");
        }

        user.setActivo(true);
        Rol rol1 = new Rol();
        user.getRol().getId();
        usuarioRepository.save(user);
        return "redirect:/estudiante/lista";
    }


}
