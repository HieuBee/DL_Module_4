package com.exercise3.controller;

import com.exercise3.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/declaration")
public class DeclarationController {
    @ModelAttribute("symptom")
    public String[] getSymptom(){
        return new String[]{"Sot", "Ho", "Kho tho ", "Dau hong", "Non/Buon non", "Tieu chay", "Xuat huyet ngoai da", "Noi ban ngoai da"};
    }

    @ModelAttribute("sex")
    public String[] getSex(){
        return new String[]{"Nam", "Nu"};
    }

    @ModelAttribute("vehicle")
    public String[] getVehicle(){
        return new String[]{"Tau bay", "Tau thuyen", "O to", "Khac"};
    }

    @ModelAttribute("nationality")
    public String[] getNationality(){
        return new String[]{"Viet Nam", "My", "Phap", "Trung Quoc", "Han Quoc"};
    }

    @ModelAttribute("history")
    public String[] getHistory(){
        return new String[]{"Den trai chan nuoi/cho buon ban dong vat song/co so giet mo dong vat/tiep xuc dong vat", "Tiep xuc gan (<2m) voi nguoi viem duong ho hap do nCoV"};
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("declaration", new Declaration());
        return "declaration";
    }
}
