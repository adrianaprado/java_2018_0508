package com.ipartek.formacion.ejercicios.interfaces;

import java.util.List;

import com.ipartek.formacion.pojo.Youtube;

public interface CrudAble {

		boolean insert(Youtube video);

		List<Youtube> getAll();

		Youtube getByID(long id);

		boolean update(Youtube video);

		boolean delete(long id);

}
