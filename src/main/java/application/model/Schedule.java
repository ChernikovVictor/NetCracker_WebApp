package application.model;

import application.dao.DataAccessObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Schedule extends ScheduleModel {

    @Getter @Setter
    private DataAccessObject dao;

}
