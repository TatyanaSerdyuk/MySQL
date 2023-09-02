package tables;

import java.sql.SQLException;

public class StudentTable extends AbsTable {
    private String tableName = "students";
    public StudentTable() {
        super("students");
    }

    String[] arrayPredicate = new String[] {"sex = f"};

    @Override
    protected String createPredicate(String[] predicateValues) {
        return super.createPredicate(arrayPredicate);
    }


    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("CREATE table %s (id int not null, fio varchar(40), sex varchar(40), idGroup int not null);", tableName), false);
    }

    @Override
    public void insert() throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s VALUES " +
                "(1, 'Ермаков Василий', 'm', 3), " +
                "(2, 'Петрова Мария', 'f', 3), " +
                "(3, 'Новиков Алексей', 'm', 2), " +
                "(4, 'Мешков Сергей', 'm', 1), " +
                "(5, 'Сахаров Пётр', 'm', 1), " +
                "(6, 'Попов Иван', 'm', 2), " +
                "(7, 'Калмыкова Вероника', 'f', 1), " +
                "(8, 'Сорокин Леонид', 'm', 1), " +
                "(9, 'Емельянов Леонид', 'm', 2), " +
                "(10, 'Пугачев Роман', 'm', 2), " +
                "(11, 'Новикова Валерия', 'f', 2), " +
                "(12, 'Новиков Алексей', 'm', 1), " +
                "(13, 'Ткачев Максим', 'm', 2), " +
                "(14, 'Федотова Марина', 'f', 3), " +
                "(15, 'Петровская Вероника', 'f', 3);", tableName), false);
    }


}

   /*public void selectStudents() throws SQLException {
      ResultSet students = iDbExecutor.execute(String.format("SELECT students.fio, groupStudent.groupName, curators.fio   FROM students  INNER JOIN groupStudent ON groupStudent.id = students.idGroup  INNER JOIN curators ON curators.id = groupStudent.idCurator;"), false);
      System.out.println("This is list students:");
      while (students.next()) {
         int id = students.getInt(1);
         String fio = students.getString(2);
         String sex = students.getString(3);
         int idGroup = students.getInt(4);
         System.out.println(id + "|" + fio + "|" + sex + "|" + idGroup + "|");
      }
   }*/
