create tablespace CTSEC_ACTIVITY_DATA datafile 'E:/app/dell/oradata/orcl/ctsec_activity_DATA.dbf' size 500m autoextend on extent management local segment space management auto;
 
 create user ctsec_activity identified by 123456 default tablespace ctsec_activity_DATA;
  grant create session TO ctsec_activity;
  grant create any table TO ctsec_activity;
   grant create any view TO ctsec_activity;
  grant connect,resource TO ctsec_activity;
  grant create public database link to ctsec_activity;
grant drop public database link to ctsec_activity;