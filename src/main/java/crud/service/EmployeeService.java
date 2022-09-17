package crud.service;

import crud.bean.Employee;
import crud.bean.EmployeeExample;
import crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author Qiao
 * @Create 2022/5/21 17:24
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    //查询所有员工
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    //员工保存方法
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    //检验用户名是否可用
    public boolean checkUser(@RequestParam("empName") String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo((empName));
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    //员工删除
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }


}
