package App.Rental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping
public class RentalController {

    private final CarService carService;
    private final ReserveService reserveService;

    private LocalDate beginDate;
    private LocalDate endDate;

    public RentalController(CarService carService,ReserveService reserveService) {
        this.carService = carService;
        this.reserveService = reserveService;
    }

    @GetMapping("/")
    public String mainpage() {
        return "Mainpage";
    }

    @PostMapping("/List")
    public ModelAndView listout(@RequestParam LocalDate localDatestart, @RequestParam LocalDate localDateend) {
        
        ModelAndView mav = new ModelAndView("ListPage");
        beginDate = localDatestart;
        endDate = localDateend;
		mav.addObject("cars", carService.getrequestedcars(localDatestart, localDateend));
        return mav;
    }

    @GetMapping("/Reserve")
    public ModelAndView reservepage(@RequestParam Long carid) {
        if (carid == null){
            return null;
        }
        ModelAndView mav = new ModelAndView("Reserve");
        ReserveClass newres = new ReserveClass();
        mav.addObject("newres", newres);
        newres.setBeginTime(beginDate);
        newres.setEndTime(endDate);
        newres.setCarId(carid);
        newres.setDays((int)ChronoUnit.DAYS.between(beginDate, endDate));
        newres.setPrice(newres.getDays()*(carService.findbyid(carid)).getDailyPrice());
        return mav;
    }

    @PostMapping("/Reservesave")
    public String saveReservation(@ModelAttribute ReserveClass newres) {
        CarClass reserved = carService.findbyid(newres.getCarId());
        reserved.setBeginTime(newres.getBeginTime());
        reserved.setEndTime(newres.getEndTime());
        reserved.setReserved(true);
        carService.updatecar(reserved);
        reserveService.addReserve(newres);
        return "redirect:/";
    }

    @GetMapping("/Admin/Newcar")
    public ModelAndView newcarpage() {
        ModelAndView mav = new ModelAndView("Newcar");
        CarClass newcar = new CarClass();
        mav.addObject("newcar", newcar);
        return mav;
    }

    @PostMapping("/Admin/savenewcar")
    public String saveNewCar(@ModelAttribute CarClass newcar) {
        carService.savecar(newcar);
        return "redirect:/Admin/Allcar";
    }

    @GetMapping("/Admin/Editcar")
    public ModelAndView editcarpage(@RequestParam Long carid) {
        ModelAndView mav = new ModelAndView("Editcar");
        CarClass editcar = carService.findbyid(carid);
        mav.addObject("editcar", editcar);
        return mav;
    }

    @PostMapping("/Admin/saveeditedcar")
    public String saveEditedCar(@ModelAttribute CarClass editcar) {
        carService.updatecar(editcar);
        return "redirect:/Admin/Allcar";
    }

    @GetMapping("/Admin/Allcar")
    public ModelAndView allcarpage() {
        ModelAndView mav = new ModelAndView("Allcar");
        mav.addObject("cars", carService.getallcars());
        mav.addObject("reservs", reserveService.getallReservation());
        return mav;
    }

    @GetMapping("/RestList")
    public List<CarClass> restgetcars(){
        return carService.getfreecars();
    }
}

