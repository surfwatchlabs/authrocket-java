authrocket-java
===============

[AuthRocket](http://authrocket.com/) provides Auth as a Service, and this is a  (start of a) Java client for communicating with it.

Usage
-----

As of now, ain't much.

REST client and some patterns in place.  With 0.0.1 all that's really supported is GET methods for [memberships](https://authrocket.com/docs/api/memberships).

Example Usage
-------------

**applicationContext.xml**
```xml
<bean id="membershipClientImpl" class="com.surfwatchlabs.authrocket.service.MembershipClientImpl" >
  <property name="authRocketClient" ref="authRocketRESTClient" />
</bean>
<bean id="authRocketRESTClient" class="com.surfwatchlabs.authrocket.client.AuthRocketRESTClient" >
  <property name="authrocketAccountId" value="my-authrocket-account-id" />
  <property name="authrocketApiKey" value="my-authrocket-api-key" />
  <property name="authrocketDefaultRealmId" value="my-authrocket-realm" />
</bean>
```
**MyClass.java**
```java
MembershipClientImpl membershipClient = ..;
// holla at AuthRocket
Collection<Membership> memberships = membershipClient.getMembershipsByOrgId( "org_123abc" );
```

Contributing
------------

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request


License
-------

MIT
