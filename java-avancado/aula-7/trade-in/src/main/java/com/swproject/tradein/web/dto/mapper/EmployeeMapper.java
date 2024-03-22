package com.swproject.tradein.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.tradein.entities.Employee;
import com.swproject.tradein.entities.Usuario;
import com.swproject.tradein.web.dto.EmployeeResponseDto;
import com.swproject.tradein.web.dto.form.EmployeeForm;

public class EmployeeMapper {

  public static Employee toEmployee(EmployeeForm createDto, Usuario usuario) {
    return new ModelMapper()
        .map(new Employee(createDto.getName(), createDto.getCpf(), createDto.getBirthDate(), usuario), Employee.class);
  }

  public static EmployeeResponseDto toDto(Employee employee) {
    PropertyMap<Employee, EmployeeResponseDto> props = new PropertyMap<Employee, EmployeeResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setName(source.getName());
        map().setBirthDate(source.getBirthDate());
        map().setUsuario(UsuarioMapper.toDto(source.getUsuario()));
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(employee, EmployeeResponseDto.class);
  }

  public static List<EmployeeResponseDto> toListDto(List<Employee> employees) {
    return employees.stream().map(employee -> toDto(employee)).collect(Collectors.toList());
  }
}