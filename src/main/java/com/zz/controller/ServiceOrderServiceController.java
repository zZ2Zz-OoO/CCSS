package com.zz.controller;

import com.zz.pojo.R;
import com.zz.pojo.ServiceOrder;
import com.zz.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class ServiceOrderServiceController {
    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    public R<String> addServiceOrder(@RequestBody ServiceOrder ServiceOrder) {
        boolean save = serviceOrderService.save(ServiceOrder);
        if (save) {
            return R.success("添加订单成功");
        }
        else {
            return R.error("添加订单失败");
        }
    }

    @DeleteMapping("/{serviceOrder_id}")
    public R<String> deleteOne(@PathVariable BigInteger serviceOrder_id) {
        boolean b = serviceOrderService.removeById(serviceOrder_id);
        if (b) {
            return R.success("删除成功");
        }
        else {
            return R.error("删除失败");
        }
    }

    @GetMapping("/{serviceOrder_id}")
    public R<ServiceOrder> getById(@PathVariable BigInteger serviceOrder_id) {
        ServiceOrder ServiceOrder = serviceOrderService.getById(serviceOrder_id);
        if (ServiceOrder != null) {
            return R.success(ServiceOrder);
        }
        return R.error("无此订单");
    }

    @GetMapping
    public R<List<ServiceOrder>> getAll() {
        List<ServiceOrder> ServiceOrders = serviceOrderService.list();
        return R.success(ServiceOrders);
    }

    @PutMapping
    public R<String> update(@RequestBody ServiceOrder ServiceOrder) {
        boolean flag = serviceOrderService.updateById(ServiceOrder);
        if (flag) {
            return R.success("修改成功");
        }
        else {
            return R.error("修改失败");
        }
    }
}
