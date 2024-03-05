package com.failtwoconnect.springbootmentalhealthv2.Controllers;

import com.failtwoconnect.springbootmentalhealthv2.exceptions.SaveFailedException;
import com.failtwoconnect.springbootmentalhealthv2.models.*;
import com.failtwoconnect.springbootmentalhealthv2.service.UserService;
import com.failtwoconnect.springbootmentalhealthv2.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final UserTypeService userTypeService;

    @Autowired
    public AdminController(UserService userService, UserTypeService userTypeService){
        this.userService = userService;
        this.userTypeService = userTypeService;
    }


    @GetMapping("/admin-view")
    public String adminView(Model model){
        List<User> users = userService.findAllByEnabled(true);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("users", users);
        for(User user : users) {
            model.addAttribute("userType", user.getUserType());
        }
        model.addAttribute("principal.authorities", auth.getAuthorities());
        return "admin/admin-view";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "admin/user-details";
    }

    @GetMapping("/add-user")
    public String addUser(Model model){
        User user = new User();
        Address address = new Address();
        EmergencyContact emergencyContact = new EmergencyContact();
        UserType userType = new UserType();
        List<UserType> userTypes = userTypeService.findAll();

        user.setAddress(address);
        user.setEmergencyContact(emergencyContact);
        user.setUserType(userType);

        model.addAttribute("user", user);
        model.addAttribute("userTypes", userTypes);
        return "admin/add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) throws SaveFailedException {
        UserType userType = userTypeService.findById(user.getUserType().getUser_type_id());
        user.setUserType(userType);
        userService.save(user);
        return "redirect:/admin/admin-view";
    }

    @GetMapping("/updateForm")
    public String formForUpdate(@RequestParam("id") int id, Model model){
        User user = userService.findById(id);
        List<UserType> userTypes = userTypeService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("userTypes", userTypes);
        return "admin/add-user";
    }

    @GetMapping("/all-clients")
    public String allClients(Model model){
        UserType userType = userTypeService.findById(1);
        List<User> users = userService.findAllByUserType(userType);

        model.addAttribute("users", users);
        return "admin/all-clients";
    }
    @GetMapping("/updateActive")
    public String updateActive (@RequestParam("id") int id,
                                @RequestParam("enabled") boolean enabled){
        userService.updateUserByEnabled(enabled,id);
        return "redirect:/admin/all-clients";
    }

    @GetMapping("/admin-graphs")
    public String showAdminGraphs(Model model){
        return "admin/admin-graphs";
    }

}
