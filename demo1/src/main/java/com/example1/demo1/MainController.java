package com.example1.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description This code serves the purpose of backend Api to
 *              1. Add a new dustbin to the database.
 *              2. Get all the data of dustbins from the database.
 *              3. Update the data of a dustbin of given Id.
 *              4. Last Api is to be called when the dustbin is filled, it returns the location of the nearest empty
 *                 dustbin within the specified area code or pin code.
 * @version 1
 * @Author Ashutosh Bhardwaj
 */

@Controller
@RequestMapping(path = "/dustbin")
public class MainController {


    @Autowired
    private DustbinRepository dustbinRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody Dustbin dustbin) {
        Optional<Dustbin> dustbin1 = dustbinRepository.findById(dustbin.getId());
        if (dustbin1.isPresent()) return "already present";
        else {
            dustbinRepository.save(dustbin);
            return "new dustbin added";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Dustbin> getAllDustbins() {
        // This returns a JSON or XML with the users
        return dustbinRepository.findAll();
    }

    @GetMapping("/update/{id}")
    public @ResponseBody
    String update(@PathVariable(name = "id") int id,
                  @RequestParam String fillStatus,
                  @RequestParam String fireStatus,
                  @RequestParam String decomStatus,
                  @RequestParam Long ultraSonic,
                  @RequestParam Long mq2){
        Dustbin source = dustbinRepository.findById(id).get();
        if (source == null) return "No dustbin found with this id";
        source.setFillStatus(fillStatus);
        source.setFireStatus(fireStatus);
        source.setDecomStatus(decomStatus);
        source.setUltraSonic(ultraSonic);
        source.setMq2(mq2);
        dustbinRepository.save(source);
        return "ok";
    }

    @GetMapping("/nearest/{id}/{areaCode}")
    public @ResponseBody
    String getNearest(@PathVariable(name = "id") int id,
                      @PathVariable(name = "areaCode") long areaCode) {
        Dustbin dustbin = dustbinRepository.findByIdAndAreaCode(id, areaCode);
        if (dustbin == null) return "No dustbin available";
        List<Dustbin> list = dustbinRepository.findAllByFillStatus("ok");
        if (list == null) return "No dustbin available";
        for (Dustbin d :
                list) {
            System.out.println(d.getId());
        }
        double x1 = dustbin.getLatitude();
        System.out.println(x1);
        double y1 = dustbin.getLongitude();
        System.out.println(y1);
        ArrayList<Double> arrayList = new ArrayList<>();
        for (Dustbin dust :
                list) {
            double x2 = dust.getLatitude();
            System.out.println(x2 + " ");
            double y2 = dust.getLongitude();
            System.out.println(y2 + " ");
            double distance = Math.pow(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2), 0.5);
            arrayList.add(distance);
            System.out.println(distance);
        }

        int index = 0, minIndex = 0;
        Double min = arrayList.get(0);
        for (Double dist :
                arrayList) {
            if (min > dist) {
                min = dist;
                minIndex = index;
            }
            index++;
        }

        Dustbin nearestDustbin = list.get(minIndex);

        return nearestDustbin.getAddress();
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
