package hello.springmvc12.basic.requestmapping;

import hello.springmvc12.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class MappingClassController {

    @GetMapping
    public String users() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post users";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamV3(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) { // int는 null이 들어갈 수 없고 Integer은 null이 들어갈 수 있따.
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData data) {

        log.info("hello data = {}, {}", data.getUsername(), data.getAge());
        return "ok";
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(@RequestBody String messageBody) {
        log.info("messageBody = {}", messageBody);

        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) {
        log.info("messageBody = {}", messageBody);

        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public HelloData requestBodyJsonV4(@RequestBody HelloData data) {
        log.info("messageBody = {}", data);

        return data;
    }
}
