package LottoCompany.operations;

import java.sql.SQLException;

abstract public class CRUD {
    abstract void create() throws SQLException;
    abstract void read() throws SQLException;
    abstract void update() throws SQLException;
    abstract void delete() throws SQLException;
}
