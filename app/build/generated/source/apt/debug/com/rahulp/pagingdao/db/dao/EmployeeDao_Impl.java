package com.rahulp.pagingdao.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.paging.LimitOffsetDataSource;
import android.database.Cursor;
import com.rahulp.pagingdao.Employee;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
public class EmployeeDao_Impl implements EmployeeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEmployee;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfEmployee;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfEmployee;

  public EmployeeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmployee = new EntityInsertionAdapter<Employee>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Employee`(`emp_id`,`emp_name`,`emp_desg`,`address`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Employee value) {
        stmt.bindLong(1, value.empid);
        if (value.empName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.empName);
        }
        if (value.empDesignation == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.empDesignation);
        }
        if (value.address == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.address);
        }
      }
    };
    this.__deletionAdapterOfEmployee = new EntityDeletionOrUpdateAdapter<Employee>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Employee` WHERE `emp_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Employee value) {
        stmt.bindLong(1, value.empid);
      }
    };
    this.__updateAdapterOfEmployee = new EntityDeletionOrUpdateAdapter<Employee>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Employee` SET `emp_id` = ?,`emp_name` = ?,`emp_desg` = ?,`address` = ? WHERE `emp_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Employee value) {
        stmt.bindLong(1, value.empid);
        if (value.empName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.empName);
        }
        if (value.empDesignation == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.empDesignation);
        }
        if (value.address == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.address);
        }
        stmt.bindLong(5, value.empid);
      }
    };
  }

  @Override
  public void insertAll(List<Employee> employees) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmployee.insert(employees);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(Employee... employees) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmployee.insert(employees);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(Employee... employees) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfEmployee.handleMultiple(employees);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(Employee... employees) {
    __db.beginTransaction();
    try {
      __updateAdapterOfEmployee.handleMultiple(employees);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LivePagedListProvider<Integer, Employee> employeesByFirstName() {
    final String _sql = "SELECT * FROM Employee";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LivePagedListProvider<Integer, Employee>() {
      @Override
      protected LimitOffsetDataSource<Employee> createDataSource() {
        return new LimitOffsetDataSource<Employee>(__db, _statement, "Employee") {
          @Override
          protected List<Employee> convertRows(Cursor cursor) {
            final int _cursorIndexOfEmpid = cursor.getColumnIndexOrThrow("emp_id");
            final int _cursorIndexOfEmpName = cursor.getColumnIndexOrThrow("emp_name");
            final int _cursorIndexOfEmpDesignation = cursor.getColumnIndexOrThrow("emp_desg");
            final int _cursorIndexOfAddress = cursor.getColumnIndexOrThrow("address");
            final List<Employee> _res = new ArrayList<Employee>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Employee _item;
              _item = new Employee();
              _item.empid = cursor.getLong(_cursorIndexOfEmpid);
              _item.empName = cursor.getString(_cursorIndexOfEmpName);
              _item.empDesignation = cursor.getString(_cursorIndexOfEmpDesignation);
              _item.address = cursor.getString(_cursorIndexOfAddress);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }
}
