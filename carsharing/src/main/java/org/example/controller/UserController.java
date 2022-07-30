package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.request.dto.UserDto;
import org.example.request.vo.UserVO;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity userSignUp(@RequestBody UserVO userVO) {
        UserDto userDto = modelMapper.map(userVO, UserDto.class);
        userService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(userDto);
    }

    @PostMapping("/ouath/login")
    public ResponseEntity userLogin(@RequestBody UserVO userVO) {
        try{
            ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8080/service-carsharing/login", userVO,
                String.class);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
    }


}
