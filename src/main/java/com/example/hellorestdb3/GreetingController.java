package com.example.hellorestdb3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GreetingController {

    @Autowired //we will cover this later
    private GreetingDAO greetingDao;

    @RequestMapping(value = "/createGreetingDB", method = RequestMethod.POST)
    public Greeting createGreeting(@RequestBody String name) throws IOException {
        Greeting newGreeting = new Greeting(name);
        greetingDao.create(newGreeting);
        return newGreeting;
    }

    @RequestMapping(value = "/getGreetingDB/{id}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable("id") int id) throws IOException {
        return greetingDao.getById(id);
    }

    @RequestMapping(value = "/updateGreetingDB/", method = RequestMethod.PUT)
    public Greeting updateGreetingDB(@RequestBody Greeting g) throws Exception {
        greetingDao.update(g);
        return g;
    }

    @RequestMapping(value = "/deleteGreetingDB/{id}", method = RequestMethod.DELETE)
    public void deleteGreetingDB(@PathVariable int id) throws Exception {
        greetingDao.delete(id);
    }

    @RequestMapping(value = "/getGreetingCount", method = RequestMethod.GET)
    public int getGreetingCount() throws Exception {
        return greetingDao.getCount();
    }

}
