package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.repositories.PartRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private OutsourcedPartService outsourcedPartService;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel) {
        Part part = new OutsourcedPart();
        theModel.addAttribute("outsourcedpart", part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("outsourcedpart", part);
        if (bindingResult.hasErrors()) {
            return "OutsourcedPartForm";
        } else {
            OutsourcedPartService repo = context.getBean(OutsourcedPartServiceImpl.class);
            OutsourcedPart op = repo.findById((int) part.getId());
            if (op != null) part.setProducts(op.getProducts());
            repo.save(part);
            return "confirmationaddpart";
        }

    }
    @PostMapping("/saveOutsourcedPart")
    public ModelAndView saveOutsourcedPart(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("OutsourcedPartForm", "formErrors", result.getAllErrors());
        }

        partRepository.save(part);
        return new ModelAndView("redirect:/parts");
    }
}
