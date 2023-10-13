package com.interswitch.employeeportal.service.impl;

import com.interswitch.employeeportal.converter.CategoryToResourceConverter;
import com.interswitch.employeeportal.dto.request.EmployeeCategoryRequest;
import com.interswitch.employeeportal.dto.response.EmployeeCategoryResource;
import com.interswitch.employeeportal.exception.EmployeePortalException;
import com.interswitch.employeeportal.model.EmployeeCategory;
import com.interswitch.employeeportal.repository.EmployeeCategoryRepository;
import com.interswitch.employeeportal.service.EmployeeCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeCategoryServiceImpl implements EmployeeCategoryService {

    private final EmployeeCategoryRepository categoryRepository;

    private final CategoryToResourceConverter categoryToResourceConverter;

    @Override
    @Transactional
    public void addEmployeeCategory(EmployeeCategoryRequest employeeCategoryRequest) {
        try {
            EmployeeCategory employeeCategory = EmployeeCategory.builder()
                    .name(employeeCategoryRequest.getName())
                    .description(employeeCategoryRequest.getDescription())
                    .build();
            categoryRepository.save(employeeCategory);
        } catch (Exception e) {
            log.error(format("An error occurred while creating employee category, please contact support" +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException(
                    "An error occurred creating employee category", INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public EmployeeCategoryResource getAnEmployeeCategory(Integer employeeCategoryId) {
        EmployeeCategory category = categoryRepository.findById(employeeCategoryId)
                .orElseThrow(()-> new RuntimeException("Employee with id: " + employeeCategoryId + " could not be found"));
        return categoryToResourceConverter.convert(category);
    }

    @Override
    public List<EmployeeCategoryResource> getAllEmployeeCategories() {
        return categoryRepository.findAll().parallelStream()
                .map(categoryToResourceConverter::convert).toList();
    }


    @Override
    @Transactional
    public EmployeeCategoryResource updateEmployeeCategory(
            Integer categoryId, EmployeeCategoryRequest employeeCategoryRequest) {
        try {
            EmployeeCategory employeeCategory = categoryRepository.findById(categoryId)
                    .orElseThrow(()-> new RuntimeException("Employee category not found"));
            employeeCategory.setName(employeeCategoryRequest.getName());
            employeeCategory.setDescription(employeeCategoryRequest.getDescription());
            categoryRepository.save(employeeCategory);
            return categoryToResourceConverter.convert(employeeCategory);
        } catch (Exception e) {
            log.error(format("An error occurred while updating employee category, please contact support" +
                    "Possible reasons: %s", e.getLocalizedMessage()));
            throw new EmployeePortalException("An error occurred while updating employee category",
                    INTERNAL_SERVER_ERROR);
        }
    }
}
