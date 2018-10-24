package io.pivotal.demos.directoryui;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class DirectoryController {

    private RestTemplate template = new RestTemplate();	// //<1>
    private final DirectoryProperties props;

    @GetMapping		// //<2>
    public ModelAndView home(){
        Iterable<Person> people = this.template.getForObject(props.getServiceUri(),Iterable.class);  // //<3>

        Map<String,Object> model = new HashMap<String,Object>();
        model.put("people",people);

        return new ModelAndView("views/home",model);	// //<4>
    }

    @PostMapping		// //<5>
    public Person post(@RequestBody Person person){
        Person result = this.template.postForObject(props.getServiceUri(),person,Person.class);	 // //<6>
        return result;
    }


    @ExceptionHandler({ Exception.class })			// //<7>
    public  ModelAndView handleException() {
        return new ModelAndView("views/home",new HashMap<String,Object>());
    }

}
