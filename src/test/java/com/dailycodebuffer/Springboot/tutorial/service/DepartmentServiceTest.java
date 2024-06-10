package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Dep1")
                        .departmentAddress("Ahmedabad")
                        .deparatmentCode("IT-06")
                        .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Dep1"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on Valid Department Name")

    public void whenValidDepartment_Name_thenDepartmentShouldFound(){
        String departmentName = "Dep1";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }

    @Test
    @DisplayName("Get Data based on Non-existent Department Name")
    public void whenNonExistentDepartmentName_thenDepartmentShouldNotBeFound() {
        String departmentName = "NonExistentDep";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertNull(found, "Department should not be found");
    }
}