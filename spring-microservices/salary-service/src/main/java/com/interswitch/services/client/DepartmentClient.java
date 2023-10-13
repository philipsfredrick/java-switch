package com.interswitch.services.client;

import com.interswitch.services.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/{id}")
    Department findDepartment(@PathVariable("id") Long departmentId);
}
