package database;

import java.sql.ResultSet;

public abstract class MapperBase<T> {

	protected abstract T map(ResultSet set);

}
