package tables;

import java.sql.SQLException;

public class CuratorTable extends AbsTable{
    private String tableName = "curators";

    public CuratorTable() {super("curators"); }


    @Override
    public void create() throws SQLException {
        iDbExecutor.execute(String.format("CREATE table %s (id int not null, fio varchar(40));", tableName), false);

    }

    @Override
    public void insert() throws SQLException {
        iDbExecutor.execute(String.format("INSERT INTO %s VALUES " +
                "(1, 'Ракова Агата'), " +
                "(2, 'Трофимов Герман'), " +
                "(3, 'Хомяков Роберт'), " +
                "(4, 'Козлов Тимур');", tableName), false);
    }
}
