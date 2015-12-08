create or replace procedure exportEmptyTableProc AUTHID CURRENT_USER AS
  CURSOR allUserTableCursor IS select table_name from user_tables where NUM_ROWS=0;
  tablename  VARCHAR2(50);
  execSql    VARCHAR2(200);
begin
  --增大输出缓存Buffer长度的上限，单位为bytes字节。将buffer_size设置为NULL即指定没有限制
  dbms_output.enable(NULL);
  --定义异常回滚点
  savepoint sp1;
  --设置deferred_segment_creation 参数为FALSE后，无论是空表还是非空表，都分配segment
  --该值设置后只对后面新增的表产生作用，对之前建立的空表不起作用
  --可以使用手工为空表分配Extent的方式，来解决导出之前建立的空表的问题
  execute immediate 'alter system set deferred_segment_creation=false';
  --打开游标
  open allUserTableCursor;
  --预先抓取一行数据并赋值给tablename变量
  fetch allUserTableCursor into tablename;
  --如果没有抓取到行数据则推出循环
  while allUserTableCursor%found loop
    --循环体以begin关键字开始
    begin
      execSql:='alter table '||tablename||' allocate extent';
      dbms_output.put_line(execSql||';');
      execute immediate execSql;
     --发生异常处理
     exception
      when others then
        begin
          dbms_output.put_line('发生错误');
          --发生异常回滚到相对应的回滚点
          rollback to savepoint sp1; --部分回滚
          --rollback; --全局回滚
        end;
     --循环体以begin关键字结束
    end;
    --循环抓取一行数据并赋值给tablename变量
    fetch allUserTableCursor into tablename;
  end loop;
  --关闭游标
  close allUserTableCursor;
  --没有发生异常则正常提交事务
  commit;
end exportEmptyTableProc;