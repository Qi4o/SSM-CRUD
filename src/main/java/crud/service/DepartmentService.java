package crud.service;

import crud.bean.Department;
import crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Qiao
 * @Create 2022/5/23 17:07
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
