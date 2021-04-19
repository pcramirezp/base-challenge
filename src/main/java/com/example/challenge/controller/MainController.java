package com.example.challenge.controller;

import com.example.challenge.model.Patient;
import com.example.challenge.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping(path = "/user")
public class MainController {

    @Autowired
    PatientService patientService;

    @PostMapping(path = "/createPatient") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestBody Patient patient ) throws InterruptedException, ExecutionException {
        return patientService.savePatientDetails(patient);
    }

    @GetMapping(path ="/getPatient/{name}")
    public @ResponseBody Patient getPatient(@PathVariable("name") String name) throws InterruptedException, ExecutionException {
        return patientService.getPatientDetails(name);
    }


    @PutMapping(path= "/updatePatient")
    public @ResponseBody String updatePatient(@RequestBody Patient patient) throws InterruptedException, ExecutionException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping(path= "/deletePatient/{name}")
    public @ResponseBody String deletePatient(@PathVariable("name") String name){
        return patientService.deletePatient(name);
    }

}
