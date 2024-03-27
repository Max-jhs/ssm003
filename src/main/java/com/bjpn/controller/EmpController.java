package com.bjpn.controller;

import com.bjpn.bean.Emp;

import com.bjpn.service.EmpMapperService;
import com.bjpn.util.MessageUtil;
import com.bjpn.util.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.lang.model.util.ElementScanner6;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Haisong Jiang
 * @Date: 2024/03/07/17:16
 * @Description:
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpMapperService empMapperService;

    //去员工管理页面(页面展示所有员工数据)
    //每次都要全库查询所有的员工信息 数据量大的话？效率低  分页查询？分页？查一部分  总数据量？  分多少页？
    // 每页的数据量是多少（步长） 人为规定假如是8条  pageSize = 8
    // 分多少页  公式： total = count（*）/8 + 1  操作过程中数据量会变 所以每次查询时都要确定总的数据量是多少  这个前端也需要
    // 点击某一个数字查询某一页的数据   数字pageNum = 1\2\3\4 前端随便传  而在数据库中的查询开始索引startIndex =  （pageNum-1）*步长
    @RequestMapping("/toEmpManager.action")
    public String toEmpManger(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,String empName) {

        System.out.println(empName);
        Integer total = empMapperService.selEmp(empName);//总的数据量
        Integer pages = total / 8 + 1;//这是总页数
        Integer pageSize = 8;//步长
        Integer startIndex = (pageNum - 1) * pageSize; //下表
        ArrayList<Emp> empList = empMapperService.showEmps(startIndex, pageSize, empName);
        request.setAttribute("empList", empList);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("pages", pages);
        request.setAttribute("empName", empName);
        return "/page/emp/employee";
    }

    //去添加员工页面
    @RequestMapping("/toAddEmp.action")
    public String toAddEmp() {
        return "/page/emp/addEmp";
    }

    //添加员工
    @RequestMapping("/addEmp.action")
    public String addEmp(Emp emp, MultipartFile photoFile, HttpServletRequest request) throws IOException {

        //其他属性名字相同直接赋值了
        //头像文件不为空
        if (!photoFile.isEmpty()) {
            String houzhui = photoFile.getOriginalFilename().substring(photoFile.getOriginalFilename().lastIndexOf("."));
            String photoFileName = UUID.randomUUID().toString().replace("-", "") + houzhui;
            //fafdsafwe1dad.jpg
            emp.setEmpImg(photoFileName);
            //开始上传
            String realPath = request.getServletContext().getRealPath("/");
            File file = new File(realPath + "/images/" + photoFileName);
            photoFile.transferTo(file);
        }
        boolean b = empMapperService.addEmp(emp);
        if (b) {
            //添加成功 去到员工页面  关键字转发视图解析器不会拼前缀和后缀
            System.out.println("emp = " + emp);
            return "redirect:/emp/toEmpManager.action";
        }
        return null;
    }

    //同步删除员工
    @RequestMapping("/delEmp.action")
    public String delEmp(Integer empId) {
        int i = empMapperService.delEmp(empId);
        return "redirect:/emp/toEmpManager.action";
    }

    @RequestMapping("/toEmployee.action")
    public String toEmployee() {
        return "/page/emp/employee";
    }

    //根据员工Id带着员工信息去修改页面
    @RequestMapping("showEmpInfo.action")
    public String showEmpInfo(Emp emp, HttpServletRequest request) {
//        System.out.println("haha" + emp.getEmpId());
        Emp emp1 = empMapperService.selEmpById(emp.getEmpId());
        request.setAttribute("Emp", emp1);
        System.out.println("----" + emp1);
//        ----Emp{empId = 1, empName = 王光利, empSal = 8000.0, empHireDate = 1995, empImg = , empDeptId = 1, dept = Dept{deptId = 1, deptName = 研发部, deptAddr = 上海}}
        return "/page/emp/updateEmp";
    }

    //修改员工信息
    @RequestMapping("/upDateEmp.action")
    public String upDateEmp(Emp emp,MultipartFile photoFile,HttpServletRequest request) throws IOException {
//        emp = Emp{empId = 38, empName = 王光利, empSal = 8000.0, empHireDate = 2024-03-26, empImg = 2.jpg, empDeptId = 1, dept = null}
        System.out.println("emp = " + emp);
        if (!photoFile.isEmpty()) {
            //其他信息改没改不知道但是头像一定是上传了
            String houzhui = photoFile.getOriginalFilename().substring(photoFile.getOriginalFilename().lastIndexOf("."));
            String photoFileName = UUID.randomUUID().toString().replace("-", "") + houzhui;
            //fafdsafwe1dad.jpg
            emp.setEmpImg(photoFileName);
            //开始上传
            String realPath = request.getServletContext().getRealPath("/");
            File file = new File(realPath + "/images/" + photoFileName);
            photoFile.transferTo(file);
            int i = empMapperService.upDateEmp(emp);
        }else{
            //没上传头像，但是修改了其他信息
            int i = empMapperService.upDateEmp(emp);
        }
        return "redirect:/emp/toEmpManager.action";
    }


    //批量删除
    @RequestMapping("/delEmps.action")

    public @ResponseBody ResultObject delEmps(String ids, ResultObject resultObject) {
        System.out.println("ids = " + ids);
        String[] empIds = ids.split(",");
        System.out.println(Arrays.toString(empIds));
        int i = empMapperService.delEmps(empIds);
        if (i > 0) {
            resultObject.setResultCode(MessageUtil.DEL_SUCCESSCODE);
            resultObject.setResultMsg(MessageUtil.DEL_SUCCESS);
        }else {
            resultObject.setResultMsg(MessageUtil.DEL_FAILED);
            resultObject.setResultCode(MessageUtil.DEL_FAILEDCODE);
        }
        return resultObject;
    }
}
