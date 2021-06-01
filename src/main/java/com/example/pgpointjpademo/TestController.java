package com.example.pgpointjpademo;

import com.example.pgpointjpademo.custom_type.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {


    private final TestObjectRepository tcObjectRepository;

    @Autowired
    public TestController(TestObjectRepository tcObjectRepository) {
        this.tcObjectRepository = tcObjectRepository;
    }

    @GetMapping(path = "/test")
    public void test() {
        List<TestObject> objects = tcObjectRepository.findAll();
        for (TestObject object : objects) {
            System.out.println(object.toString());
        }
        int index = 1;
        for (TestObject object : objects) {
            object.setCoord(new Point(2.22f * index, 3.33f * index));
            tcObjectRepository.save(object);
            index++;
        }
        objects = tcObjectRepository.findAll();
        for (TestObject object : objects) {
            System.out.println(object.toString());
        }
    }
}
