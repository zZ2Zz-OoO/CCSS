package com.zz.controller;

import com.zz.pojo.R;
import com.zz.pojo.ServiceType;
import com.zz.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/types")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping
    public R<String> addServiceType(@RequestBody ServiceType servicetype) {
        boolean save = serviceTypeService.save(servicetype);
        if (save) {
            return R.success("添加种类成功");
        }
        else {
            return R.error("添加种类失败");
        }
    }

    @DeleteMapping("/{serviceType_id}")
    public R<String> deleteOne(@PathVariable BigInteger serviceType_id) {
        boolean b = serviceTypeService.removeById(serviceType_id);
        if (b) {
            return R.success("删除成功");
        }
        else {
            return R.error("删除失败");
        }
    }

    @GetMapping("/{serviceType_id}")
    public R<ServiceType> getById(@PathVariable BigInteger serviceType_id) {
        ServiceType ServiceType = serviceTypeService.getById(serviceType_id);
        if (ServiceType != null) {
            return R.success(ServiceType);
        }
        return R.error("无此种类");
    }

    @GetMapping
    public R<List<ServiceType>> getAll() {
        List<ServiceType> serviceTypes = serviceTypeService.list();
        return R.success(serviceTypes);
    }

    @PutMapping
    public R<String> update(@RequestBody ServiceType ServiceType) {
        boolean flag = serviceTypeService.updateById(ServiceType);
        if (flag) {
            return R.success("修改成功");
        }
        else {
            return R.error("修改失败");
        }
    }
}
