package com.example.demo.controller;

import com.example.demo.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StackController {

    @Autowired
    private StackService stackService;

    @PostMapping("/operation")
    public String performOperation(@RequestParam String operation, @RequestParam(required = false) Integer item, Model model) {
        String message;
        switch (operation) {
            case "push":
                if (item != null) {
                    stackService.push(item);
                    message = item + " is pushed onto the stack.";
                } else {
                    message = "Please enter a number to push.";
                }
                break;
            case "pop":
                int poppedItem = stackService.pop();
                if (poppedItem != -999) {
                    message = poppedItem + " is popped from the stack.";
                } else {
                    message = "Stack underflow: The stack is empty.";
                }
                break;
            case "peek":
                int peekedItem = stackService.peek();
                if (peekedItem != -999) {
                    message = peekedItem + " is on the top of the stack.";
                } else {
                    message = "Stack underflow: The stack is empty.";
                }
                break;
            case "reset":
                stackService.reset();
                message = "Stack has been reset.";
                break;
            default:
                message = "Invalid operation.";
        }
        model.addAttribute("message", message);
        return "index";
    }
}
