package MyProject.Intefaces.intefacesDAO.overalInterfacesDAO;

import MyProject.Intefaces.intefacesDAO.*;

public interface MyDAOFactory {
    EmployeeDao getEmployeeDao();

    WorkDaysDao getWorkDaysDao();

    WorkingShiftDao getWorkingShiftDao();

    ScheduleDao getScheduleDao();

    FreeScheduleDao getFreeScheduleDao();

    PlanDao getPlanDao();
}