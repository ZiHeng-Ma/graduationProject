package com.ncepu.controller;

import com.ncepu.bean.ST_Intrest;
import com.ncepu.bean.ST_Score;
import com.ncepu.bean.TE_Teacher;
import com.ncepu.core.AlgorithmMain;
import com.ncepu.service.IntrestService;
import com.ncepu.service.TeacherService;
import com.ncepu.util.ExcelInputUtil;
import com.ncepu.util.ScoreStatistic;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/function")
public class TeacherFunctionController {
    
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private IntrestService intrestService;

    @RequestMapping("/dataInAndOut")
    public String DataInAndOut(){
        return "teacher/dataInAndOut.jsp";
    }

    @RequestMapping("/scoreManager")
    public String ScoreManager(HttpServletRequest request, Model model){
        getScore(request, model);
        return "teacher/scoreManager.jsp";
    }

    @RequestMapping("/scoreSearch")
    public String ScoreSearch(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        getScore(request,model);
        return "teacher/scoreSearch.jsp";
    }

    @RequestMapping("/scoreMiner")
    public String ScoreMiner(){
        return "teacher/scoreMiner.jsp";
    }

    @RequestMapping("/scoreStatistic")
    public String ScoreStatistic(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        List<ST_Score> te_teachers = teacherService.selectScoreByTno(teacher.getT_No());
        ScoreStatistic ss = new ScoreStatistic();
        Map<String, Integer> result = ss.scoreStatisticUtil(te_teachers);
        model.addAttribute("total",result.get("total"));
        model.addAttribute("fail",result.get("fail"));
        model.addAttribute("pass",result.get("pass"));
        model.addAttribute("rate",result.get("rate"));
        return "teacher/scoreStatistic.jsp";
    }

    @RequestMapping("/updateOneData")
    public String updateOneData(HttpServletRequest request, Model model, @RequestParam String c_no){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        request.getSession().setAttribute("c_no",c_no);
        return "teacher/scoreManger_updateOneData.jsp";
    }

    @RequestMapping("/submitOneData")
    public String submitOneData(Model model,HttpServletRequest request,
                                String Input1,String Input2,String Input3,String Input4,String Input5){
        TE_Teacher teacher = (TE_Teacher)request.getSession().getAttribute("teacher");
        int c_no = Integer.parseInt((String) request.getSession().getAttribute("c_no"));
        System.out.println(c_no + " " + Input1 + " " + Input2 + " " + Input3 + " " + Input4);
        int S_Ncor = Integer.parseInt(Input1);
        int S_Mid = Integer.parseInt(Input2);
        int S_Fs = Integer.parseInt(Input3);
        int S_TO = Integer.parseInt(Input4);
        int S_Nm = Integer.parseInt(Input5);
        teacherService.updateOneData(teacher.getT_No(),S_Nm,c_no,S_Ncor,S_Mid,S_Fs,S_TO);
        model.addAttribute("update","修改成功");
        return "forward:scoreManager";
    }

    @RequestMapping("/deleteOneData")
    public String deleteOneData(Model model, HttpServletRequest request, @RequestParam String c_no){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        teacherService.deleteOneData(teacher.getT_No(),Integer.parseInt(c_no));
        model.addAttribute("update","删除成功");
        return "forward:scoreManager";
    }

    @RequestMapping("/addOneData")
    public String addOneData(HttpServletRequest request,Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        return "teacher/scoreManager_add.jsp";
    }

    @RequestMapping("/insertOneData")
    public String insertOneData(Model model,HttpServletRequest request,
                                String Input5,String Input1,String Input2,String Input3,String Input4,String Input6){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        int T_No = teacher.getT_No();
        int S_Nm = Integer.parseInt(Input5);
        int C_NO = Integer.parseInt(Input6);
        int S_Ncor = Integer.parseInt(Input1);
        int S_Mid = Integer.parseInt(Input2);
        int S_Fs = Integer.parseInt(Input3);
        int S_TO = Integer.parseInt(Input4);
        System.out.println(T_No + " " + S_Nm + " " + C_NO + " " + S_Ncor + " " + S_Mid + " " + S_Fs + " " + S_TO);
        teacherService.insertOneData(T_No,S_Nm,C_NO,S_Ncor,S_Mid,S_Fs,S_TO);
        model.addAttribute("update","添加成功");
        return "forward:scoreManager";
    }

    @RequestMapping("/searchByCno")
    public String searchByCno(HttpServletRequest request,Model model,String cno){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        int C_NO = Integer.parseInt(cno);
        List<ST_Score> scores = teacherService.selectScoreByCno(C_NO);
        model.addAttribute("scoreList",scores);
        return "teacher/scoreSearch.jsp";
    }

    @RequestMapping("/toPageScoreMinerMain")
    public String toPageScoreMinerMain(HttpServletRequest request,Model model,
                                       String Input1,String Input2){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());

        List<ST_Score> scores = teacherService.selectScoreByTno(teacher.getT_No());
        Map<ST_Score,ST_Intrest> result = new HashMap<>();
        for (int i = 0; i < scores.size(); i++) {
            ST_Intrest intrestBySnm = intrestService.getIntrestBySnm(scores.get(i).getS_Nm());
            result.put(scores.get(i),intrestBySnm);
        }

        int min_sup = Integer.parseInt(Input1);
        int min_con = Integer.parseInt(Input2);
        AlgorithmMain am = new AlgorithmMain();
        am.algorithmMain(result,min_sup,min_con);
        return "teacher/scoreMiner_main.jsp";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());

        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        //获取文件必须的
        MultiValueMap<String,MultipartFile> map = mRequest.getMultiFileMap();
        //获取到文件的列表
        List<MultipartFile> list = map.get("file");
        List<String> fileNameList = new ArrayList<>();
        //存储
        File newFile = null;
        for (MultipartFile mFile : list){
            //获取文件名称
            String originalFilename = mFile.getOriginalFilename();
            fileNameList.add(originalFilename);
            try {
                //获取字节数组
                byte[] bytes = mFile.getBytes();
                //文件最终地址
                String filePath = "D:\\excel\\" + File.separator + originalFilename;
                newFile = new File(filePath);
                //写出到文件
                FileOutputStream fos = new FileOutputStream(newFile);
                fos.write(bytes);
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ExcelInputUtil eiu = new ExcelInputUtil();
        List<ST_Score> scores = eiu.excelInputMain(newFile);

        for (ST_Score score : scores){
            int T_No = score.getT_No();
            int S_Nm = score.getS_Nm();
            int C_NO = score.getC_NO();
            int S_Ncor = score.getS_Ncor();
            int S_Mid = score.getS_Mid();
            int S_Fs = score.getS_Fs();
            int S_TO = score.getS_TO();
            teacherService.insertOneData(T_No,S_Nm,C_NO,S_Ncor,S_Mid,S_Fs,S_TO);
        }

        if (scores != null)
            model.addAttribute("message","文件导入成功");
        else
            model.addAttribute("message","文件导入失败，请检查格式后重新导入");
        return "teacher/dataInAndOut.jsp";
    }

    @RequestMapping("/exampleDownload")
    public String exampleDownload(Model model, HttpServletResponse response){
//        InputStream inputStream = null;
//        try {
//            File file = new File("src\\main\\resources\\lib\\示范表格.xlsx");
//            inputStream=new FileInputStream(file);
//            this.fileDownload(file.getName(),inputStream,response);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        String path = "lib\\示范表格.xlsx";
        response.setContentType("excel/xlsx");
        response.addHeader("Content-Disposition","attachment;filename=/"+path);
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            byte[] b = new byte[is.available()];
            is.read(b);
            ServletOutputStream sos = response.getOutputStream();
            sos.write(b);
            sos.flush();
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "teacher/dataInAndOut.jsp";
    }

    //文件下载方法，可以防止util中
    public static void fileDownload(String filename, InputStream input, HttpServletResponse response){
        try {
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            //关闭，即下载
            toClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getScore(HttpServletRequest request, Model model){
        TE_Teacher teacher = (TE_Teacher) request.getSession().getAttribute("teacher");
        model.addAttribute("name",teacher.getT_Name());
        List<ST_Score> te_teachers = teacherService.selectScoreByTno(teacher.getT_No());
        System.out.println(te_teachers);
        model.addAttribute("scoreList", te_teachers);
    }
}
