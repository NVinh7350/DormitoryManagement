package com.example.dormitorymanagement.repository;

import com.example.dormitorymanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //List<Room> findAllByRoomNameContaining(String room);
    List<Employee> findAllByEmployeeNameContainingOrEmployeeIdContaining(String employeeName, String employeeId);
//    @Query(nativeQuery = true, value = "Select * from Room where room_name = :name")
//    List<Object[]> findAllByCondition(@Param("name") String a, String b);
}
