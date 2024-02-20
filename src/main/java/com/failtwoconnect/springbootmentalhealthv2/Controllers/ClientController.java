package com.failtwoconnect.springbootmentalhealthv2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    //Generate Numbers for the following areas.
    @GetMapping("/client-view")
    public String showClient(Model model){
        return "clients/client-view";
    }

    @GetMapping("/client-graphs")
    public String showGraphs(Model model){
        return "clients/client-graphs";
    }
}
