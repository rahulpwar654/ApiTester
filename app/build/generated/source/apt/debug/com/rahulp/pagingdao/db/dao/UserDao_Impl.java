package com.rahulp.pagingdao.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.paging.LimitOffsetDataSource;
import android.database.Cursor;
import com.rahulp.pagingdao.User;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("android.arch.persistence.room.RoomProcessor")
public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `User`(`user_id`,`first_name`,`address`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.userId);
        if (value.firstName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.firstName);
        }
        if (value.address == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.address);
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `user_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.userId);
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `User` SET `user_id` = ?,`first_name` = ?,`address` = ? WHERE `user_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.userId);
        if (value.firstName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.firstName);
        }
        if (value.address == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.address);
        }
        stmt.bindLong(4, value.userId);
      }
    };
  }

  @Override
  public void insertAll(List<User> users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(User... user) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUser(User... user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(User... user) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LivePagedListProvider<Integer, User> usersByFirstNameRahul() {
    final String _sql = "SELECT * FROM User ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LivePagedListProvider<Integer, User>() {
      @Override
      protected LimitOffsetDataSource<User> createDataSource() {
        return new LimitOffsetDataSource<User>(__db, _statement, "User") {
          @Override
          protected List<User> convertRows(Cursor cursor) {
            final int _cursorIndexOfUserId = cursor.getColumnIndexOrThrow("user_id");
            final int _cursorIndexOfFirstName = cursor.getColumnIndexOrThrow("first_name");
            final int _cursorIndexOfAddress = cursor.getColumnIndexOrThrow("address");
            final List<User> _res = new ArrayList<User>(cursor.getCount());
            while(cursor.moveToNext()) {
              final User _item;
              _item = new User();
              _item.userId = cursor.getLong(_cursorIndexOfUserId);
              _item.firstName = cursor.getString(_cursorIndexOfFirstName);
              _item.address = cursor.getString(_cursorIndexOfAddress);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LivePagedListProvider<Integer, User> usersByFirstName() {
    final String _sql = "SELECT * FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new LivePagedListProvider<Integer, User>() {
      @Override
      protected LimitOffsetDataSource<User> createDataSource() {
        return new LimitOffsetDataSource<User>(__db, _statement, "User") {
          @Override
          protected List<User> convertRows(Cursor cursor) {
            final int _cursorIndexOfUserId = cursor.getColumnIndexOrThrow("user_id");
            final int _cursorIndexOfFirstName = cursor.getColumnIndexOrThrow("first_name");
            final int _cursorIndexOfAddress = cursor.getColumnIndexOrThrow("address");
            final List<User> _res = new ArrayList<User>(cursor.getCount());
            while(cursor.moveToNext()) {
              final User _item;
              _item = new User();
              _item.userId = cursor.getLong(_cursorIndexOfUserId);
              _item.firstName = cursor.getString(_cursorIndexOfFirstName);
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
