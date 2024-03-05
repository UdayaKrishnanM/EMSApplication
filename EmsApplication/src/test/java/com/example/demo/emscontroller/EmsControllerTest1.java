package com.example.demo.emscontroller;


import com.example.demo.customException.UserDataNotFound;
import com.example.demo.empEntity.EmpEntity;
import com.example.demo.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class EmsControllerTest1 {
    @InjectMocks
    EmsController emscontroller;
    @Mock
    EmpService service;
    @Value("${ID}")
    private int employeeId;

    @Value("${Name}")
    private String employeeName;



    @Test
    public void testGetEmployeeDetails() {
        // Mocking the values from application.properties file
        int expectedEmployeeId = 123;
        String expectedEmployeeName = "John Doe";

        // Setting up the mocked values
        emscontroller.employeeId = expectedEmployeeId;
        emscontroller.employeeName = expectedEmployeeName;

        // Calling the method to test
        String result = emscontroller.getEmployeeDetails();

        // Asserting the result
        String expectedResult = "Employee ID: " + expectedEmployeeId + ", Employee Name: " + expectedEmployeeName;
        assertEquals(expectedResult, result);
    }

    @Test
    public void empTest(){
        EmpEntity emprec = new EmpEntity();
        emprec.setEmpId(2);
        emprec.setEmpName("Udaya");
        emprec.setRelivingDate("20/02/2023");
        emprec.setJoiningDate("21/02/2022");
        Mockito.when(service.empsave(Mockito.any())).thenReturn(emprec);
        EmpEntity emp = emscontroller.saveSingleEmprecords(emprec);
        assertNotNull(emp);
    }

    @Test
    public void findAll(){
        List<EmpEntity> emprec = new ArrayList<>();
//        Mockito.when(service.getAllRecords(emprec)).thenReturn(emprec);
//        List<EmpEntity> emp = emscontroller.getAllData(emprec);
//        assertNotNull(emp);
//        (or)
        //emprec.add(new EmpEntity(7,3,"udaya",12332,"23/01/2021","23/10/2023"));
        Mockito.when(service.getAllRecords(emprec)).thenReturn(emprec);
        List<EmpEntity> emp = emscontroller.getAllData(emprec);

    }

    @Test
    public void getByIdTest() throws UserDataNotFound {
        EmpEntity emprec = new EmpEntity();
        emprec.setEmpId(1);
        Mockito.when(service.getuniqueRecords(1)).thenReturn(emprec);
        EmpEntity emp = emscontroller.getuniqueData(1);
        assertEquals(1, emp.getEmpId());
    }

    @Test
    public void getuniqueData() throws UserDataNotFound {
        EmpEntity emprec = new EmpEntity(1, 1, "John", 1000, "01/01/2022", "01/01/2023");
        Mockito.when(service.getuniqueRecords(1)).thenReturn(emprec);
        EmpEntity emp = emscontroller.getuniqueData(1);
        assertNotNull(emp);
        assertEquals("John", emp.getEmpName());
    }

    @Test
    public void listAllRecords() {
        List<EmpEntity> emprec = new ArrayList<>();
        emprec.add(new EmpEntity(1, 1, "John", 1000, "01/01/2022", "01/01/2023"));
        emprec.add(new EmpEntity(2, 2, "Jane", 2000, "02/02/2022", "02/02/2023"));
        Mockito.when(service.listRecords()).thenReturn(emprec);
        List<EmpEntity> empList = emscontroller.listAllRecords();
        assertNotNull(empList);
        assertEquals(2, empList.size());
    }

    @Test
    public void deteleById(){
        EmpEntity emprec = new EmpEntity();
        emscontroller.deleteById(1);
        Mockito.verify(service, times(1)).deleteById(1);
    }


    @Test
    public void update(){
        EmpEntity emprec = new EmpEntity(2,4,"Johm",43434,"20/05/2020","01/01/2023");
        Mockito.when(service.updateById(2, emprec)).thenReturn(emprec);
        EmpEntity emp = emscontroller.updateById(2, emprec);
        assertNotNull(emp);
    }

    @Test
    public void updateById() {
        EmpEntity updatedEmp = new EmpEntity(1, 1, "John Doe", 1500, "01/01/2022", "01/01/2024");
        Mockito.when(service.updateById(1, updatedEmp)).thenReturn(updatedEmp);
        EmpEntity emp = emscontroller.updateById(1, updatedEmp);
        assertNotNull(emp);
        assertEquals("John Doe", emp.getEmpName());
        assertEquals(1500, emp.getSalary());
    }

    @Test
    public void getbyname() {
        EmpEntity emprec = new EmpEntity(1, 1, "John", 1000, "01/01/2022", "01/01/2023");
        Mockito.when(service.getbyname("John")).thenReturn(emprec);
        EmpEntity emp = emscontroller.getbyname("John");
        assertNotNull(emp);
        assertEquals("John", emp.getEmpName());
    }


//    check this code it shows error
    @Test
    public void saveEmprecords_ResponseEntity() {
        EmpEntity emprec = new EmpEntity();
        emprec.setEmpId(2);
        emprec.setEmpName("Udaya");
        emprec.setRelivingDate("20/02/2023");
        emprec.setJoiningDate("21/02/2022");
        Mockito.when(service.empsave(Mockito.any())).thenReturn(emprec);

        ResponseEntity<EmpEntity> responseEntity = emscontroller.saveEmprecords(emprec);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Assuming OK status for successful save
        assertEquals(emprec, responseEntity.getBody());
    }


}
