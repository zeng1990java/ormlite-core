package com.j256.ormlite.stmt;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Before;

import com.j256.ormlite.BaseCoreTest;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;

public abstract class BaseCoreStmtTest extends BaseCoreTest {

	protected TableInfo<Foo> baseFooTableInfo;
	protected FieldType numberFieldType;
	protected FieldType stringFieldType;
	protected FieldType foreignFieldType;

	@Override
	@Before
	public void before() throws Exception {
		super.before();

		Field field = Foo.class.getDeclaredField("id");
		assertEquals(String.class, field.getType());
		stringFieldType = FieldType.createFieldType(connectionSource, "BaseFoo", field, 0);
		field = Foo.class.getDeclaredField("val");
		assertEquals(int.class, field.getType());
		numberFieldType = FieldType.createFieldType(connectionSource, "BaseFoo", field, 0);
		field = Foreign.class.getDeclaredField("foo");
		assertEquals(Foo.class, field.getType());
		foreignFieldType = FieldType.createFieldType(connectionSource, "BaseFoo", field, 0);

		baseFooTableInfo = new TableInfo<Foo>(connectionSource, Foo.class);
	}
}