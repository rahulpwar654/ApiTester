package com.rahulp.pagingdao.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import com.rahulp.pagingdao.db.dao.EmployeeDao;
import com.rahulp.pagingdao.db.dao.EmployeeDao_Impl;
import com.rahulp.pagingdao.db.dao.UserDao;
import com.rahulp.pagingdao.db.dao.UserDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
public class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile EmployeeDao _employeeDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate() {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`user_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `first_name` TEXT, `address` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Employee` (`emp_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `emp_name` TEXT, `emp_desg` TEXT, `address` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c15778881184d6bcd64acd8873376f0d\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `Employee`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(3);
        _columnsUser.put("user_id", new TableInfo.Column("user_id", "INTEGER", true, 1));
        _columnsUser.put("first_name", new TableInfo.Column("first_name", "TEXT", false, 0));
        _columnsUser.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          throw new IllegalStateException("Migration didn't properly handle User(com.rahulp.pagingdao.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployee = new HashMap<String, TableInfo.Column>(4);
        _columnsEmployee.put("emp_id", new TableInfo.Column("emp_id", "INTEGER", true, 1));
        _columnsEmployee.put("emp_name", new TableInfo.Column("emp_name", "TEXT", false, 0));
        _columnsEmployee.put("emp_desg", new TableInfo.Column("emp_desg", "TEXT", false, 0));
        _columnsEmployee.put("address", new TableInfo.Column("address", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployee = new HashSet<TableInfo.ForeignKey>(0);
        final TableInfo _infoEmployee = new TableInfo("Employee", _columnsEmployee, _foreignKeysEmployee);
        final TableInfo _existingEmployee = TableInfo.read(_db, "Employee");
        if (! _infoEmployee.equals(_existingEmployee)) {
          throw new IllegalStateException("Migration didn't properly handle Employee(com.rahulp.pagingdao.Employee).\n"
                  + " Expected:\n" + _infoEmployee + "\n"
                  + " Found:\n" + _existingEmployee);
        }
      }
    }, "c15778881184d6bcd64acd8873376f0d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .version(1)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "User","Employee");
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public EmployeeDao empDao() {
    if (_employeeDao != null) {
      return _employeeDao;
    } else {
      synchronized(this) {
        if(_employeeDao == null) {
          _employeeDao = new EmployeeDao_Impl(this);
        }
        return _employeeDao;
      }
    }
  }
}
