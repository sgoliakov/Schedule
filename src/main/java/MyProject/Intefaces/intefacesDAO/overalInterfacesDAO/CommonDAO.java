package MyProject.Intefaces.intefacesDAO.overalInterfacesDAO;

import java.util.List;
import java.util.Optional;

public interface CommonDAO<T> {
    Optional<T> getById(int id);

    List<T> getAll();

    void deleteAll();
}