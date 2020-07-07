package application.model;

import application.dao.DataAccessObject;
import application.dao.SimpleDao;
import lombok.Getter;
import lombok.Setter;

public class Schedule extends ScheduleModel {

    private static Schedule schedule;

    @Getter @Setter
    private DataAccessObject dao;

    public static Schedule getInstance() {
        if (schedule == null) {
            schedule = new Schedule();
            schedule.setDao(new SimpleDao());
        }
        return schedule;
    }

}
