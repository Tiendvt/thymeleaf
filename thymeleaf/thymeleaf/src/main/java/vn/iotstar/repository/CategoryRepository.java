package vn.iotstar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vn.iotstar.entity.Category;


import java.util.*;
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query()
	Optional<Category> findByName (String name); //muc dich: ton tai category co ten nay thi ko cho them.. Cai nay ko co trong phuong thuc cua Jpa Persistence ma viet them. (chi co findbyId thoi
	Page<Category> findByNameContaining(String name, Pageable pageable);		//VD: 3 category, moi category chua 2 trang(page)s.
}

