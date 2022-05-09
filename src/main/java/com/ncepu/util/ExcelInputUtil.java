package com.ncepu.util;

import com.ncepu.bean.ST_Score;
import com.ncepu.controller.TeacherFunctionController;
import com.ncepu.dao.TeacherDao;
import com.ncepu.service.TeacherService;
import com.ncepu.service.impl.TeacherServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelInputUtil {

    private TeacherService teacherService = new TeacherServiceImpl();

    public List<ST_Score>  excelInputMain(File file){
        String filePath = null;
        try {
            InputStream is = new FileInputStream(file);
            filePath = saveExcel(is, file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return excelLoad(filePath);
    }

    private String saveExcel(InputStream inputStream, String fileName) {
        OutputStream os = null;
        String filePath = null;
        try {
            String path = "D:\\testFile\\";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            filePath = tempFile.getPath() + File.separator + fileName;
            System.out.println("filePath:"+filePath);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

    private List<ST_Score> excelLoad(String xlsPath){
        List<ST_Score> list = new ArrayList<>();
        FileInputStream fis = null;
        System.out.println(xlsPath);

        try {
            fis = new FileInputStream(xlsPath);
            //获取Excel文件
            Workbook wb = new XSSFWorkbook(fis);
            //获取第一个表单
            Sheet s = wb.getSheetAt(0);
            //对表单内每一行进行迭代
            for (Row r : s){
                if (r.getRowNum() == 0)
                    continue;
                ST_Score score = new ST_Score();
                score.setT_No((int)r.getCell(0).getNumericCellValue());
                score.setS_Nm((int)r.getCell(1).getNumericCellValue());
                score.setC_NO((int)r.getCell(2).getNumericCellValue());
                score.setS_Ncor((int)r.getCell(3).getNumericCellValue());
                score.setS_Mid((int)r.getCell(4).getNumericCellValue());
                score.setS_Fs((int)r.getCell(5).getNumericCellValue());
                score.setS_TO((int)r.getCell(6).getNumericCellValue());
                list.add(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        for (ST_Score score : list){
//            System.out.println(score.getT_No());
//            teacherService.insertOneData(
//                    score.getT_No(),
//                    score.getS_Nm(),
//                    score.getC_NO(),
//                    score.getS_Ncor(),
//                    score.getS_Mid(),
//                    score.getS_Fs(),
//                    score.getS_TO());
//        }
        return list;
    }
}
