package com.example.dictsystem;

import com.example.dictsystem.controller.ZiController;
import com.example.dictsystem.dao.ZiMapper;
import com.example.dictsystem.dao.ZiXingMapper;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class DictSystemApplicationTests {

    @Autowired
    ZiMapper ziMapper;

    @Autowired
    ZiXingMapper ziXingMapper;

    @Autowired
    ZiService ziService;

    @Autowired
    ZiController ziController;

}
