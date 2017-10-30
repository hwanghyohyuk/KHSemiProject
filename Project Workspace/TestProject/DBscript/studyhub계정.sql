PROMPT DROP USER STUDYHUB...
DROP USER studyhub CASCADE;

PROMPT CREATE USER STUDYHUB...
CREATE USER studyhub IDENTIFIED BY studyhub;

PROMPT GRANT TO STUDYHUB...
GRANT CONNECT, DBA,RESOURCE TO studyhub;


grant create view to studyhub; 
--시스템 계정에서 위 권한 실행

ALTER SYSTEM SET JOB_QUEUE_PROCESSES = 10;
--시스템 계정에서 잡 스케줄러 실행을 위해 위 권한 실행

