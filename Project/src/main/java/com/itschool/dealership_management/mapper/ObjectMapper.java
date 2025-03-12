package main.java.com.itschool.dealership_management.mapper;

public interface ObjectMapper <T, R> {

    T mapToDo (R r);

    R mapToEntity(T t);
}
