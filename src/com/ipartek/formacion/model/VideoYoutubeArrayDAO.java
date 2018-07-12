package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejercicios.interfaces.CrudAble;
import com.ipartek.formacion.pojo.Youtube;

/**
 * Clase DAO para gestionar los Videoclip arraylist usamos patron singleton
 * 
 * @author Curso
 * @see https://es.wikipedia.org/wiki/Singleton#Java
 */

public class VideoYoutubeArrayDAO implements CrudAble {
	private static VideoYoutubeArrayDAO INSTANCE = null;
	private static List<Youtube> Lista = null;

	private VideoYoutubeArrayDAO() {
		Lista = new ArrayList<Youtube>();
	}

	public static synchronized VideoYoutubeArrayDAO getIntance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoYoutubeArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Youtube video) {
		boolean result = false;
		if (video != null) {
			result = Lista.add(video);

		}

		return result;

	}

	@Override
	public List<Youtube> getAll() {
		return Lista;
	}

	@Override
	public Youtube getByID(long id) {
		for (int i = 0; i < Lista.size(); i++) {
			Youtube video = Lista.get(i);
			if (video.getId() == id) {
				return video;
			}
		}
		return null;
	}

	@Override
	public boolean update(Youtube video) {
		for (int i = 0; i < Lista.size(); i++) {
			Youtube v = Lista.get(i);
			if (v.getId() == video.getId()) {
				Lista.set(i, video);
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean delete(long id) {
		for (int i = 0; i < Lista.size(); i++) {
			Youtube video = Lista.get(i);
			if (video.getId() == id) {
				Lista.remove(i);
				return true;
			}
		}
		return false;
	}

}