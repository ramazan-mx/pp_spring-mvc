package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showCar(HttpServletRequest request, Model model) {
        String countParam = request.getParameter("count");
        if (countParam != null) {
            int count = Integer.parseInt(countParam);
            model.addAttribute("cars", carService.getRentedCars(count));
        } else {
            model.addAttribute("cars", carService.getMyAutoPark());
        }
        return "cars";
    }
}
