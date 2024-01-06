package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/school")
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {

        return ResponseEntity.ok(new ResponseWrapper(
                "students are successfully retrieved.",
                studentService.findAll()));
    }

    /*
        create a parent endpoint where status code is 202
        additional header has "Parent", "Returned"
        and following body structure:
        "parents are successfully retrieved." message
        code: 202
        success: true
        and parent data.
     */
    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {

        ResponseWrapper responseWrapper = new ResponseWrapper(true,
                "parents are successfully retrieved.",
                HttpStatus.ACCEPTED.value(), parentService.findAll());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent", "Returned")
                .body(responseWrapper);
    }

    /*
        create an endpoint for individual address information
        /address/1 2 3
        return status code 200
        "address...is successfully retrieved message
        success true
        and address information
     */
    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressById(@PathVariable("id") Long id) throws Exception {

        // find the address to return
        AddressDTO addressDTO = addressService.findById(id);

        return ResponseEntity.ok(new ResponseWrapper(
                "Address " + id + " is successfully retrieved",
                addressDTO
        ));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) throws Exception {

        addressService.update(addressDTO);

        return ResponseEntity.ok(new ResponseWrapper(
                "Address is successfully updated",
                HttpStatus.OK
        ));
    }
}
