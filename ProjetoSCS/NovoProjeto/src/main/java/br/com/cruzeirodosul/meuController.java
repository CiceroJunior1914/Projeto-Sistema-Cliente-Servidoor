package br.com.cruzeirodosul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class meuController {

@Autowired
 private Config config;


    @GetMapping("/")
    public String principal(){
        return "principal";
    }


    @GetMapping("media")
    public String medi(@RequestParam(name = "var1", required = false) Float var1, @RequestParam(name = "var2",required = false)Float var2, Model model){
        Float resultado = config.calcMedia(var1, var2);
        model.addAttribute("resultado", resultado);
        return "raiz";
    }


@GetMapping("/imc")
    public String pag(@RequestParam (name = "var1", required = false) Double var1, @RequestParam(name = "var2") Double var2, Model model) {
    Double resultado = config.calcImc(var1, var2);
    model.addAttribute("resultado", resultado);
    return "imc";

 }

@GetMapping("/raiz{var1}")
public String sal(@RequestParam (name = "var1", required = false) Double var1, Model model){
        Double resultado = config.calcRaiz(var1);
        model.addAttribute("resultado", resultado);
        return "raiz";
}

}

