package com.example.dictsystem.controller;

import com.example.dictsystem.dao.ZiMapper;
import com.example.dictsystem.entity.Zi;
import com.example.dictsystem.entity.ZiPre;
import com.example.dictsystem.entity.ZiXing;
import com.example.dictsystem.service.ZiService;
import com.example.dictsystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;
import java.time.LocalDate;
import java.util.*;

@Controller
public class ZiController {
    @Autowired
    private ZiService ziService;

    @ResponseBody
    @RequestMapping("/updatePhoto")
    public Object test(MultipartFile file, int ID){
        int i = 1;
        try {
            boolean jud = ziService.addPhoto(ID, file.getBytes());
            i = jud ? 0 : 1; //返回1代表上传未成功
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataVO<>(i, "", 0, null);
    }

    @ResponseBody
    @RequestMapping("/updateXingPhoto")
    public Object testXing(MultipartFile file, int ID, String xing){
        int i = 1;
        try {
            boolean jud = ziService.insertZiXing(ID, file.getBytes(), xing);
            i = jud ? 0 : 1; //返回1代表上传未成功
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataVO<>(i, "", 0, null);
    }

    @ResponseBody
    @RequestMapping("/getAllZi")
    public DataVO getAllZis(int page, int limit) {
        return ziService.getAllZi(page, limit);
    }

    @ResponseBody
    @RequestMapping("/getZiById")
    public Zi getZiById(int ID) {
        Zi zi = ziService.getZiById(ID);
//        byte[] zixing = zi.getZixing();
//        try {
//            ServletOutputStream sos = response.getOutputStream();
//            sos.write(zixing, 0, zixing.length);
//            sos.flush();
//            sos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        response.setContentType("image/*");
        return zi;
    }

    @RequestMapping("/getPicById")
    public void getPicById(int ID, HttpServletResponse response) {
        Zi zi = ziService.getZiById(ID);
        byte[] zixing = zi.getZixing();
        if (zixing == null) {
            return;
        }
        try {
            ServletOutputStream sos = response.getOutputStream();
            sos.write(zixing, 0, zixing.length);
            sos.flush();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //禁止图片缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/*");
    }

    @RequestMapping("/getPicsById")
    public void getPicsById(int ID, HttpServletResponse response) {
        final DataVO<ZiXing> ziXingDataVO = ziService.searchZiXing(ID);
        if (ziXingDataVO.getData() == null || ziXingDataVO.getData().size() == 0) {
            return;
        }
        byte[] zixing;
        try {
            ServletOutputStream sos = response.getOutputStream();
            for (int i = 0; i < ziXingDataVO.getData().size(); i++) {
                zixing = ziXingDataVO.getData().get(i).getZixing();
                sos.write(zixing);
            }
            sos.flush();
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //禁止图片缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/*");
    }

    @ResponseBody
    @RequestMapping("/getZiByYin")
    public DataVO<ZiPre> getZiByYin(String ziyin, int page, int limit) {

        return ziService.getZiByYin(ziyin, page, limit);
    }
}
