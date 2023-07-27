package LottoCompany.operations;

import java.sql.SQLException;

abstract public class CRUD {
    public abstract void create() throws SQLException;
    public abstract void read() throws SQLException;
    public abstract void update() throws SQLException;
    public abstract void delete() throws SQLException;
}
