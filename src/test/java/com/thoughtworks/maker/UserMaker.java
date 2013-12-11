package com.thoughtworks.maker;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import com.thoughtworks.models.User;

public class UserMaker {
  public static final Property<User, Long> employeeId = new Property<User, Long>();
  public static final Property<User, String> fullName = new Property<User, String>();
  public static final Property<User, String> password = new Property<User, String>();
  public static final Property<User, Boolean> isActive = new Property<User, Boolean>();
  public static final Property<User, Boolean> isAdmin = new Property<User, Boolean>();

  public static final Instantiator<User> User = new Instantiator<User>() {
    public User instantiate(PropertyLookup<User> lookup) {
      User user = new User();
      user.setEmployeeId(lookup.valueOf(employeeId, 1l));
      user.setFullName(lookup.valueOf(fullName, "new-fullName"));
      user.setPassword(lookup.valueOf(password, "new-password"));
      user.setIsActive(lookup.valueOf(isActive, true));
      user.setIsAdmin(lookup.valueOf(isAdmin, true));
      return user;
    }
  };
}
