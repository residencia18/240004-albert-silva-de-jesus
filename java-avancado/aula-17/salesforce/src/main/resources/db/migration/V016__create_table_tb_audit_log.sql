create sequence audit_log_seq start with 1 increment by 50;

create table if not exists tb_audit_log (
  id bigint not null,
  timestamp timestamp(6),
  event_name varchar(50) not null unique,
  affected_resource varchar(255),
  event_description varchar(255),
  origin varchar(255),
  user_id varchar(255),
  primary key (id)
);