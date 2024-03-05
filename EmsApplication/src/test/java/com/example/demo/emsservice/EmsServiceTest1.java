package com.example.demo.emsservice;


import com.example.demo.customException.UserDataNotFound;
import com.example.demo.empEntity.EmpEntity;
import com.example.demo.empRepo.EmpRepo;
import com.example.demo.service.EmpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class EmpServiceTest {

    @Mock
    private EmpRepo empRepo;

    @InjectMocks
    private EmpService empService;


    @Test
    public void testEmpSave() {
        EmpEntity empEntity = new EmpEntity();
        when(empRepo.save(empEntity)).thenReturn(empEntity);
        EmpEntity result = empService.empsave(empEntity);
        assertEquals(empEntity, result);
    }

    @Test
    public void testGetAllRecords() {
        List<EmpEntity> empEntities = new ArrayList<>();
        when(empRepo.saveAll(empEntities)).thenReturn(empEntities);
        List<EmpEntity> result = empService.getAllRecords(empEntities);
        assertEquals(empEntities, result);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(empRepo).deleteById(1);
        empService.deleteById(1);
        verify(empRepo, times(1)).deleteById(1);
    }

    @Test
    public void testListRecords() {
        List<EmpEntity> empEntities = new ArrayList<>();
        when(empRepo.findAll()).thenReturn(empEntities);
        List<EmpEntity> result = empService.listRecords();
        assertEquals(empEntities, result);
    }

    @Test
    public void testGetuniqueRecords() throws UserDataNotFound {
        EmpEntity empEntity = new EmpEntity();
        when(empRepo.findById(1)).thenReturn(Optional.of(empEntity));
        assertThrows(UserDataNotFound.class, () -> empService.getuniqueRecords(2));
        EmpEntity result = empService.getuniqueRecords(1);
        assertEquals(empEntity, result);
    }

    @Test
    public void testUpdateById() {
        EmpEntity empEntity = new EmpEntity();
        empEntity.setId(1);
        empEntity.setEmpName("John Doe");
        empEntity.setSalary(50000);
        when(empRepo.findById(1)).thenReturn(Optional.of(empEntity));
        when(empRepo.save(empEntity)).thenReturn(empEntity);
        EmpEntity newEmpEntity = new EmpEntity();
        newEmpEntity.setSalary(60000);
        EmpEntity result = empService.updateById(1, newEmpEntity);
        assertEquals(60000, result.getSalary());
        assertEquals("John Doe", result.getEmpName());
    }

    @Test
    public void testGetByName() {
        EmpEntity empEntity = new EmpEntity();
        empEntity.setEmpName("John Doe");
        when(empRepo.findByEmpName("John Doe")).thenReturn(empEntity);
        EmpEntity result = empService.getbyname("John Doe");
        assertEquals(empEntity, result);
    }
}
