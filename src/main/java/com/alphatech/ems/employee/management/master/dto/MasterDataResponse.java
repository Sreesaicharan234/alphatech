package com.alphatech.ems.employee.management.master.dto;

import com.alphatech.ems.employee.management.master.model.Department;
import com.alphatech.ems.employee.management.master.model.EmpStatus;
import com.alphatech.ems.employee.management.master.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MasterDataResponse {
    List<Gender> genderList;
    List<EmpStatus> empStatuses;
    List<Department> departments;
}
