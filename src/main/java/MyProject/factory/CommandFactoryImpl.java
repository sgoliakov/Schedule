package MyProject.factory;

import MyProject.interfaces.intefacesCommand.CommandFactoryInfo;
import MyProject.interfaces.intefacesCommand.CommandInfo;
import MyProject.command.additionCommand.AddNewShiftCommand;
import MyProject.command.additionCommand.AddShiftCommand;
import MyProject.command.deleteCommand.*;
import MyProject.command.editCommand.EditProfileCommand;
import MyProject.command.editCommand.EditScheduleEmployee;
import MyProject.command.editCommand.EditorShiftCommand;
import MyProject.command.mainCommand.*;
import MyProject.command.showCommand.*;
import MyProject.command.updateCommand.UpdateProfileCommand;
import MyProject.command.updateCommand.UpdateShiftCommand;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl implements CommandFactoryInfo {
    private static CommandFactoryInfo factory;
    private final Map<String, CommandInfo> commands = new HashMap<>();

    private CommandFactoryImpl() {
        commands.put("register", new RegisterCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("main", new CommandMain());
        commands.put("login", new LoginCommand());
        commands.put("edit", new EditProfileCommand());
        commands.put("update", new UpdateProfileCommand());
        commands.put("add_shift_into_my_schedule", new AddShiftCommand());
        commands.put("schedule_by_id", new ShowMyScheduleCommand());
        commands.put("edit_schedule", new EditScheduleEmployee());
        commands.put("delete_schedule_employee", new DeleteScheduleEmployee());
        commands.put("delete_employees", new DeleteEmployeesCommand());
        commands.put("free_schedule_shifts", new ShowFreeScheduleShiftsCommand());
        commands.put("show_work_day", new ShowWorkDayCommand());
        commands.put("delete_work_day", new DeleteWorkDayCommand());
        commands.put("show_shift", new ShowShiftCommand());
        commands.put("editor_shift", new EditorShiftCommand());
        commands.put("update_shift", new UpdateShiftCommand());
        commands.put("show_plan", new ShowPlanCommand());
        commands.put("show_employees", new ShowEmployeesCommand());
        commands.put("delete_employee", new DeleteEmployeeCommand());
        commands.put("add_new_shift", new AddNewShiftCommand());
        commands.put("remove_shift", new RemoveShiftCommand());
        commands.put("create_month_plan", new CreateMonthPlanCommand());
        commands.put("create_report", new ShowReportCommand());
    }

    public static synchronized CommandFactoryInfo getCommandFactory() {
        if (factory == null) {
            factory = new CommandFactoryImpl();
        }
        return factory;
    }

    public CommandInfo getCommandInfo(HttpServletRequest request) {
        String action = request.getParameter("action");
        return commands.get(action);
    }
}
