package org.example.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.request.vo.UserVO;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
class UserControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                                      .addFilters(new CharacterEncodingFilter("UTF-8", true))
                                      .apply(documentationConfiguration(restDocumentation))
                                      .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()),
                                          preprocessResponse(prettyPrint())))
                                      .build();

        User user = User.builder()
                        .email("test@test.co.kr")
                        .password("1234")
                        .build();

        userRepository.save(user);
    }


    @Test
    void userSignUp() throws Exception {
        UserVO user = UserVO.builder()
                          .email("test@test.co.kr")
                          .password("1234")
                          .build();
        String content = objectMapper.writeValueAsString(user);
        this.mockMvc.perform(post("/signup").content(content)
                                            .accept(MEDIA_TYPE_JSON_UTF8)
                                            .contentType(MEDIA_TYPE_JSON_UTF8))
                    .andExpect(status().isCreated())
                    .andDo(document("{method-name}", preprocessRequest(prettyPrint()),
                            preprocessResponse(prettyPrint()),
                            PayloadDocumentation.requestFields(
                                PayloadDocumentation.fieldWithPath("email")
                                                    .type(JsonFieldType.STRING)
                                                    .description("회원가입 이메일"),
                                PayloadDocumentation.fieldWithPath("password")
                                                    .type(JsonFieldType.STRING)
                                                    .description("비밀번호")
                                ),
                            PayloadDocumentation.responseFields(
                                PayloadDocumentation.fieldWithPath("email")
                                                    .description("회원가입 이메일")
                                                    .type(JsonFieldType.STRING),
                                PayloadDocumentation.fieldWithPath("password")
                                                    .description("비밀번호")
                                                    .type(JsonFieldType.STRING)
                            )
                        )
                    )
                    .andDo(print());
    }

}
